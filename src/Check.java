import javax.servlet.http.HttpSession;

/**
 * Created by Yggdrasil on 16/6/6.
 */
public class Check {

    /**
     * 判断是否登陆与权限
     * @param httpSession HTTP事务
     * @param target 如果登陆且是管理员转向的页面
     * @return
     */
    String checkRootLog(HttpSession httpSession , String target){
        User user;
        boolean isLog = false;
        boolean isRoot = false;
        String returnTarget = "/Login.jsp";

        /**
         * 判断是否登陆,已经登陆的管理员进入ManageAllTasks页面,已经登陆的学生进入CheckTasks页面
         */
        if(httpSession.getAttribute("isLog") != null)
            isLog = (boolean)httpSession.getAttribute("isLog");
            if (isLog) {
                user = (User) httpSession.getAttribute("user");
                isRoot = user.getUser_isRoot();
                returnTarget = "/CheckTasks";
                if (isRoot) {
                    returnTarget = target;
                }
            } else {
                returnTarget = "/Login.jsp";
            }
            return returnTarget;

    }
}
