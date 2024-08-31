package org.example.virtualfittingshop.domain.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.example.virtualfittingshop.domain.member.dto.MemberForm;
import org.example.virtualfittingshop.domain.member.dto.RequestLogin;
import org.example.virtualfittingshop.domain.member.dto.ResponseLogin;
import org.example.virtualfittingshop.domain.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private final MemberService memberService;

    @PostMapping("/join")
    @Operation(summary = "회원가입", description = "회원이름, 타입, 시, 도로명, 우편번호 필요")
    public ResponseEntity<Void> createMember(@Validated @RequestBody MemberForm memberForm) {
        memberService.join(memberForm);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "회원이름으로 로그인, 회원 정보 반환됨")
    public ResponseEntity<ResponseLogin> login(@RequestBody RequestLogin requestLogin) {

        log.info(requestLogin.getName());
        Member member = memberService.login(requestLogin);
        ResponseLogin responseLogin = new ResponseLogin(member.getId(), member.getName(), member.getType(), member.getAddress());
        return ResponseEntity.ok().body(responseLogin);
    }

    @GetMapping("/getAll")
    @Operation(summary = "모든 회원 가져오기")
    public ResponseEntity<List<ResponseLogin>> memberList() {

        List<Member> members = memberService.findMembers();
        List<ResponseLogin> responseLoginList = members.stream().map(member -> new ResponseLogin(member.getId(), member.getName(), member.getType(), member.getAddress())).toList();
        return ResponseEntity.ok(responseLoginList);
    }
}
