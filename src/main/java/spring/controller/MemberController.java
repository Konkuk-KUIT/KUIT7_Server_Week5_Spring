package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import spring.domain.Member;
import spring.service.MemberService;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/new-form")
    public String form() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam String name, Model model) {
        memberService.save(new Member(name));
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Long id, Model model) {
        model.addAttribute("member", memberService.findById(id));
        return "detail";
    }
}
