package com.example.demo;

import lombok.Getter;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "order_price")
@Getter
public class Order_price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    @JoinColumn(table = "order_list")
//    @Column(nullable = false)
//    private Long order_id;

    @ManyToOne
    private Collection<Order_list> order_lists;

//    @ManyToOne
//    @JoinColumn(table = "product_list")
//    @Column(nullable = false)
//    private Long product_id;

    @ManyToOne
    private Collection<Product_list> product_lists;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long discount_price;
}
