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
 * Created by Yggdrasil on 16/6/7.
 */

@WebServlet(name="AddSubject",urlPatterns="/AddSubject")

public class AddSubject extends HttpServlet{
    User user;
    Check check = new Check();
    String target;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if(check.checkLog(httpSession)){
            if(check.checkRoot(httpSession)){

                /**
                 * 得到要添加处的TASK_ID和SUBJECT_ID 设为SESSION
                 */
                String task_id = req.getParameter("task_id");
                String subject_id = req.getParameter("subject_id");
                httpSession.setAttribute("task_id", task_id);
                httpSession.setAttribute("subject_id", Integer.valueOf(subject_id)+1);
                target = "/AddSubject.jsp";
            } else target="/CheckTasks.jsp";
        } else target = "/Login.jsp";


        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");

        Subject[] subject;
        int subject_num;
        int subject_type = 0;                      //这次选择的TYPE
        HttpSession httpSession = req.getSession();
        String successInfo = "";
        String errorInfo = "";

        /**
         * 检查登陆状态
         */
        if(check.checkLog(req.getSession())){
            if(check.checkRoot(req.getSession())){

                /**
                 * 从SESSION得到要添加的SUBJECT,如果没有就新建
                 */
                if(httpSession.getAttribute("subject") != null) {
                    subject = (Subject[]) httpSession.getAttribute("subject");
                    subject_num = (int) httpSession.getAttribute("subject_num");
                    subject_type = (int) httpSession.getAttribute("subject_type");
                }
                else {
                    subject = new Subject[30];
                    subject_num = 0;
                    httpSession.setAttribute("subject", subject);
                    httpSession.setAttribute("subject_num", subject_num);
                }
                if(req.getParameter("subject_title") != null) {


                    /**
                     * 设置题目内容
                     */
                    int task_id = Integer.valueOf(httpSession.getAttribute("task_id").toString());
                    int subject_id = Integer.valueOf(httpSession.getAttribute("subject_id").toString());

                    subject[subject_num] = new Subject();

                    subject[subject_num].setTask_id(task_id);
                    subject[subject_num].setSubject_id(subject_id);
                    subject[subject_num].setSubject_title(req.getParameter("subject_title"));
                    subject[subject_num].setSubject_content(req.getParameter("subject_content"));
                    subject[subject_num].setSubject_type(subject_type);

                    /**
                     * 先循环遍历得到所有选项的内容
                     */
                    int loopVar = 0;
                    subject[subject_num].choice = new Choice[10];
                    while (req.getParameter("choice_content" + (loopVar+1)) != null) {

                        subject[subject_num].choice[loopVar] = new Choice();

                        subject[subject_num].choice[loopVar].setTask_id(task_id);
                        subject[subject_num].choice[loopVar].setSubject_id(subject_id);
                        subject[subject_num].choice[loopVar].setChoice_id(loopVar + 1);
                        subject[subject_num].choice[loopVar].setChoice_content(req.getParameter("choice_content"+(loopVar+1)));
                        loopVar++;
                    }


                    if(req.getParameterValues("choice_isTrue") != null) {

                        /**
                         * 循环遍历得到多选选项真假
                         */
                        if (subject_type == 3) {
                            String[] choice_isTrue = req.getParameterValues("choice_isTrue");
                            for (int i = 0; i < choice_isTrue.length; i++) {
                                subject[subject_num].choice[Integer.valueOf(choice_isTrue[i]) - 1].setChoice_isTrue(1);
                            }
                        }
                        /**
                         * 得到单选选项真假
                         */
                        else if (subject_type == 1) {
                            int choice_isTrue = Integer.valueOf(req.getParameter("choice_isTrue"));
                            subject[subject_num].choice[choice_isTrue - 1 ].setChoice_isTrue(1);
                        }
                        /**
                         * 得到判断真假
                         */
                        else {
                            int choice_isTrue = Integer.valueOf(req.getParameter("choice_isTrue"));
                            subject[subject_num].choice[choice_isTrue].setChoice_isTrue(1);
                        }
                    }
                    /**
                     * SUBJECT对象数加1,SUBJECT_ID也加1,和SUBJECT一起传入SESSION
                     */
                    httpSession.setAttribute("subject_id", subject[subject_num].getSubject_id()+1);
                    httpSession.setAttribute("subject_num", subject_num+1);
                    httpSession.setAttribute("subject", subject);
                }


                switch (Integer.valueOf(req.getParameter("subject_type"))) {
                    case 1: target = "/AddSubject_SingleChoice.jsp";httpSession.setAttribute("subject_type", 1);break;
                    case 2: target = "/AddSubject_T&F.jsp";httpSession.setAttribute("subject_type", 2);break;
                    case 3: target = "/AddSubject_MultipleChoice.jsp";httpSession.setAttribute("subject_type", 3);break;
                }
            } else target="/CheckTasks.jsp";
        } else target = "/Login.jsp";


        req.setAttribute("successInfo", successInfo);
        req.setAttribute("errorInfo", errorInfo);
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req, resp);
    }
}
