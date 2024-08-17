package org.example.virtualfittingshop.domain.order.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.virtualfittingshop.domain.member.domain.Member;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="delivery_id")
    private Delivery delivery;
    private final LocalDateTime orderDate = LocalDateTime.now();
    private String OrderStatus;


}
