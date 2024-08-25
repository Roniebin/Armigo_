package org.example.virtualfittingshop.domain.order.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.virtualfittingshop.domain.member.domain.Address;
import org.example.virtualfittingshop.global.norm.DeliveryStatus;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Delivery {
    @Id
    @Column(name = "delivery_id")
    @GeneratedValue
    @Schema(description = "키")
    private Long id;

    @Setter
    @OneToOne(mappedBy = "delivery")
    @Schema(description = "주문 정보")
    private Order order;

    @Embedded
    @Schema(description = "주소 정보")
    private Address address;

    @Schema(description = "배송 상태")
    private DeliveryStatus status;

    public Delivery(Address address) {
        this.address = address;
    }

    public void changeStatus(DeliveryStatus status) {
        this.status = status;
    }

}
