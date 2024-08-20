package org.example.virtualfittingshop.domain.clothes.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.virtualfittingshop.global.exception.NotEnoughStockException;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Clothes {
    @Id
    @Column(name = "clothes_id")
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int price;
    private int quantity;

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void subQuantity(int quantity) {
        int restQuantity = this.quantity - quantity;
        if(restQuantity <0){
            throw new NotEnoughStockException("재고 에러");
        }
        this.quantity = restQuantity;

    }
}
