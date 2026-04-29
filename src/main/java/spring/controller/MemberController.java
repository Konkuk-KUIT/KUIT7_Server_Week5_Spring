package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.domain.Member;
import spring.service.MemberService;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam String name) {
        memberService.save(new Member(name));

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", memberService.findAll());
        return mv;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", memberService.findAll());
        return mv;
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("detail");
        mv.addObject("member", memberService.findById(id));
        return mv;
    }
}
