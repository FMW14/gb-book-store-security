package com.geekbrains.book.store.controllers;

import com.geekbrains.book.store.beans.Cart;
import com.geekbrains.book.store.entities.Order;
import com.geekbrains.book.store.entities.OrderItem;
import com.geekbrains.book.store.entities.User;
import com.geekbrains.book.store.repositories.OrderRepo;
import com.geekbrains.book.store.services.BookService;
import com.geekbrains.book.store.services.OrderService;
import com.geekbrains.book.store.services.UserService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private Cart cart;
    private BookService bookService;
    private UserService userService;
//    private OrderRepo orderRepo;
    private OrderService orderService;

    @GetMapping("/add")
    public String add(Model model,
                               @RequestParam(name = "bookid") Long id
//                               @RequestParam Map<String, String> params
    ) {

        cart.add(id);
        return "redirect:/books";
    }

    @GetMapping("/confirm")
    public String confirm(Model model,
                          Principal principal
//                          @RequestParam(name = "orderItems") List<OrderItem> orderItems

//                               @RequestParam Map<String, String> params
    ) {
        if(principal == null){
            return "redirect:/login";
        }
        User user = userService.findByUsername(principal.getName()).get();
        System.out.println(user);
        System.out.println(cart.getOrderItems());
//        orderRepo.save(new Order(user, cart.getOrderItems()));
        Order order = new Order(user.getId());
        for (OrderItem orderItem : cart.getOrderItems()){
            orderItem.setOrder(order);
        }
        order.setOrderItems(cart.getOrderItems());

//        Order order = new Order(user.getId(), cart.getOrderItems());
        Order nor = orderService.saveOrUpdate(order);

//        System.out.println(111);
//        System.out.println(orderItems);

        return "redirect:/books";
    }

    @GetMapping
    public String cartAll(Model model
//                      @RequestParam(name = "bookid") Long id
//                               @RequestParam Map<String, String> params
    ) {

//        BookFilter bookFilter = new BookFilter(params);
//        Page<Book> page = bookService.findAll(bookFilter.getSpec(), pageIndex - 1, 5);
//        model.addAttribute("books", page.getContent());
        model.addAttribute("orderItems", cart.getOrderItems());
        return "cart-page";
    }

}
