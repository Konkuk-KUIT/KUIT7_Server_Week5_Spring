package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import spring.service.MemberService;
import spring.domain.Member;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService service;

    @GetMapping("/members")
    public String getMembers(Model model) {
        model.addAttribute("members", service.findAll());
        return "members";
    }

    @GetMapping("/members/new-form")
    public String newForm(Model model) {
        return "new-form";
    }

    @GetMapping("/members/detail")
    public String getMemberDetail(Model model, @RequestParam("id") Long id) {
        model.addAttribute("member", service.findById(id));
        return "detail";
    }

    @PostMapping("/members/save")
    public String saveMember(@RequestParam("name") String name) {

        Member member = new Member(name);

        service.save(member);

        return "redirect:/members";
    }
}
