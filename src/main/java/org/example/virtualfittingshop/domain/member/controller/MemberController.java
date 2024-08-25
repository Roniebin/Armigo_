package org.example.virtualfittingshop.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.member.domain.Address;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.example.virtualfittingshop.domain.member.dto.MemberForm;
import org.example.virtualfittingshop.domain.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public String createMember(@Validated MemberForm memberForm) {
        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());

        Member member = Member.builder()
                .name(memberForm.getName())
//                .type(memberForm.getType())
                .address(address)
                .build();

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("")
    public String memberList(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
