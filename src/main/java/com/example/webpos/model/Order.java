package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private List<Item> items = new ArrayList<>();
    private long timestamp;

    public Order(Cart cart) {
        this.items = cart.getItems();
        this.timestamp = System.currentTimeMillis();
    }
}
