package org.example.virtualfittingshop.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.example.virtualfittingshop.domain.member.repository.MemberRepository;
import org.example.virtualfittingshop.global.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Member findMemberById(Long id) {
        return memberRepository.findMemberById(id);
    }

    public Member findMemberByName(String name) {
        List<Member> memberByName = memberRepository.findMemberByName(name);
        if(memberByName.isEmpty())
            throw new AppException(HttpStatus.UNPROCESSABLE_ENTITY,"존재하지 않는 회원입니다.");

        return memberByName.get(0);
    }

    private void validateDuplicatedMember(Member member) {
        List<Member> memberByName = memberRepository.findMemberByName(member.getName());
        if(!memberByName.isEmpty()){
            throw new AppException(HttpStatus.CONFLICT,"이미 존재하는 회원입니다.");
        }
    }

}
