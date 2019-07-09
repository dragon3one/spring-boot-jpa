package com.example.demo.vo;

import lombok.*;

import javax.persistence.*;

/*
* '_'를 예약어로 사용하기 때문에 자바 표준인 Camel Case를 사용 하는것을 권장
* */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
@Getter
//"JPQL" - '*'문자 사용 불가 from 뒤에 오는 테이블명은 Entitiy name에 의해 결정되고 명시하지 않는 경우 Class name이 기본값으로 사용됨
@NamedQuery(name = "Customer.NamedQuery", query = "select c from Customer c where c.phone= ?1")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",length = 20, nullable = false)
    private String name;

    @Column(name = "phone",length = 20, nullable = false, unique = true)
    private String phone;

    @Builder
    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

}