package org.example.virtualfittingshop.domain.member.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.virtualfittingshop.domain.order.domain.Order;
import org.example.virtualfittingshop.global.norm.MemberType;

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
    @Schema(description = "key")
    private Long id;

    @Schema(description = "회원명")
    private String name;

    @Schema(description = "MemberType으로 BUYER와 SELLER로 정의")
    private MemberType type;

    @Schema(description = "주소")
    private Address address;

    @OneToMany(mappedBy = "member")
    @Builder.Default
    @Schema(description = "주문 리스트")
    @JsonIgnore
    private List<Order> orderList = new ArrayList<>();
}
