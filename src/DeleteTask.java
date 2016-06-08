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
 * Created by Yggdrasil on 16/6/8.
 */

@WebServlet(name="DeleteTask",urlPatterns="/DeleteTask")

public class DeleteTask extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyHelp myHelp = new MyHelp();
        Check check = new Check();
        String target = "/ManageSuccess.jsp";
        String errorInfo = "";
        String successInfo = "删除成功";
        HttpSession httpSession = req.getSession();
        Connection connection = null;

        /**
         * 判断是否登陆
         */
        if(check.checkLog(httpSession)) {
            if(check.checkRoot(httpSession)) {
                /**
                 * 执行删除
                 */
                int delete_task_id = Integer.valueOf(req.getParameter("delete_task_id"));
                try {

                    /**
                     * 首先删除与之对应的所有SUBJECT
                     */
                    connection = myHelp.getConnectionToDB();
                    PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Subject WHERE task_id = ?");
                    preparedStatement.setInt(1, delete_task_id);
                    preparedStatement.executeUpdate();


                    /**
                     * 在SUBJECT中所有比删除TASK_ID大的TASK_ID自减1
                     */
                    preparedStatement = connection.prepareStatement("UPDATE Subject SET task_id = task_id-1 WHERE task_id > ?");
                    preparedStatement.setInt(1, delete_task_id);
                    preparedStatement.executeUpdate();


                    /**
                     *  删除该TASk
                     */

                    preparedStatement = connection.prepareStatement("DELETE FROM Task WHERE task_id = ?");
                    preparedStatement.setInt(1, delete_task_id);
                    preparedStatement.executeUpdate();

                    /**
                     * 在SUBJECT中所有比删除SUBJECT_ID大的SUBJECT_ID自减1
                     */
                    preparedStatement = connection.prepareStatement("UPDATE Task SET task_id = task_id-1 WHERE task_id > ?");
                    preparedStatement.setInt(1, delete_task_id);
                    preparedStatement.executeUpdate();


                } catch (Exception e) {
                    errorInfo = "删除失败!";
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
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";
        req.setAttribute("errorInfo", errorInfo);
        req.setAttribute("successInfo", successInfo);
        if(httpSession.getAttribute("user") != null){
            User user = (User)httpSession.getAttribute("user");
            user.setUser_lase_view_date();
        }
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }
}
