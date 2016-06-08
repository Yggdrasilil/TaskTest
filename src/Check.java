import javax.servlet.http.HttpSession;

/**
 * Created by Yggdrasil on 16/6/6.
 */
public class Check {

    /**
     * 判断是否登陆与权限
     * @param httpSession HTTP事务
     * @return
     */
    boolean checkLog(HttpSession httpSession){
        boolean isLog = false;
        /**
         * 判断是否登陆,已经登陆的管理员进入ManageAllTasks页面,已经登陆的学生进入CheckTasks页面
         */
        if(httpSession.getAttribute("isLog") != null)
            isLog = (boolean)httpSession.getAttribute("isLog");
        if(isLog)
            return true;
        else
            return false;
    }

    boolean checkRoot(HttpSession httpSession){
        User user = null;
        boolean isRoot = false;
        if(httpSession.getAttribute("user") != null) {
            user = (User) httpSession.getAttribute("user");
            if (user.getUser_isRoot())
                return true;
            else
                return false;
        } else
            return  false;
    }
}
