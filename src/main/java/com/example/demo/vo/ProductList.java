package com.example.demo.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
@Getter
public class ProductList {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name",length = 100, nullable = false)
	private String name;

	@Column(nullable = false)
	private Long price;
	
}	
