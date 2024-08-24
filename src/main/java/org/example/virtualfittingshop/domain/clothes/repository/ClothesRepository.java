package org.example.virtualfittingshop.domain.clothes.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClothesRepository {
    private final EntityManager em;

    public void save(Clothes clothes){
        if(clothes.getId() == null){
            em.persist(clothes);
        }
        else{
            log.info("merge");
            em.merge(clothes);
        }
    }

    public Clothes findById(Long id){
        return em.find(Clothes.class, id);
    }

    public List<Clothes> findAll(){
        return em.createQuery("select c from Clothes c ", Clothes.class).getResultList();
    }

}
