package com.luizmangerotte.productapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luizmangerotte.productapi.model.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "order_db")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    private Instant instant;
    @Column(name = "order_status")
    private Integer orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(Long id, Instant instant, User client, OrderStatus orderStatus) {
        this.id = id;
        this.instant = instant;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }
}
