package org.example.virtualfittingshop.domain.clothes.service;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
import org.example.virtualfittingshop.domain.clothes.repository.ClothesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesRepository clothesRepository;

    @Transactional
    public void save(Clothes clothes) {
        clothesRepository.save(clothes);
    }

    public List<Clothes> findAllClothes() {
        return clothesRepository.findAll();
    }

    public Clothes findClothesById(Long id) {
        return clothesRepository.findById(id);
    }
}
