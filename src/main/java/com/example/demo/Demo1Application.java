package com.example.demo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@SpringBootApplication // @Configuration + @EnableAutoConfiguration + @ComponentScan 3가지 묶음
// 해당 어노테이션들은 다양한 설정이 자동으로 수행된다. 기존의 스프링 설정파일이 필요없게됨
public class Demo1Application {

	//querydsl에서 사용할 queryFactory 추가
	@PersistenceContext
	EntityManager entityManager;

	@Bean
	public JPAQueryFactory queryFactory(){
		return new JPAQueryFactory(entityManager);
	}
	//querydsl에서 사용할 queryFactory 추가 --

	@RequestMapping("/") // HTTP 요청을 받는 메소드를 지정해주는 어노테이션  @RequestMapping("url") 로  url에 따라 메소드를 지정할수있다.
	//@RequestMapping("/") 은 http://localhost:8080 입력시 index() 메소드가 호출된다.
	// Hello World를 확인하자
	String index() {
		return "mainpage";
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class,args);
	}
}