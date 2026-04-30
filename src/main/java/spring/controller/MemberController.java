package spring.controller;

import spring.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.service.MemberService;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 목록
    @GetMapping
    public String list(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    // 회원 등록 폼
    @GetMapping("/new-form")
    public String form() {
        return "new-form";
    }

    // 회원 상세
    @GetMapping("/detail")
    public String detail(@RequestParam Long id, Model model) {
        model.addAttribute("member", memberService.findById(id));
        return "detail";
    }

    // 회원 저장
    @PostMapping("/save")
    public String save(@RequestParam String name) {
        memberService.save(new Member(name));
        return "redirect:/members";
    }
}
