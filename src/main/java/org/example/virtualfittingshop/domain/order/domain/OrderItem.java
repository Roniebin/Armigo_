package org.example.virtualfittingshop.domain.order.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int quantity;

    public static OrderItem createOrderItem(Clothes clothes, int quantity) {

        OrderItem orderItem = OrderItem.builder()
                .clothes(clothes)
                .orderPrice(clothes.getPrice())
                .quantity(quantity).build();

        clothes.subQuantity(quantity);
        return orderItem;
    }
    // 비지니스 로직 //
    public void cancel() {
        getClothes().addQuantity(quantity);
    }

    public int getTotalPrice() {
        return getOrderPrice() * getQuantity();
    }
}
