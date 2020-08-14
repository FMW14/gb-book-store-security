package com.geekbrains.book.store.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class OrderItemService {
    private BookService bookService;

//    public void calculatePrice() {
//        price = (book.getPrice().multiply(new BigDecimal(count)));
//    }
}
