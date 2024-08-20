package org.example.virtualfittingshop.domain.order.domain;

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
    private Long id;

    @Setter
    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    private DeliveryStatus status;

    public Delivery(Address address) {
        this.address = address;
    }

    public void changeStatus(DeliveryStatus status) {
        this.status = status;
    }

}
