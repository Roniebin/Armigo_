package org.example.virtualfittingshop.domain.clothes.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.virtualfittingshop.global.exception.Exception;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Clothes {
    @Id
    @Column(name = "clothes_id")
    @GeneratedValue
    @Schema(description = "key")
    private Long id;

    @Schema(description = "제품명")
    private String name;

    @Schema(description = "제품 설명")
    private String description;

    @Schema(description = "가격")
    private int price;

    @Schema(description = "수량")
    private int quantity;

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void subQuantity(int quantity) {
        int restQuantity = this.quantity - quantity;
        if(restQuantity <0){
            throw new Exception("재고 에러");
        }
        this.quantity = restQuantity;

    }
}
