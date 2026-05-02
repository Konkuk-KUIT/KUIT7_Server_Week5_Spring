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
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String memberList(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    @GetMapping("/detail")
    public String memberDetail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("member", memberService.findById(id));
        return "detail";
    }

    @GetMapping("/new-form")
    public String memberNewForm(Model model) {
        return "new-form";
    }

    @PostMapping("/save")
    public String saveMember(@RequestParam("name") String name) {
        memberService.save(new Member(name));
        return "redirect:/members";
    }

}