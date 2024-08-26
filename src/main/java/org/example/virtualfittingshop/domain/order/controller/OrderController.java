package org.example.virtualfittingshop.domain.order.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.order.OrderService;
import org.example.virtualfittingshop.domain.order.domain.Order;
import org.example.virtualfittingshop.domain.order.dto.OrderSearch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    @Operation(summary = "주문하기")
    public ResponseEntity<Void> order(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId, @RequestParam("count") int count){

        orderService.order(memberId, itemId, count);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/orders")
    @Operation(summary = "특정 회원의 주문목록 가져오기")
    public ResponseEntity<List<Order>> orderList(@ModelAttribute("orderSearch") OrderSearch
            orderSearch) {

        List<Order> orders = orderService.searchOrder(orderSearch);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/orders/cancel")
    @Operation(summary = "주문 취소")
    public ResponseEntity<Void> cancelOrder(@RequestParam("orderId") Long orderId){

        orderService.cancelOrder(orderId);
        return ResponseEntity.ok().build();
    }


}
