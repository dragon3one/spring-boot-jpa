package com.example.demo.vo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
@Getter
public class ProductList {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name",length = 100, nullable = false)
	private String name;

	@Column(nullable = false)
	private int price;

	@Builder
	public ProductList(String name,int price){
		this.name = name;
		this.price = price;
	}
}
