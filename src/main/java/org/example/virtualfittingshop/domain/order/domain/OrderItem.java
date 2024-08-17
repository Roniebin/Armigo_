package org.example.virtualfittingshop.domain.order.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderItem {
    @Id
    @Column(name = "orderitem_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    private int quantity;

}
