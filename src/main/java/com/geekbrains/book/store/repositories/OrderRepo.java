package com.geekbrains.book.store.repositories;

import com.geekbrains.book.store.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
