package org.example.virtualfittingshop.domain.member.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findMemberById(Long id){
        return em.find(Member.class,id);
    }

    public List<Member> findMemberByName(String name){
        return em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m ",Member.class).getResultList();
    }


}
