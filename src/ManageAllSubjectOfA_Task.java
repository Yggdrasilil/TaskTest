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
import java.sql.ResultSet;

/**
 * Created by Yggdrasil on 16/6/5
 */

@WebServlet(name="ManageAllSubjectOfA_Task",urlPatterns="/ManageAllSubjectOfA_Task")

public class ManageAllSubjectOfA_Task extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyHelp myHelp = new MyHelp();
        Task task = new Task();
        String target = "";
        String errorInfo = "";
        boolean isLog = false;
        boolean isRoot = false;
        HttpSession httpSession = req.getSession();

        /**
         * 判断是否登陆,是否好是管理员
         */
<<<<<<< HEAD
        if(check.checkLog(httpSession)) {
            if (check.checkRoot(httpSession)) {
                /**
                 * 得到要查看的作业id
                 */
                int check_task_id = Integer.valueOf(req.getParameter("check_task_id"));


                /**
                 * 创建TASK对象,获得该TASK的所有SUBJECT和CHOICE
                 */
                task = new Task(check_task_id);


                req.setAttribute("check_task_id", check_task_id);
                req.setAttribute("errorInfo", errorInfo);
                req.setAttribute("task", task);
                if (httpSession.getAttribute("user") != null) {
                    User user = (User) httpSession.getAttribute("user");
                    user.setUser_last_view_page("/ManageAllSubjectOfA_Task?check_task_id=" + check_task_id);
                    user.setUser_lase_view_date();
                }
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";
=======
        if(httpSession.getAttribute("isLog") != null)
            isLog = (boolean) httpSession.getAttribute("isLog");
        if(httpSession.getAttribute("isRoot") != null)
            isRoot = (boolean) httpSession.getAttribute("isRoot");
        if(isLog){
            target = "/CheckTasks";
            if(isRoot){
                target = "/ManageAllSubject.jsp";
            }
        } else {
            target = "/Login.jsp";
        }

        /**
         * 要查看的作业id
         */
        int check_task_id = Integer.valueOf(req.getParameter("check_task_id"));


        /**
         * 创建TASK对象,获得该TASK的所有SUBJECT和CHOICE
         */
        task = new Task(check_task_id);

        req.setAttribute("check_task_id",check_task_id);
        req.setAttribute("errorInfo", errorInfo);
        req.setAttribute("task", task);
>>>>>>> parent of f1d197e... Add some function
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }
}
