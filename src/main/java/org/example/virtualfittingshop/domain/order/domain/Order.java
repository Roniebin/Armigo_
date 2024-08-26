package org.example.virtualfittingshop.domain.order.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.example.virtualfittingshop.global.norm.DeliveryStatus;
import org.example.virtualfittingshop.global.norm.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue
    @Schema(description = "key")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @Schema(description = "주문 회원 정보")
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    @Schema(description = "주문 상품 정보")
    @JsonIgnore
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="delivery_id")
    @Schema(description = "배송지 정보")
    private Delivery delivery;

    @Schema(description = "주문 일시")
    private LocalDateTime orderDate;

    @Schema(description = "주문 상태")
    private OrderStatus orderStatus;

    public void setMember(Member member){
        this.member = member;
        member.getOrderList().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItemList.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

   // 생성 메서드 //
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems){

        Order order = Order.builder()
                .member(member)
                .delivery(delivery)
                .orderDate(LocalDateTime.now())
                .orderStatus(OrderStatus.ORDER)
                .build();

        for(OrderItem orderItem : orderItems){
            order.addOrderItem(orderItem);
        }
        return order;
    }

    // 비지니스 로직 //
    public void cancelOrder(){
        if(delivery.getStatus() == DeliveryStatus.COMP){
                throw new IllegalStateException("이미 배송 완료된 상품은 취소가 불가능합니다.");
        }
        this.orderStatus = OrderStatus.CANCEL;
        for(OrderItem orderItem : this.orderItemList){
            orderItem.cancel();
        }
    }

    // 조회 로직 //
    public int getTotalPrice(){
        return this.orderItemList.stream()
                .mapToInt(OrderItem::getTotalPrice)
                .sum();
    }

}
