package com.example.SpringDataJPA.model;

import jakarta.persistence.Embeddable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
@Scope("prototype")
@Embeddable
public class OrderId implements Serializable {
    private  String orderId;
    private  String productId;

    public OrderId() {
    }

    public OrderId(String  orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderId orderId1 = (OrderId) o;
        return getOrderId().equals(orderId1.getOrderId()) && getProductId().equals(orderId1.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getProductId());
    }

    @Override
    public String toString() {
        return "OrderId{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                '}';
    }
}

