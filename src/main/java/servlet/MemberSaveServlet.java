package servlet;

import domain.Member;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.MemberService;

public class MemberSaveServlet extends HttpServlet {

    private final MemberService service = MemberService.getInstance();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        service.save(new Member(name));

        res.sendRedirect("/members");
    }
}
