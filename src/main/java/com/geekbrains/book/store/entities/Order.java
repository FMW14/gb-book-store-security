package com.geekbrains.book.store.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long user_id;

//    @ManyToOne
//    @MapsId("userId")
//    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

//    public Order(User user, List<OrderItem> orderItems) {
//        this.user = user;
//        this.orderItems = orderItems;
//    }

    public Order(Long user_id, List<OrderItem> orderItems) {
        this.user_id = user_id;
        this.orderItems = orderItems;
    }

    public Order(Long id) {
        this.id = id;
    }
//    public Order(User user) {
//        this.user = user;
//    }


    //    private User user;
}
