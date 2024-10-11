package com.example.tpsb.Services.Impl;

import com.example.tpsb.Models.Orders;
import com.example.tpsb.Services.OrdersService;
import com.example.tpsb.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }




    @Override
    public Optional<Orders> getOrdersByRef(String ref) {
        return ordersRepository.getOrdersByRef(ref);
    }



    @Override
    public List<Orders> getOrdersByDate(Date date) {
        return ordersRepository.getOrdersByDate(date);
    }


    @Override
    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }


    @Override
    public void deleteOrderById(Long id) {
        ordersRepository.deleteById(id);
    }


    @Override
    public void deleteOrderByRef(String ref) {
        ordersRepository.deleteByRef(ref);
    }
}
