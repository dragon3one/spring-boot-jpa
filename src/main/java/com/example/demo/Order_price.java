package com.example.demo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "order_price")
@ToString
@Entity
@Getter
public class Order_price {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_list_id")
    private Order_list order_list;

    @ManyToOne
    @JoinColumn(name = "product_list_id")
    private Product_list product_list;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "discount_price", nullable = false)
    private Long discount_price;
}













