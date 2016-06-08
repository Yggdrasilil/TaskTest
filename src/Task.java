import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Yggdrasil on 16/6/4.
 */
public class Task {

    private Subject[] subject;

    private Connection connection;
    private MyHelp myHelp = new MyHelp();

    private int task_id;
    private String task_name;
    private int task_type;
    private String add_date;
    private String add_user;

    private int count_subject;
    private int count_score;

    /**
     * 可以得到该TASK的所有题目和选项
     * @param task_id
     */
    Task(int task_id){
        try {
            /**
             * 创建task对象,并赋值
             */
            connection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Task WHERE task_id = ?");
            preparedStatement.setInt(1,task_id);
            ResultSet resultSet ;
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                this.task_id = resultSet.getInt("task_id");
                this.task_name = resultSet.getString("task_name");
                this.add_date = resultSet.getString("add_date");
                this.add_user = resultSet.getString("add_user");
            }


            /**
             * 创建TOPIC数组对象,通过数据库得到TOPIC数
             */
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) c FROM Subject WHERE task_id = ?");
            preparedStatement.setInt(1,task_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            subject = new Subject[resultSet.getInt("c")];
            for(int i = 0; i < subject.length ; i++){
                subject[i] = new Subject(task_id , i+1);
            }

        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    /**
     * 无参构造
     */
    Task(){}

    public int getTask_id() {
        return task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public int getTask_type() {
        return task_type;
    }

    public String getAdd_date() {
        return add_date;
    }

    public String getAdd_user() {
        return add_user;
    }

    public int getCount_subject() {
        try{
            myHelp = new MyHelp();
            connection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) c FROM Subject WHERE task_id = ?");
            preparedStatement.setInt(1,task_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            count_subject = resultSet.getInt("c");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count_subject;
    }

    public int getCount_score(){
        try{
            myHelp = new MyHelp();
            connection = myHelp.getConnectionToDB();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) c FROM Score WHERE task_id = ?");
            preparedStatement.setInt(1,task_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            count_score = resultSet.getInt("c");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return count_score;
    }

    public Subject[] getSubject() {
        return subject;
    }

    public void setCount_score(int count_score) {
        this.count_score = count_score;
    }


    public void setSubject(Subject[] subject) {
        this.subject = subject;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public void setTask_type(int task_type) {
        this.task_type = task_type;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public void setAdd_user(String add_user) {
        this.add_user = add_user;
    }

    public void setCount_subject(int count_subject) {
        this.count_subject = count_subject;
    }

    public void setCount_scroe(int count_scroe) {
        this.count_score = count_scroe;
    }

}
