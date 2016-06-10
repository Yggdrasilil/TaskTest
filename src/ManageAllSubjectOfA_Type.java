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

@WebServlet(name="ManageAllSubjectOfA_Type",urlPatterns="/ManageAllSubjectOfA_Type")

public class ManageAllSubjectOfA_Type extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();
        MyHelp myHelp = new MyHelp();
        Connection connection = null;
        String target = "/ManageAllSubjectOfA_Type.jsp";
        String errorInfo = "";
        HttpSession httpSession = req.getSession();
        int subject_count;
        Subject[] subject = null;

        /**
         * 判断是否登陆,是否是管理员
         */
        if(check.checkLog(httpSession)) {
            if (check.checkRoot(httpSession)) {
                /**
                 * 得到要查看的作业type
                 */
                int check_subject_type = Integer.valueOf(req.getParameter("check_subject_type"));


                try{
                    /**
                     * 获得该TYPE的所有SUBJECT总数
                     */
                    connection = myHelp.getConnectionToDB();
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) c FROM Subject WHERE subject_type = ?");
                    preparedStatement.setInt(1,check_subject_type);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()) {
                        subject_count = resultSet.getInt("c");
                        subject = new Subject[subject_count];

                    }

                    /**
                     * 获得所有该TYPE的SUBJECT
                     */
                    preparedStatement = connection.prepareStatement("SELECT * FROM Subject WHERE subject_type = ? ORDER BY task_id");
                    preparedStatement.setInt(1, check_subject_type);
                    resultSet = preparedStatement.executeQuery();
                    int loopVar = 0;
                    while(resultSet.next()){
                        subject[loopVar] = new Subject(resultSet.getInt("task_id"), resultSet.getInt("subject_id"));
                        loopVar++;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    errorInfo = "连接数据库失败";
                    target = "/ManageError.jsp";
                } finally {
                    try{
                        if(connection != null){
                            connection.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                req.setAttribute("check_subject_type", check_subject_type);
                req.setAttribute("errorInfo", errorInfo);
                req.setAttribute("subject", subject);
                if (httpSession.getAttribute("user") != null) {
                    User user = (User) httpSession.getAttribute("user");
                    user.setUser_last_view_page("/ManageAllSubjectOfA_Type?check_subject_type=" + check_subject_type);
                    user.setUser_lase_view_date();
                }
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }
}
