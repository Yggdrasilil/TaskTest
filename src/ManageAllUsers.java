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
 * Created by Yggdrasil on 16/6/10.
 */
@WebServlet(name = "ManageAllUsers", urlPatterns = "/ManageAllUsers")
public class ManageAllUsers extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Check check = new Check();
        HttpSession httpSession = req.getSession();
        String target = "/ManageAllUsers.jsp";
        Connection connection = null;
        int user_num = 0;
        User[] user;
        MyHelp myHelp = new MyHelp();
        if(check.checkLog(httpSession)){
            if(check.checkRoot(httpSession)){

                try{
                    /**
                     * 得到用户总数来创建用户数组
                     */
                    connection = myHelp.getConnectionToDB();
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) c FROM User");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next())
                       user_num = resultSet.getInt("c");
                    user = new User[user_num];

                    preparedStatement = connection.prepareStatement("SELECT * FROM User");
                    resultSet = preparedStatement.executeQuery();


                    for(int i = 0 ; resultSet.next() ; i++){
                        user[i] = new User(resultSet.getString("user_id"));
                    }

                    req.setAttribute("check_user", user);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(connection != null)
                            connection.close();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            } else target = "/CheckTasks.jsp";
        } else target = "/Login.jsp";

        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req, resp);
    }
}
