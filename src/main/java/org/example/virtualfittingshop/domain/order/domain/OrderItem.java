package org.example.virtualfittingshop.domain.order.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "key")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clothes_id")
    @Schema(description = "옷 정보")
    private Clothes clothes;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @Schema(description = "주문 정보")
    private Order order;

    @Schema(description = "주문 가격")
    private int orderPrice;
    @Schema(description = "주문 수량")
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
