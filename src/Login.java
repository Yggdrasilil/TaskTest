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
 * Created by Yggdrasil on 16/6/4
 */
@WebServlet(name="Login",urlPatterns="/Login")

public class Login extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String target = "";
        boolean isLog = false;
        boolean isRoot = false;
        HttpSession httpSession = req.getSession();

        /**
         * 判断是否登陆
         */
        if(httpSession.getAttribute("isLog") != null)
            isLog = (boolean) httpSession.getAttribute("isLog");
        if(httpSession.getAttribute("isRoot") != null)
            isRoot = (boolean) httpSession.getAttribute("isRoot");
        if(isLog){
            target = "/CheckTasks";
            if(isRoot){
                target = "/ManageAllTasks";
            }
        } else {
            target = "/Login.jsp";
        }
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        String target = "";
        boolean isRoot = false;
        boolean isLog = false;
        User user = new User();
        MyHelp myHelp = new MyHelp();
        Connection collection = null;
        String errorInfo = "";
        String successInfo = "欢迎!";

        /**
         * 从数据库查询用户数据
         */
        String temp_id = req.getParameter("user_id");
        String temp_password = req.getParameter("user_password");
        try {
            collection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = collection.prepareStatement("SELECT * FROM User WHERE user_id = ? AND user_password = ?");
            preparedStatement.setString(1, temp_id);
            preparedStatement.setString(2, temp_password);
            ResultSet resultSet = preparedStatement.executeQuery();
            //resultSet.next();
            if(resultSet.next()){
                isLog = true;
                if(0 == resultSet.getInt("user_limit")){
                    isRoot = true;
                    successInfo += "管理员,";
                }
                successInfo += resultSet.getString("user_name");
            } else {
                errorInfo = "用户名或密码错误";
            }
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("isLog", isLog);
            httpSession.setAttribute("isRoot", isRoot);
            httpSession.setAttribute("successInfo", successInfo);
        }catch (Exception e){
            e.printStackTrace();
            errorInfo = "查询数据库失败";
        } finally {
            try {
                if (collection != null){
                    collection.close();
                }
                req.setAttribute("errorInfo", errorInfo);
                doGet(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
