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
import java.sql.Statement;

/**
 * Created by Yggdrasil on 16/6/4.
 */
@WebServlet(name="Register",urlPatterns="/Register")

public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        MyHelp myHelp = new MyHelp();
        Connection connection = null;
        User user = new User();
        String target;
        String errorInfo = "";
        HttpSession httpSession = req.getSession();

        /**
         * 连接数据库
         */
        try{
            connection = myHelp.getConnectionToDB();
        } catch (Exception e){
            e.printStackTrace();
            errorInfo = "连接数据库失败";
            target = "/Register.jsp";
        }

        /**
         * 读取表单数据加入USER类;
         */
        user.setUser_id(req.getParameter("user_id"));
        user.setUser_name(req.getParameter("user_name"));
        user.setUser_class(req.getParameter("user_class"));
        user.setUser_dept(req.getParameter("user_dept"));
        user.setUser_password(req.getParameter("user_password"));
        user.setUser_sex(req.getParameter("user_sex"));

        /**
         * 验证用户资料格式,正确则加入数据库,错误返回重新输入
         */
        if(myHelp.checkPassword(user.getUser_password())){
            if(myHelp.checkOtherLength(user.getUser_class())
                    && myHelp.checkOtherLength(user.getUser_name())
                    && myHelp.checkOtherLength(user.getUser_dept())
                    && myHelp.checkIdOnly(user.getUser_id())
                    && myHelp.checkOtherLength(user.getUser_id())
                    && user.getUser_sex() != null){
                httpSession.setAttribute("isLog", true);
                target = "/CheckTasks.jsp";
                try {

                    /**
                     * 添加入数据库
                     */
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO User VALUES (?,?,?,?,?,?,?)");
                    preparedStatement.setString(1,user.getUser_id());
                    preparedStatement.setString(2,user.getUser_password());
                    preparedStatement.setString(3,user.getUser_name());
                    preparedStatement.setInt(4,1);
                    preparedStatement.setString(5,user.getUser_dept());
                    preparedStatement.setString(6,user.getUser_class());
                    preparedStatement.setString(7,user.getUser_sex());
                    preparedStatement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                    errorInfo = "添加数据库失败";
                    target = "/Register.jsp";
                } finally {
                    try{
                        if(connection != null)
                            connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } else {
                errorInfo = "用户数据有误,请重新填写";
                target = "/Register.jsp";
            }
        } else {
            errorInfo = "密码格式有误,请重新填写";
            target = "/Register.jsp";
        }

        /**
         * 转向页面
         */
        req.setAttribute("errorInfo", errorInfo);
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }
}
