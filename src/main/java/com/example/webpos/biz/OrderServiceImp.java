package com.example.webpos.biz;

import com.example.webpos.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImp implements OrderService {

//    private LinkedList<Order> orders = new LinkedList<>();

    @Autowired
    private StreamBridge streamBridge;

    @Override
    public void postOrder(Order order) {
        //orders.offer(order);
        streamBridge.send("order-service", order);
    }
//
//    @Bean
//    public Supplier<Order> supplyOrder() {
//        Supplier<Order> orderSupplier = () -> {
//            System.out.println("Order posted: ");
//            if (!orders.isEmpty()) {
//                Order order = orders.poll();
//                System.out.println("Order posted: " + order.getTimestamp());
//                return order;
//            }
//            return null;
//        };
//        return orderSupplier;
//    }

}
