package spring.controller;

import domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	private MemberService memberService;

    
	@GetMapping
	public String list(Model model) {
		model.addAttribute("members", memberService.findAll());
		return "members";
	}

	@GetMapping("/new-form")
	public String newForm() {
		return "new-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam String name, RedirectAttributes rttr) {
		Member member = new Member(name);
		memberService.save(member);
		return "redirect:/members";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam Long id, Model model) {
		model.addAttribute("member", memberService.findById(id));
		return "detail";
	}
}