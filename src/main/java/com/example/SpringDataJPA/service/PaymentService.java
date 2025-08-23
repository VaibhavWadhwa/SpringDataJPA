package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.model.Payment;
import com.example.SpringDataJPA.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;


    @Autowired
    private Payment payment;

    @Transactional(propagation = Propagation.MANDATORY)
    public void recievePayment(int amount) {
        payment.setId(7);
        payment.setPaymentType("DEBIT");
        payment.setAmount(amount);
        paymentRepo.save(payment);

    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int readAmount(int id){
        List<Payment> a1  =  paymentRepo.getAmount(id);
        System.out.println("t2 amount1- "+a1.size());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Payment> a2 =  paymentRepo.getAmount(id);
        System.out.println("t2 amount2- "+a2.size());
        return 3;
    }

    @Transactional
    public void setAmount(int id){
//        Optional<Payment> p = paymentRepo.findById(id);
//            if(p.isPresent()){
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                p.get().setAmount(32000);
//
//
//        }
        try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        Payment p = new Payment();
        p.setId(0);
        p.setAmount(98);
        p.setPaymentType("CREDIT");
        paymentRepo.save(p);

    }
}
