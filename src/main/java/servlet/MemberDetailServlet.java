package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.MemberService;

public class MemberDetailServlet extends HttpServlet {

    private final MemberService service = MemberService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(req.getParameter("id"));

        req.setAttribute("member", service.findById(id));

        req.getRequestDispatcher("/WEB-INF/views/detail.jsp")
                .forward(req, res);
    }
}