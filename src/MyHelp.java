import com.sun.deploy.net.HttpRequest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yggdrasil on 16/6/4
 */
public class MyHelp {

    Connection getConnectionToDB() throws NamingException, SQLException {
        Connection connection;
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup("java:comp/env/YggDB");
        connection = dataSource.getConnection();
        return connection;
    }


    boolean checkPassword(String password){
        int loopVar = 0;
        String temp = "";
        if(!"".equals(password) && password.length() < 20) {
            while (loopVar < (temp = String.valueOf(password)).length()) {
                if (temp.charAt(loopVar) < '0' || temp.charAt(loopVar) > '9') {
                    return false;
                }
                loopVar++;
            }
        }else return false;
        return true;
    }

    boolean checkOtherLength(String user_name){
        if(!"".equals(user_name) && user_name.length() < 20){
            return true;
        }
        return false;
    }

    boolean checkIdOnly(String user_id){
        Connection connection = null;
        try{
            connection = getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE user_id = ?");
            preparedStatement.setString(1,user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(!resultSet.next()){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
