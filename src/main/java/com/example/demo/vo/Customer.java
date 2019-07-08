package com.example.demo.vo;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "customer")
@ToString
@Entity
@Getter
@NamedQuery(name = "Customer.NamedQuery", query = "select c from Customer c where c.phone= ?1") // *문자 사용 불가 from vo Class명으로
public class Customer {
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