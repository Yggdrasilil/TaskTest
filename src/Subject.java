import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Created by Yggdrasil on 16/6/5.
 */
public class Subject {

    Choice choice[];

    private int task_id;
    private int subject_id;
    private String subject_title;
    private String subject_content;
    private int subject_type;

    private Connection connection;
    private MyHelp myHelp = new MyHelp();

    /**
     * 可以得到该SUBJECT的所有选项
     * @param task_id
     * @param subject_id
     */
    Subject(int task_id , int subject_id){

        try{
            /**
             * 创建SUBJECT对象,并赋值
             */
            connection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Subject WHERE task_id = ? AND subject_id = ?");
            preparedStatement.setInt(1,task_id);
            preparedStatement.setInt(2,subject_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            subject_title = resultSet.getString("subject_title");
            subject_content = resultSet.getString("subject_content");
            subject_type = resultSet.getInt("subject_type");

            /**
             * 创建CHOICE数组对象,从数据库得到CHOICE数
             */
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) c FROM Choice WHERE task_id = ? AND subject_id = ?");
            preparedStatement.setInt(1,task_id);
            preparedStatement.setInt(2,subject_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            choice = new Choice[resultSet.getInt("c")];
            for(int i = 0 ; i < choice.length ; i++){
                choice[i] = new Choice(task_id, subject_id , i+1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if( connection != null){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.task_id = task_id;
        this.subject_id = subject_id;
    }

    /**
     * 无参构造
     */
    Subject(){}

    public Choice[] getChoice() {
        return choice;
    }

    public void setChoice(Choice[] choice) {
        this.choice = choice;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_title() {
        return subject_title;
    }

    public String getSubject_content() {
        return subject_content;
    }

    public int getSubject_type() {
        return subject_type;
    }

    public void setSubject_title(String subject_title) {
        this.subject_title = subject_title;
    }

    public void setSubject_content(String subject_content) {
        this.subject_content = subject_content;
    }

    public void setSubject_type(int topic_type) {
        this.subject_type = topic_type;
    }
}
