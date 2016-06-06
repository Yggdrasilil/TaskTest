import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Yggdrasil on 16/6/5
 */

@WebServlet(name="ManageAllSubjectOfA_Task",urlPatterns="/ManageAllSubjectOfA_Task")

public class ManageAllSubjectOfA_Task extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();
        Task task;
        String target = "/ManageAllSubjectOfA_Task.jsp";
        String errorInfo = "";
        HttpSession httpSession = req.getSession();

        /**
         * 判断是否登陆,已经登陆的管理员进入ManageAllSubject页面,已经登陆的学生进入CheckTasks页面
         */
        target = check.checkRootLog(httpSession, target);

        /**
         * 得到要查看的作业id
         */
        int check_task_id = Integer.valueOf(req.getParameter("check_task_id"));


        /**
         * 创建TASK对象,获得该TASK的所有SUBJECT和CHOICE
         */
        task = new Task(check_task_id);


        req.setAttribute("check_task_id",check_task_id);
        req.setAttribute("errorInfo", errorInfo);
        req.setAttribute("task", task);
        if(httpSession.getAttribute("user") != null) {
            User user = (User) httpSession.getAttribute("user");
            user.setUser_last_view_page("/ManageAllSubjectOfA_Task?check_task_id="+check_task_id);
            user.setUser_lase_view_date();
        }
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }
}
