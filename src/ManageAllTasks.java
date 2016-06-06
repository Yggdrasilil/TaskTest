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
import java.util.Date;

/**
 * Created by Yggdrasil on 16/6/4
 */
@WebServlet(name="ManageAllTasks",urlPatterns="/ManageAllTasks")

public class ManageAllTasks extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyHelp myHelp = new MyHelp();
        Check check = new Check();
        Task[] task = null;
        User user;
        String target = "/ManageAllTasks.jsp";
        String errorInfo = "";
        HttpSession httpSession = req.getSession();
        Connection connection = null;

        /**
         * 判断是否登陆
         */
        target = check.checkRootLog(httpSession,target);

        try{
            /**
             * 连接数据库
             */
            connection = myHelp.getConnectionToDB();

            /**
             * 通过TASK表统计数目创建TASK对象数组
             */
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) c FROM Task");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            task = new Task[resultSet.getInt("c")];
            for( int i = 0 ; i < task.length ; i++){
                task[i] = new Task(i+1);
            }
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
        if(httpSession.getAttribute("user") != null) {
            user = (User) httpSession.getAttribute("user");
            user.setUser_lase_view_date();
            user.setUser_last_view_page("/ManageAllTasks");
        }
        req.setAttribute("errorInfo", errorInfo);
        req.setAttribute("task", task);
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }
}
