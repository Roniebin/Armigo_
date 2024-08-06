package org.example.virtualfittingshop.domain.clothes.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.virtualfittingshop.domain.image.domain.Image;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Clothes {
    @Id
    @Column(name = "clothes_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long quantity;

    @OneToMany(mappedBy = "image")
    private List<Image> imageList = new ArrayList<>();

}
