package com.example.demo.vo;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class OrderList{
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "deliveryLocation",length = 100, nullable = false)
	private String deliveryLocation;

    @ManyToOne
	@JoinColumn(name = "customer_id")
    private Customer customer;

}
