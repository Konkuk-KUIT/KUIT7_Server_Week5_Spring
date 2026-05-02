package spring.controller;

import domain.Member;
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

    private final MemberService memberService;

    @GetMapping("/detail")
    public String memberDetail(@RequestParam("id") Long id , Model model){
        model.addAttribute("member" , memberService.findById(id));

        return "detail";
    }

    @GetMapping("/new-form")
    public String newForm(){
        return "new-form";
    }

    @GetMapping("")
    public String List(Model model){
        model.addAttribute("members", memberService.findAll());
        return "members";
    }


    @PostMapping("/save")
    public String save(@RequestParam("name") String name ){
        memberService.save(new Member(name));
        return "redirect:/members";
    }

}
