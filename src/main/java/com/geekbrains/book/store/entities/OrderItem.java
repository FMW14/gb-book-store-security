package com.geekbrains.book.store.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderitems")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "orderItem")
    private Long book_id;

    private Integer count;

//    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "orderItems")
    private Order order;

//    public OrderItem(Book book, Integer count) {
//        this.book = book;
//        this.count = count;
//    }

    public OrderItem(Long bookId) {
        this.book_id = bookId;
        this.count = 1;
//        calculatePrice();
    }

    public OrderItem(Long bookId, Order order) {
        this.book_id = bookId;
        this.count = 1;
//        calculatePrice();
    }

    public void increaseCountByOne() {
        count+=1;
//        calculatePrice();
    }

//    private void calculatePrice(){
//        price = (book.getPrice().multiply(new BigDecimal(count)));
//    }
}
