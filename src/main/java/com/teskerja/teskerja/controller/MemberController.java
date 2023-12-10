package com.teskerja.teskerja.controller;

import com.teskerja.teskerja.model.MemberDto;
import com.teskerja.teskerja.model.Person;
import com.teskerja.teskerja.service.MemberService;
import com.teskerja.teskerja.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", "Blue");
        return "greeting";
    }

    @GetMapping("member")
    public String member(Model model) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<MemberDto> member = memberService.getAllMembers();
        model.addAttribute("member", member);
        return "member";
    }

    @GetMapping("create")
    public String create(Model model) {
        MemberDto memberDto = new MemberDto();
        model.addAttribute("member", memberDto);
        return "create_member";
    }

    @PostMapping(value = "member", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveStudent(@ModelAttribute("member") MemberDto member,
                              Model model){
        memberService.insertMember(member);
//        System.out.println(member);
        return "redirect:/member";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        MemberDto memberDto = memberService.getMember(id);
//        model.addAttribute("id", id);
        model.addAttribute("member", memberDto);
        return "update_member";
    }

    @PostMapping(value = "/member/update/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateMember(@PathVariable("id") Long id, @ModelAttribute("member") MemberDto memberDto){
        memberDto.setId(id);
        memberService.updateMember(memberDto);
        return "redirect:/member";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        MemberDto memberDto = memberService.getMember(id);
        model.addAttribute("member", memberDto);
        return "detail_member";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return "redirect:/member";
    }
}
