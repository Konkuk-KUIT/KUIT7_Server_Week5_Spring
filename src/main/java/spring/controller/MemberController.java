package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.domain.Member;
import spring.service.MemberService;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(Model model,
                       @RequestParam("name") String name) {

        memberService.save(new Member(name));

        model.addAttribute("members", memberService.findAll());

        return "members";
    }

    @GetMapping("")
    public String list(Model model) {

        model.addAttribute("members", memberService.findAll());

        return "members";
    }

    @GetMapping("/detail")
    public String detail(Model model,
                         @RequestParam("id") Long id) {

        model.addAttribute("member", memberService.findById(id));
        return "detail";
    }
}
