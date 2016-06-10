import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Yggdrasil on 16/6/9.
 */
@WebServlet(name = "UpdateSubject", urlPatterns = "/UpdateSubject")
public class UpdateSubject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();
        HttpSession httpSession = req.getSession();
        String target = "";
        /**
         * 检查登陆状态
         */
        if(check.checkLog(httpSession)) {
            if(check.checkRoot(httpSession)) {
                /**
                 * 得到要更新的TASK_ID和SUBJECT_ID
                 */
                int update_task_id = Integer.valueOf(req.getParameter("update_task_id"));
                int update_subject_id = Integer.valueOf(req.getParameter("update_subject_id"));
                int update_subject_type = Integer.valueOf(req.getParameter("update_subject_type"));
                httpSession.setAttribute("update_task_id", update_task_id);
                httpSession.setAttribute("update_subject_id", update_subject_id);
                httpSession.setAttribute("update_subject_type", update_subject_type);

                /**
                 * 通过TASK_ID和SUBJECT_ID得到其所有内容,传request中
                 */
                Subject subject = new Subject(update_task_id, update_subject_id);
                req.setAttribute("subject", subject);

                /**
                 * 要转入的页面
                 */
                switch (update_subject_type){
                    case 1: target = "/UpdateSubject_SingleChoice.jsp";break;
                    case 2: target = "/UpdateSubject_T&F.jsp";break;
                    case 3: target = "/UpdateSubject_MultipleChoice.jsp";break;
                }
                req.setAttribute("update_task_id", update_task_id);
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }







    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        Subject subject;
        HttpSession httpSession = req.getSession();
        Check check = new Check();
        String target = "/ManageSuccess.jsp";
        String errorInfo = "修改失败";
        String successInfo = "修改成功";


        if (check.checkLog(httpSession)) {
            if (check.checkRoot(httpSession)) {
                if (req.getParameter("subject_title") != null) {

                    /**
                     * 设置题目内容
                     */
                    int update_task_id = Integer.valueOf(httpSession.getAttribute("update_task_id").toString());
                    int update_subject_id = Integer.valueOf(httpSession.getAttribute("update_subject_id").toString());
                    int update_subject_type = Integer.valueOf(httpSession.getAttribute("update_subject_type").toString());
                    subject = new Subject();

                    subject.setTask_id(update_task_id);
                    subject.setSubject_id(update_subject_id);
                    subject.setSubject_title(req.getParameter("subject_title"));
                    subject.setSubject_content(req.getParameter("subject_content"));
                    subject.setSubject_type(update_subject_type);


                    /**
                     * 循环遍历得到所有选项的内容
                     */
                    int loopVar = 0;
                    subject.choice = new Choice[10];
                    while (req.getParameter("choice_content" + (loopVar + 1)) != null) {

                        subject.choice[loopVar] = new Choice();

                        subject.choice[loopVar].setTask_id(update_task_id);
                        subject.choice[loopVar].setSubject_id(update_subject_id);
                        subject.choice[loopVar].setChoice_id(loopVar + 1);
                        subject.choice[loopVar].setChoice_content(req.getParameter("choice_content" + (loopVar + 1)));
                        loopVar++;
                    }


                    if (req.getParameterValues("choice_isTrue") != null) {

                        /**
                         * 循环遍历得到多选选项真假
                         */
                        if (update_subject_type == 3) {
                            String[] choice_isTrue = req.getParameterValues("choice_isTrue");
                            for (int i = 0; i < choice_isTrue.length; i++) {
                                subject.choice[Integer.valueOf(choice_isTrue[i]) - 1].setChoice_isTrue(1);
                            }
                        }
                        /**
                         * 得到单选选项真假
                         */
                        else if (update_subject_type == 1) {
                            int choice_isTrue = Integer.valueOf(req.getParameter("choice_isTrue"));
                            subject.choice[choice_isTrue].setChoice_isTrue(1);
                        }
                        /**
                         * 得到判断真假
                         */
                        else {
                            int choice_isTrue = Integer.valueOf(req.getParameter("choice_isTrue"));
                            subject.choice[choice_isTrue].setChoice_isTrue(1);
                        }
                    }


                    MyHelp myHelp = new MyHelp();
                    Connection connection = null;
                    try {
                        /**
                         * 先删除SUBJECT
                         */
                        connection = myHelp.getConnectionToDB();
                        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Subject WHERE task_id = ? AND subject_id = ?");
                        preparedStatement.setInt(1, update_task_id);
                        preparedStatement.setInt(2, update_subject_id);
                        preparedStatement.executeUpdate();

                        /**
                         * 删除choice
                         */
                        preparedStatement = connection.prepareStatement("DELETE FROM Choice WHERE task_id = ? AND subject_id = ?");
                        preparedStatement.setInt(1, update_task_id);
                        preparedStatement.setInt(2, update_subject_id);
                        preparedStatement.executeUpdate();

                        /**
                         * 再添加
                         */
                        subject.addToDB();
                        req.setAttribute("successInfo", successInfo);
                    } catch (Exception e) {
                        target = "/ManageError.jsp";
                        e.printStackTrace();
                    } finally {
                        try {
                            if (connection != null) {
                                connection.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";
        req.setAttribute("errorInfo", errorInfo);
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);


    }
}
