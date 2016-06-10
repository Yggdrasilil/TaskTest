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

@WebServlet(name="ManageAllSubject",urlPatterns="/ManageAllSubject")

public class ManageAllSubject extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();
        Task[] task;
        String target = "/ManageAllSubject.jsp";
        String errorInfo = "";
        HttpSession httpSession = req.getSession();
        MyHelp myHelp = new MyHelp();
        Connection connection = null;
        PreparedStatement preparedStatement;
        /**
         * 判断是否登陆,是否是管理员
         */

        if(check.checkLog(httpSession)) {
            if(check.checkRoot(httpSession)) {
                try {

                    connection = myHelp.getConnectionToDB();

                    /**
                     * TASK表统计数目创建TASK对象数组
                     */
                    preparedStatement = connection.prepareStatement("SELECT COUNT(*) c FROM Task");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    task = new Task[resultSet.getInt("c")];
                    for (int i = 0; i < task.length; i++) {
                        task[i] = new Task(i + 1);
                    }
                    req.setAttribute("task", task);
                } catch (Exception e) {
                    e.printStackTrace();
                    errorInfo = "查询数据库失败";
                    target = "/ManageError.jsp";
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (httpSession.getAttribute("user") != null) {
                    User user;
                    user = (User) httpSession.getAttribute("user");
                    user.setUser_lase_view_date();
                    user.setUser_last_view_page("/ManageAllSubject");
                }
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";

        req.setAttribute("errorInfo", errorInfo);
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }
}
