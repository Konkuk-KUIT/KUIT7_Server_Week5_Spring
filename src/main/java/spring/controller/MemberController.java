package spring.controller;

import spring.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService service;

    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("member", service.findById(id));
        return "detail";
    }

    @GetMapping("/new-form")
    public String form() {
        return "new-form";
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("members", service.findAll());
        return "members";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name, Model model) {
        Member member = new Member(name);
        service.save(member);

        model.addAttribute("members", service.findAll());
        return "redirect:/members";
    }
}
