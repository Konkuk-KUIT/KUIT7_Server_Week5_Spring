package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.MemberService;

public class MemberListServlet extends HttpServlet {

    private final MemberService service = MemberService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("members", service.findAll());

        req.getRequestDispatcher("/WEB-INF/views/members.jsp")
                .forward(req, res);
    }
}