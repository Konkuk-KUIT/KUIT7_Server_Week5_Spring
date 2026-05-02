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

import java.util.List;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/new-form")
    public String newForm() {
        return "members/new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name,
                       Model model) {

        Member member = new Member(name);
        memberService.save(member);

        model.addAttribute("member", member);
        return "members/detail";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/members";
    }

    // 상세 페이지로 넘어가기
    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        Member member = memberService.findById(id);
        model.addAttribute("member", member);
        return "members/detail";
    }
}