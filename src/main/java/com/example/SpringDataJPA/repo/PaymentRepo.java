package com.example.SpringDataJPA.repo;

import com.example.SpringDataJPA.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {

    @Query("select a from Payment a where a.id < :id")
    public List<Payment> getAmount(@Param("id") int id);
}
