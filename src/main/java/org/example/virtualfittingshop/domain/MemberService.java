package org.example.virtualfittingshop.domain;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.example.virtualfittingshop.domain.member.repository.MemberRepository;
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
    private void validateDuplicatedMember(Member member) {
        List<Member> findMemberList = memberRepository.findMemberByName(member.getName());
        if(!findMemberList.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
