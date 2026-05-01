package spring.controller;

import domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import spring.service.MemberService;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    // 🔹 목록 (MemberListController)
    @GetMapping
    public String list(Model model) {
        model.addAttribute("members", service.findAll());
        return "members";
    }

    // 🔹 폼 (MemberFormController)
    @GetMapping("/new-form")
    public String form() {
        return "new-form";
    }

    // 🔹 저장 (MemberSaveController)
    @PostMapping("/save")
    public String save(@RequestParam("name") String name, Model model) {
        Member member = new Member(name);
        service.save(member);

        model.addAttribute("members", service.findAll());
        return "members";
    }

    // 🔹 상세 (MemberDetailController)
    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("member", service.findById(id));
        return "detail";
    }
}