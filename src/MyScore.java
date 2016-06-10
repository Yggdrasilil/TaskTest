/**
 * Created by Yggdrasil on 16/6/10.
 */
public class MyScore {
    private String user_id;
    private int task_id;
    private float score;

    MyScore(int task_id, String user_id){
        this.task_id = task_id;
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void addScore() {
        this.score++;
    }

}
