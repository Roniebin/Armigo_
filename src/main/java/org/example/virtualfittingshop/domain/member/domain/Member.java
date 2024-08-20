package org.example.virtualfittingshop.domain.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.virtualfittingshop.domain.order.domain.Order;

import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue
    private Long id;
    private String name;
    private Address address;
    @OneToMany(mappedBy = "member")
    @Builder.Default
    private List<Order> orderList = new ArrayList<>();

}
