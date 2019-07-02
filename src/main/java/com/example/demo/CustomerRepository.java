package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    //비워있어도 잘 작동함.
    // long 이 아니라 Long으로 작성. ex) int => Integer 같이 primitive형식 사용못함
	
	public List<Customer> findByName(String name);
	public List<Customer> findByPhone(String phone);
	//like검색도 가능
	public List<Customer> findByNameLike(String keyword);
}