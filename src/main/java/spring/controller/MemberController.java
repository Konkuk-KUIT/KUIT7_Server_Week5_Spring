package spring.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.domain.Member;
import spring.service.MemberService;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 등록 폼
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    // 회원 저장
    @PostMapping("/save")
    public String save(@RequestParam("name") String name, Model model) {
        Member member = new Member(name);
        memberService.save(member);

        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    // 회원 목록
    @GetMapping
    public String list(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    // 회원 상세
    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        Member member = memberService.findById(id);
        model.addAttribute("member", member);
        return "detail";
    }
}
