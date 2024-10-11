package com.example.tpsb.RestControllers;

import com.example.tpsb.Models.Orders;
import com.example.tpsb.Services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "/api")
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = ordersService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        Optional<Orders> order = ordersService.getOrderById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/ref/{ref}")
    public ResponseEntity<Orders> getOrderByRef(@PathVariable String ref) {
        Optional<Orders> order = ordersService.getOrdersByRef(ref);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Orders>> getOrdersByDate(@PathVariable Date date) {
        List<Orders> orders = ordersService.getOrdersByDate(date);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/add")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders newOrder = ordersService.saveOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        ordersService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/ref/{ref}")
    public ResponseEntity<Void> deleteOrderByRef(@PathVariable String ref) {
        ordersService.deleteOrderByRef(ref);
        return ResponseEntity.noContent().build();
    }
}
