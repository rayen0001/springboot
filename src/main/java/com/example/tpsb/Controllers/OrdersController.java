package com.example.tpsb.Controllers;

import com.example.tpsb.Models.Orders;
import com.example.tpsb.Services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    @GetMapping
    public String getAllOrders(Model model) {
        List<Orders> orders = ordersService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders/list";
    }

    // Show form to create a new order
    @GetMapping("/new")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new Orders());
        return "orders/create";
    }

    // Save a new order
    @PostMapping
    public String saveOrder(@ModelAttribute Orders order) {
        ordersService.saveOrder(order);
        return "redirect:/orders";
    }

    // Show form to edit an existing order
    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable Long id, Model model) {
        Orders order = ordersService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        model.addAttribute("order", order);
        return "orders/edit";
    }

    // Update an existing order
    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable Long id, @ModelAttribute Orders order) {
        order.setId(id);
        ordersService.saveOrder(order);
        return "redirect:/orders";
    }

    // Delete an order
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        ordersService.deleteOrderById(id);
        return "redirect:/orders";
    }
}
