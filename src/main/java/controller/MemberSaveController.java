package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberSaveController implements Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");

        Member member = new Member(name);
        service.save(member);

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", service.findAll());

        return mv;
    }
}