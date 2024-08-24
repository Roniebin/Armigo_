package org.example.virtualfittingshop.domain.order.controller;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
import org.example.virtualfittingshop.domain.clothes.service.ClothesService;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.example.virtualfittingshop.domain.member.service.MemberService;
import org.example.virtualfittingshop.domain.order.OrderService;
import org.example.virtualfittingshop.domain.order.domain.Order;
import org.example.virtualfittingshop.domain.order.dto.OrderSearch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ClothesService clothesService;

    @GetMapping("/order")
    public String createForm(Model model) {

        List<Member> members = memberService.findMembers();
        List<Clothes> clothesList = clothesService.findAllClothes();

        model.addAttribute("members", members);
        model.addAttribute("items", clothesList);
        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId, @RequestParam("count") int count){

        Long order = orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch
            orderSearch,Model model) {

        List<Order> orders = orderService.searchOrder(orderSearch);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId){

        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }


}
