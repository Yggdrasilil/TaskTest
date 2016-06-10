import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Yggdrasil on 16/6/10.
 */

@WebServlet(name = "ChangeLimit", urlPatterns = "/ChangeLimit")
public class ChangeLimit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String target = "/ManageAllUsers";
        String user_id = req.getParameter("user_id");
        Connection connection;
        MyHelp myHelp = new MyHelp();
        try{
            connection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT user_limit FROM User WHERE user_id = ?");
            preparedStatement.setString(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement = connection.prepareStatement("UPDATE User SET user_limit = ? WHERE user_id = ?");
            if(resultSet.next()){
                if(resultSet.getInt("user_limit") == 1){
                    preparedStatement.setInt(1, 0);
                    preparedStatement.setString(2, user_id);
                } else {
                    preparedStatement.setInt(1, 1);
                    preparedStatement.setString(2, user_id);

                }
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e){
                e.printStackTrace();
            }
        }
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req, resp);
    }
}
