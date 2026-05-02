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
    // 우리가 직접 MemberService.getInstance() 하던 짓을 안해도됨. 스프링이 알아서 넣어줌
    private final MemberService memberService;

    // 1. 회원 가입 폼 (기존 MemberFormController)
    // URL: GET /members/new-form
    @GetMapping("/new-form")
    public String newform(){
        return "new-form";
    }

    // 2. 회원 저장 (기존 MemberSaveController)
    // URL: POST /members/save
    @PostMapping("save")
    public String save(@RequestParam String name, Model model) {
        // @RequestParam이 request.getParameter("name")을 알아서 해줌
        Member member = new Member(name);
        memberService.save(member);

        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);

        return "members";
    }

    // 3. 회원 목록 조회 (기존 MemberListController)
    // URL: GET /members (클래스 레벨의 @RequestMapping 으로 주소 생략 가능)
    @GetMapping
    public String list(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members";
    }

    //4. 회원 상세 조회 (기존 MemberDetailController)
    // URL: GET /members/detail?id=1
    @GetMapping("/detail")
    public String detail(@RequestParam Long id, Model model) {
        // @RequestParam이 파라미터를 꺼내서 Long 타입으로 형변환까지 알아서 해줌
        Member member = memberService.findById(id);
        model.addAttribute("member", member);
        return "detail";
    }
}
