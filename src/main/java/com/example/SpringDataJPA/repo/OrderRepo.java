package com.example.SpringDataJPA.repo;

import com.example.SpringDataJPA.model.OrderId;
import com.example.SpringDataJPA.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders, OrderId> {
}
