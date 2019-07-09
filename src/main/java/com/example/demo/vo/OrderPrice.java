package com.example.demo.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Getter
public class OrderPrice{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderList_id")
    private OrderList orderList;

    @ManyToOne
    @JoinColumn(name = "productList_id")
    private ProductList productList;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "discountPrice", nullable = false)
    private Long discountPrice;
}













