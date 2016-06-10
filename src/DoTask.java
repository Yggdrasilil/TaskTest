import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yggdrasil on 16/6/10.
 */
@WebServlet(name = "DoTask", urlPatterns = "/DoTask")
public class DoTask extends HttpServlet{

    private int now_subject_index = 0;
    private Subject[] subject;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        now_subject_index = 0;
        Check check = new Check();
        String target = "";
        HttpSession httpSession = req.getSession();
        MyScore myScore;
        if (check.checkLog(httpSession)) {
            User user = (User)httpSession.getAttribute("user");

            /**
             * 得到要做的TASK_ID
             */
            int do_task_id = Integer.valueOf(req.getParameter("do_task_id"));
            httpSession.setAttribute("do_task_id", do_task_id);
            /**
             * 创建该用户的SCORE对象
             */
            myScore = new MyScore(do_task_id, user.getUser_id());

            /**
             * 得到要做的TASK对象
             */
            Task do_task = new Task(do_task_id);

            /**
             * 得到TASK中所有题目
             */
            subject = do_task.getSubject();

            /**
             * 转向第一题类型界面
             */
            switch (subject[0].getSubject_type()) {
                case 1:
                    target = "/DoTask_SingleChoice.jsp";
                    break;
                case 2:
                    target = "/DoTask_T&F.jsp";
                    break;
                case 3:
                    target = "/DoTask_MultipleChoice.jsp";
                    break;
            }
            httpSession.setAttribute("myScore", myScore);
            httpSession.setAttribute("do_subject", subject[now_subject_index]);
        } else target = "/Login.jsp";
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();
        String target = "";
        HttpSession httpSession = req.getSession();

        if (check.checkLog(httpSession)) {

                /**
                 * 得到SESSION中的SCORE对象
                 */
                MyScore myScore = (MyScore) httpSession.getAttribute("myScore");

                /**
                 * 得到当前题目的所有choice
                 */
                Choice[] choice = subject[now_subject_index].getChoice();


                /**
                 * 单选题和判断题分数判断
                 */
                if (subject[now_subject_index].getSubject_type() == 1
                        || subject[now_subject_index].getSubject_type() == 2) {
                    int my_choice = Integer.valueOf(req.getParameter("my_choice"));
                    if (choice[my_choice - 1].getChoice_isTrue() == 1)
                        myScore.addScore();
                }

                /**
                 * 多选题分数判断
                 */
                else if (subject[now_subject_index].getSubject_type() == 3) {
                    String[] myChoices = req.getParameterValues("my_choice");
                    boolean temp = true;
                    /**
                     * 只要选择的有一题不为真就不加分
                     */
                    for (int i = 0; i < myChoices.length; i++) {
                        if (choice[Integer.valueOf(myChoices[i]) - 1].getChoice_isTrue() != 1)
                            temp = false;
                    }
                    if (temp == true)
                        myScore.addScore();
                }

                /**
                 * 下一题
                 */
                /**
                 * 如果做完就跳转向提交页面
                 */
                if(now_subject_index+1 < subject.length) {
                    now_subject_index++;
                    httpSession.setAttribute("do_subject", subject[now_subject_index]);
                    switch (subject[now_subject_index].getSubject_type()) {
                        case 2:
                            target = "/DoTask_T&F.jsp";
                            break;
                        case 1:
                            target = "/DoTask_SingleChoice.jsp";
                            break;
                        case 3:
                            target = "/DoTask_MultipleChoice.jsp";
                            break;
                    }
                } else target = "/TaskDown.html";
        } else target = "/Login.jsp";
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }
}
