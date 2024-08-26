package org.example.virtualfittingshop.domain.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.member.domain.Address;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.example.virtualfittingshop.domain.member.dto.MemberForm;
import org.example.virtualfittingshop.domain.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    @Operation(summary = "회원가입", description = "회원이름, 타입, 시, 도로명, 우편번호 필요")
    public ResponseEntity<Void> createMember(@Validated @RequestBody MemberForm memberForm) {
        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());

        Member member = Member.builder()
                .name(memberForm.getName())
                .type(memberForm.getType())
                .address(address)
                .build();

        memberService.join(member);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "회원이름으로 로그인, 회원 정보 반환됨")
    public ResponseEntity<Member> login(@RequestParam("name") String name) {

        Member member = memberService.findMemberByName(name);

        return ResponseEntity.ok().body(member);
    }

    @GetMapping("/getAll")
    @Operation(summary = "모든 회원 가져오기")
    public ResponseEntity<List<Member>> memberList() {
        List<Member> members = memberService.findMembers();
        return ResponseEntity.ok(members);
    }
}
