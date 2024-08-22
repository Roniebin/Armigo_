package org.example.virtualfittingshop.domain.order.dto;

import lombok.Data;
import org.example.virtualfittingshop.global.norm.OrderStatus;

@Data
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;
}
