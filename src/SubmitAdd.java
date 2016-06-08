import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yggdrasil on 16/6/8.
 */
@WebServlet(name = "SubmitAdd" , urlPatterns = "/SubmitAdd")
public class SubmitAdd extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String successInfo = "添加成功";
        String errorInfo = "添加失败";
        String target = "/ManageSuccess.jsp";
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("subject") != null){
            Subject[] subject = (Subject[]) httpSession.getAttribute("subject");
            for(int i = 0 ; subject[i] != null ; i++){
                if(!subject[i].addToDB()) target = "/ManageSuccess.jsp";
            }
        }
        httpSession.setAttribute("subject", null);
        httpSession.setAttribute("task_id", null);
        httpSession.setAttribute("subject_id", null);
        httpSession.setAttribute("subject_num", null);
        req.setAttribute("successInfo", successInfo);
        req.setAttribute("errorInfo", errorInfo);
        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher(target);
        dp.forward(req,resp);
    }
}
