package org.example.virtualfittingshop.domain.image.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private String fileOriginName;
    private String fileExtension;
    private String fileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clothes_id")
    private Clothes clothes;
}
