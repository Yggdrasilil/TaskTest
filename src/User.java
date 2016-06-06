import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yggdrasil on 16/6/4.
 */
public class User {
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_dept;
    private String user_class;
    private String user_sex;
    private boolean user_isRoot;
    private String user_last_view_page;
    private String user_lase_view_date;

    User(){}

    User(String user_id){
        /**
         * 根据USER_ID初始化用户数据
         */
        MyHelp myHelp = new MyHelp();
        Connection connection = null;
        try {
            connection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE user_id = ?");
            preparedStatement.setString(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                this.user_id = resultSet.getString("user_id");
                this.user_password = resultSet.getString("user_password");
                this.user_name = resultSet.getString("user_name");
                this.user_dept = resultSet.getString("user_dept");
                this.user_class = resultSet.getString("user_class");
                this.user_sex = resultSet.getString("user_sex");
                if(resultSet.getInt("user_limit") == 0 ){
                    user_isRoot = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 从数据库得到最新数据
     */
    public String getUser_lase_view_date() {


        MyHelp myHelp = new MyHelp();
        Connection connection = null;
        try {
            connection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM User WHERE user_id = ?");
            preparedStatement.setString(1,user_id);
            preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user_lase_view_date;
    }

    /**
     * 更新最后一次登陆数据
     */
    public void setUser_lase_view_date() {
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);


        MyHelp myHelp = new MyHelp();
        Connection connection = null;
        try {
            connection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE User SET user_last_view_date = ? WHERE user_id = ?");
            preparedStatement.setString(1, time);
            preparedStatement.setString(2, user_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getUser_last_view_page() {
        return user_last_view_page;
    }

    public void setUser_last_view_page(String user_last_view_page) {
        this.user_last_view_page = user_last_view_page;
    }

    public boolean getUser_isRoot() {
        return user_isRoot;
    }

    public void setUser_isRoot(boolean user_isRoot) {
        this.user_isRoot = user_isRoot;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_dept() {
        return user_dept;
    }

    public String getUser_class() {
        return user_class;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_dept(String user_dept) {
        this.user_dept = user_dept;
    }

    public void setUser_class(String user_class) {
        this.user_class = user_class;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
}
