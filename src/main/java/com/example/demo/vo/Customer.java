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
    /*
    * @GeneratedValue id 생성 전략 - AUTO/IDENTITY/SEQUENCE/TABLE 이 있다.
    * AUTO(default) - JPA 구현체가 자동으로 생성 전략을 결정한다.
    * IDENTITY - 기본키 생성을 데이터베이스에 위임한다. 예를 들어 MySQL의 경우 AUTO_INCREMENT를 사용하여 기본키를 생성한다.
    * SEQUENCE - 데이터베이스의 특별한 오브젝트 시퀀스를 사용하여 기본키를 생성한다.
    * TABLE    - 데이터베이스에 키 생성 전용 테이블을 하나 만들고 이를 사용하여 기본키를 생성한다.
    * spring boot 2.0 부터 Hibernated의 id 생성전략을 그대로 따라갈지 결정하는 useNewIdGeneratorMappings 의 기본값이 true
    * AUTO를 사용하게 되면 id값을 한 table에서 공통으로 관리하는 전략을 사용하게 됨
    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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