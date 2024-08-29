package org.example.virtualfittingshop.domain.member.service;

import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.virtualfittingshop.domain.member.domain.Address;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.example.virtualfittingshop.domain.member.dto.MemberForm;
import org.example.virtualfittingshop.domain.member.dto.RequestLogin;
import org.example.virtualfittingshop.domain.member.repository.MemberRepository;
import org.example.virtualfittingshop.global.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor

public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public Long join(MemberForm memberForm) {

        validateDuplicatedMember(memberForm.getName());
        log.info("{}, {}, {}, {}",memberForm.getName(), memberForm.getPassword(), memberForm.getCity(), memberForm.getType());
        String encodedPassword = passwordEncoder.encode(memberForm.getPassword());
        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());

        Member member = Member.builder()
                .name(memberForm.getName())
                .password(encodedPassword)
                .type(memberForm.getType())
                .address(address)
                .build();

        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findMemberById(Long id) {
        return memberRepository.findMemberById(id);
    }

    public Member login(RequestLogin requestLogin) {

        List<Member> memberList = memberRepository.findMemberByName(requestLogin.getName());

        if (memberList.isEmpty())
            throw new AppException(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다.");

        Member member = memberList.get(0);
        verifyPassword(requestLogin.getPassword(), member);
        return member;
    }

    private void verifyPassword(String requestPassword, Member member) {
        if (!passwordEncoder.matches(requestPassword, member.getPassword()))
            throw new AppException(HttpStatus.CONFLICT, "비밀번호가 일치하지 않습니다.");
    }

    private void validateDuplicatedMember(String name) {
        List<Member> memberByName = memberRepository.findMemberByName(name);
        if (!memberByName.isEmpty()) {
            throw new AppException(HttpStatus.CONFLICT, "이미 존재하는 회원입니다.");
        }
    }

}
