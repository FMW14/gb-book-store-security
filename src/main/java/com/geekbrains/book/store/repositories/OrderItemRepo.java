package com.geekbrains.book.store.repositories;

import com.geekbrains.book.store.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
}
