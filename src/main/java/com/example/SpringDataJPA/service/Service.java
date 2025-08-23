package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.model.OrderId;
import com.example.SpringDataJPA.model.Orders;
import com.example.SpringDataJPA.model.Payment;
import com.example.SpringDataJPA.repo.OrderRepo;
import com.example.SpringDataJPA.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private OrderRepo orderRepo;



    @Autowired
    private  Orders orders;

    @Autowired
    private OrderId orderId;

    @Autowired
    private  PaymentService paymentService;

    @Autowired
    private ErrorService errorService;




    @Transactional
    public void placeOrder(int amount) {
        try{
            orderId.setOrderId("order_7");
            orderId.setProductId("product_1");

            orders.setOrderId(orderId);
            orders.setPlacedDataTime(LocalDateTime.now());

            orderRepo.save(orders);

            paymentService.recievePayment(amount);
            throw new RuntimeException("order place failed");
        }catch (RuntimeException e){
            errorService.logError(e.getMessage());
            throw e;
        }


    }



}
