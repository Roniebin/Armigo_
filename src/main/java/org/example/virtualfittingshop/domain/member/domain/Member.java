package org.example.virtualfittingshop.domain.member.domain;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "아이디")
    private Long id;
    @Schema(description = "회원명")
    private String name;
    @Schema(description = "주소")
    private Address address;
    @OneToMany(mappedBy = "member")
    @Builder.Default
    @Schema(description = "주문 리스트")
    private List<Order> orderList = new ArrayList<>();

}
