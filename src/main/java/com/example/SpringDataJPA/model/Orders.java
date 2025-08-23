package com.example.SpringDataJPA.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
@Entity
@Table(name="orders")
public class Orders {

@EmbeddedId
private OrderId orderId;

private LocalDateTime placedDataTime;

    public OrderId getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderId orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getPlacedDataTime() {
        return placedDataTime;
    }

    public void setPlacedDataTime(LocalDateTime placedDataTime) {
        this.placedDataTime = placedDataTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", placedDataTime=" + placedDataTime +
                '}';
    }
}
