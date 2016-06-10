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
 * Created by Yggdrasil on 16/6/6.
 */

@WebServlet(name="AddTask",urlPatterns="/AddTask")

public class AddTask extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();
        String target;
        if(check.checkLog(req.getSession())){
            if(check.checkRoot(req.getSession())){
                target = "/AddTask.jsp";
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }






    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        Check check = new Check();
        MyHelp myHelp = new MyHelp();
        Connection connection = null;
        String errorInfo = "";
        String target = "/ManageSuccess.jsp";
        String successInfo = "添加成功";
        String task_name = req.getParameter("task_name");
        HttpSession httpSession = req.getSession();

        /**
         * 检查登陆
         */
        if(check.checkLog(req.getSession())) {
            if (check.checkRoot(req.getSession())) {
                try {
                    User user= (User)httpSession.getAttribute("user");

                    /**
                     * 得到TASK总行数
                     */
                    connection = myHelp.getConnectionToDB();
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) c FROM Task");
                    ResultSet resultset = preparedStatement.executeQuery();
                    int task_id = 100;
                    if (resultset.next())
                        task_id = resultset.getInt("c");

                    /**
                     * 插入
                     */
                    preparedStatement = connection.prepareStatement("INSERT INTO Task(task_id, task_name, add_user) VALUES (?,?,?)");
                    preparedStatement.setInt(1, task_id + 1);
                    preparedStatement.setString(2, task_name);
                    preparedStatement.setString(3, user.getUser_name());
                    preparedStatement.executeUpdate();
                } catch (Exception e) {
                    errorInfo = "链接数据库失败";
                    target = "/ManageError.jsp";
                    e.printStackTrace();
                } finally {
                    try {
                        if (connection != null)
                            connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";
        req.setAttribute("successInfo", successInfo);
        req.setAttribute("errorInfo", errorInfo);
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req, resp);
    }
}
