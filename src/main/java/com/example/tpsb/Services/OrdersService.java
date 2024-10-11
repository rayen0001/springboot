package com.example.tpsb.Services;

import com.example.tpsb.Models.Orders;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrdersService {


    List<Orders> getAllOrders();

    Optional<Orders> getOrderById(Long id);

    Optional<Orders> getOrdersByRef(String ref);

    List<Orders> getOrdersByDate(Date date);

    Orders saveOrder(Orders order);

    void deleteOrderById(Long id);

    void deleteOrderByRef(String ref);
}
