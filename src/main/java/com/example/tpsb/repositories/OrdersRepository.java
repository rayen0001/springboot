package com.example.tpsb.repositories;

import com.example.tpsb.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Optional<Orders> getOrdersByRef(String ref);
    List<Orders> getOrdersByDate(Date date) ;
    void deleteByRef(String ref);
}
