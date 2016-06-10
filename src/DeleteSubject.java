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
import java.util.Date;

/**
 * Created by Yggdrasil on 16/6/6.
 */
@WebServlet(name="DeleteSubject",urlPatterns="/DeleteSubject")

public class DeleteSubject extends HttpServlet{
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
                 * 得到要删除的SUBJECT_ID和TASK_ID
                 */
                int delete_subject_id = Integer.valueOf(req.getParameter("delete_subject_id"));
                int delete_task_id = Integer.valueOf(req.getParameter("delete_task_id"));
                try {

                    /**
                     * 首先删除与之对应的所有CHOICE
                     */
                    connection = myHelp.getConnectionToDB();
                    PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Choice WHERE subject_id = ? AND task_id = ?");
                    preparedStatement.setInt(1, delete_subject_id);
                    preparedStatement.setInt(2, delete_task_id);
                    preparedStatement.executeUpdate();


                    /**
                     * 在CHOICE中所有比删除SUBJECT_ID大的SUBJECT_ID自减1
                     */
                    preparedStatement = connection.prepareStatement("UPDATE Choice SET subject_id = subject_id-1 WHERE subject_id > ? AND task_id = ?");
                    preparedStatement.setInt(1, delete_subject_id);
                    preparedStatement.setInt(2, delete_task_id);
                    preparedStatement.executeUpdate();

                    /**
                     * 删除该SUBJECT
                     */
                    preparedStatement = connection.prepareStatement("DELETE FROM Subject WHERE subject_id = ? AND task_id = ?");
                    preparedStatement.setInt(1, delete_subject_id);
                    preparedStatement.setInt(2, delete_task_id);
                    preparedStatement.executeUpdate();

                    /**
                     * 在SUBJECT中所有比删除SUBJECT_ID大的SUBJECT_ID自减1
                     */
                    preparedStatement = connection.prepareStatement("UPDATE Subject SET subject_id = subject_id-1 WHERE subject_id > ? AND task_id = ?");
                    preparedStatement.setInt(1, delete_subject_id);
                    preparedStatement.setInt(2, delete_task_id);
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
