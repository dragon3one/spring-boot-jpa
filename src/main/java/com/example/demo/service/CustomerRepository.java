package com.example.demo.service;

import com.example.demo.vo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	//메소드 이름으로 쿼리 생성
	public List<Customer> findByName(String name);
	public List<Customer> findByPhone(String phone);
	public List<Customer> findByNameLike(String keyword);

	//@NamedQuery 어노테이션을 통한 쿼리 Customer도메인에 등록되어 있다.
	public List<Customer> NamedQuery(String keyword);

	//@Query 어노테이션을 통한 쿼리 등록 @NamedQuery나 xml에 기술된 namedQuery 에 비하여 우선시 됩니다.
	//@Param을 통하여 named parameter 선언
	@Query("select c from Customer c where c.name= :name and c.phone= :phone")
	public List<Customer> query(@Param("name") String name,@Param("phone") String phone);
}