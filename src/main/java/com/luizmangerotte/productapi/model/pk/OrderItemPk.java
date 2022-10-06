package com.luizmangerotte.productapi.model.pk;

import com.luizmangerotte.productapi.model.Order;
import com.luizmangerotte.productapi.model.Product;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@Data
@Embeddable
public class OrderItemPk implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name ="order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
