package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "customer_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserEntity user;

    @OneToMany
    private List<OrderItem> items;

    public OrderEntryEntity(UserEntity user, List<String> items) {
        this.user = user;
        this.items = items.stream().map(OrderItem::new).collect(Collectors.toList());
    }


    @Entity
    @Table(name = "order_items")
    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor
    class OrderItem {

        @Id
        @GeneratedValue
        private Long id;

        private String name;

        public OrderItem(String name) {
            this.name = name;
        }
    }

}
