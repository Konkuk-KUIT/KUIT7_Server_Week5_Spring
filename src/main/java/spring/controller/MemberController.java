package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.domain.Member;
import spring.service.MemberService;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("members", memberService.findAll());
    return "members";
  }

  @GetMapping("/{id}")
  public String detail(@PathVariable Long id, Model model) {
    model.addAttribute("member", memberService.findById(id));
    return "detail";
  }

  @GetMapping("/new-form")
  public String form() {
    return "new-form";
  }

  @PostMapping
  public String save(@RequestParam String name) {
    Member member = new Member(name);
    memberService.save(member);
    return "redirect:/members";
  }
}
