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

        @GetMapping("")
        public String list(Model model) {
            model.addAttribute("members", memberService.findAll());
            return "members";
        }

        @GetMapping("/detail")
        public String detail(@RequestParam("id") Long id, Model model) {            // @RequestParam key : 요청 보내는 JSP (링크/폼이 있는 쪽)
            model.addAttribute("member", memberService.findById(id));   // model.addAttribute key : 반환하는 JSP (데이터 표시하는 쪽)
            return "detail";
        }

        @GetMapping("/new-form")
        public String newForm() {
            return "new-form";
        }

        @PostMapping("/save")
        public String save(@RequestParam("name") String name) {
            memberService.save(new Member(name));
            return "redirect:/members";     // 'redirect:' 붙이면 Spring MVC가 redirect로 처리
        }
    }