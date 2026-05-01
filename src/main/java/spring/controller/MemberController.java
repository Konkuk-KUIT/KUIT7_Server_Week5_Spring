package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.service.MemberService;
import spring.domain.Member;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/new-form")
    public String newform() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name) {
        memberService.save(new Member(name));
        return "redirect:/members";
    }

    @GetMapping
    public String members(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("member", memberService.findById(id));
        return "detail";
    }
}
