package com.example.demo;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
@Table(name = "order_list")
public class Order_list {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 100, nullable = false)
	private String delivery_location;

//	@OneToMany
//    @JoinColumn(table = "customer")
//	@Column(nullable = false)
//	private Long customer_id;

    @OneToMany
    private Collection<Customer> customers;

}	
