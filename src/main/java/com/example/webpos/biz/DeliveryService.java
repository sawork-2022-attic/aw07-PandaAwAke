package com.example.webpos.biz;

import com.example.webpos.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class DeliveryService implements Consumer<Order> {

    @Bean
    public Consumer<Order> handleOrder() {
        return new DeliveryService();
    }

    /**
     * Performs this operation on the given argument.
     *
     * @param order the input argument
     */
    @Override
    public void accept(Order order) {
        if (order != null) {
            System.out.println("Order received: " + order.getTimestamp());
        }
    }

    private static <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }

}
