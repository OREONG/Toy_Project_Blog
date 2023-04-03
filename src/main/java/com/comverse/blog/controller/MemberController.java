package com.comverse.blog.controller;

import com.comverse.blog.dto.Member;
import com.comverse.blog.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @Autowired
    private MemberService ms;

    @GetMapping("/duplCheck")
    @ResponseBody
    public int duplCheck(Member member) {
        int result = ms.duplCheck(member);
        return result;
    }

    @RequestMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @RequestMapping("/join")
    public String join(Model model, Member member) {
        int result = 0;
        result = ms.insert(member);
        model.addAttribute("result", result);

        return "join";
    }

    @RequestMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @RequestMapping("/login")
    public String loginForm(Member member, Model model, HttpSession session) {
        int result = 0;
        Member member2 = ms.selectId(member.getMember_id());

        if (member2 == null || member2.equals(null)) {
            result = -1;
        } else if (member.getPassword() == member2.getPassword()
                    || member.getPassword().equals(member2.getPassword())) {
            result = 1;
            session.setAttribute("member_id", member.getMember_id());
        }
        model.addAttribute("result", result);
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "logout";
    }

}
