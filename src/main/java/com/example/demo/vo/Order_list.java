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
@Table(name = "order_list")
public class Order_list {
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "delivery_location",length = 100, nullable = false)
	private String delivery_location;

    @ManyToOne
	@JoinColumn(name = "customer_id")
    private Customer customer;

}
