package org.example.virtualfittingshop.domain.order;

import lombok.RequiredArgsConstructor;
import org.example.virtualfittingshop.domain.clothes.domain.Clothes;
import org.example.virtualfittingshop.domain.clothes.repository.ClothesRepository;
import org.example.virtualfittingshop.domain.member.domain.Member;
import org.example.virtualfittingshop.domain.member.repository.MemberRepository;
import org.example.virtualfittingshop.domain.order.domain.Delivery;
import org.example.virtualfittingshop.domain.order.domain.Order;
import org.example.virtualfittingshop.domain.order.domain.OrderItem;
import org.example.virtualfittingshop.domain.order.dto.OrderSearch;
import org.example.virtualfittingshop.domain.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ClothesRepository clothesRepository;

    @Transactional
    public Long order(Long memberId, Long clothesId,int count) {

        Member member = memberRepository.findMemberById(memberId);
        Clothes clothes = clothesRepository.findById(clothesId);

        Delivery delivery = new Delivery(member.getAddress());

        OrderItem orderItem = OrderItem.createOrderItem(clothes, count);

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {

        Order order = orderRepository.findById(orderId);
        order.cancelOrder();
    }

    public List<Order> searchOrder(OrderSearch orderSearch){
        return orderRepository.findAllByCriteria(orderSearch);
    }
}
