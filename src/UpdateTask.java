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
 * Created by Yggdrasil on 16/6/10.
 */

@WebServlet(name = "UpdateTask", urlPatterns = "/UpdateTask")
public class UpdateTask extends HttpServlet {
    int update_task_id = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();
        HttpSession httpSession = req.getSession();
        String target = "/UpdateTask.jsp";
        Task task;
        /**
         * 检查登陆权限
         */
        if(check.checkLog(httpSession)){
            if(check.checkRoot(httpSession)){
                /**
                 * 通过TASK_ID创建TASK对象,传入
                 */
                update_task_id = Integer.valueOf(req.getParameter("update_task_id"));
                task = new Task(update_task_id);
                req.setAttribute("update_task_name", task.getTask_name());
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        Check check = new Check();
        HttpSession httpSession = req.getSession();
        String target = "/ManageSuccess.jsp";
        Task task;
        MyHelp myHelp = new MyHelp();
        Connection connection = null;
        String errorInfo = "修改失败";
        String sucessInfo = "修改成功";

        /**
         * 检查登陆权限
         */
        if(check.checkLog(httpSession)){
            if(check.checkRoot(httpSession)){
                String update_task_name = req.getParameter("update_task_name");
                try {
                    /**
                     * 执行修改
                     */
                    connection = myHelp.getConnectionToDB();
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Task SET task_name = ? WHERE task_id = ?");
                    preparedStatement.setString(1, update_task_name);
                    preparedStatement.setInt(2, update_task_id);
                    preparedStatement.executeUpdate();
                } catch (Exception e) {
                    errorInfo = "连接数据库失败";
                    e.printStackTrace();
                } finally {
                    try {
                        if(connection != null)
                            connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";
        req.setAttribute("successInfo", sucessInfo);
        req.setAttribute("errorInfo", errorInfo);
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req, resp);
    }
}
