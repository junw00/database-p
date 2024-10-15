package exam.database.controller;

import exam.database.dto.MemberRequestDto;
import exam.database.entity.Member;
import exam.database.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 로그인
     */
    @PostMapping("/users")
    public String login(@RequestBody MemberRequestDto memberRequestDto, HttpSession session) {

        session.setAttribute("member", memberService.find(memberRequestDto));
        return "home";
    }

    @GetMapping("/signin")
    public String loginForm() {
        return "/auth/signin";
    }
}
