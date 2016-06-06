import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

/**
 * Created by Yggdrasil on 16/6/5.
 */
public class Choice {
    private String choice_content;
    private int choice_id;
    private int subject_id;
    private int task_id;
    private int choice_isTrue;

    Connection connection;
    MyHelp myHelp = new MyHelp();

    /**
     * 得到唯一选项
     * @param task_id
     * @param subject_id
     * @param choice_id
     */
    Choice(int task_id,int subject_id,int choice_id){
        try{
            /**
             * 创建TOPIC对象,并赋值
             */
            connection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Choice WHERE task_id = ? AND subject_id = ? AND Choice.choice_id = ?");
            preparedStatement.setInt(1,task_id);
            preparedStatement.setInt(2,subject_id);
            preparedStatement.setInt(3,choice_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            choice_content = resultSet.getString("choice_content");
            choice_isTrue = resultSet.getInt("choice_isTrue");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if ( connection != null) {
                    connection.close();
                }
            } catch ( Exception e) {
                e.printStackTrace();
            }
        }
        this.task_id = task_id;
        this.subject_id = subject_id;
        this.choice_id = choice_id;
    }

    /**
     * 无参构造
     */
    Choice(){}


    public int getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(int choice_id) {
        this.choice_id = choice_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int topic_id) {
        this.subject_id = topic_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getChoice_content() {
        return choice_content;
    }

    public void setChoice_content(String choice_content) {
        this.choice_content = choice_content;
    }

    public int getChoice_isTrue() {
        return choice_isTrue;
    }

    public void setChoice_isTrue(int choice_isTrue) {
        this.choice_isTrue = choice_isTrue;
    }
}
