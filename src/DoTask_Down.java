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
 * Created by Yggdrasil on 16/6/10.
 */
@WebServlet(name = "DoTask_Down", urlPatterns = "/DoTask_Down")
public class DoTask_Down extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        MyScore myScore = (MyScore) httpSession.getAttribute("myScore");
        int do_task_id = (int)httpSession.getAttribute("do_task_id");
        Task task = new Task(do_task_id);

        myScore.setScore(myScore.getScore()/task.getCount_subject());
        req.setAttribute("final_score",myScore.getScore());


        httpSession.setAttribute("myScore", null);
        httpSession.setAttribute("do_subject", null);

        ServletContext ctx = getServletContext();
        RequestDispatcher dp = ctx.getRequestDispatcher("/Result.jsp");
        dp.forward(req,resp);
    }
}
