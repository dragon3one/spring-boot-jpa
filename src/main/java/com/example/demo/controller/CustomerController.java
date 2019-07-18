package com.example.demo.controller;

import com.example.demo.service.CustomerRepository;
import com.example.demo.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/*
* @RestController view Resolver를 거치지 않고 리턴한다.
* @EnableAutoConfiguration 자동설정 exclude와 excludeName속성을 통해 자동설정에서 제외 할수 있다.
* */

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    /*
    * @RequestParam Request에서 parameter를 매핑해온다.
    * @RequestBody Post방식에서 Body에 잇는 값을 매핑해온다 JSON 또는 XML에서 종종 사용
    * @ModelAttribute VO를 사용한 매핑 방식 @RequestParam과 유사
    *
    */

    @PostMapping(value = "/insert")
    public List<Customer> createCustomer(@RequestParam HashMap<String,String> param){
        System.out.println(param);
        String name = param.get("name");
        String phone = param.get("phone");
        Customer customer1 = Customer.builder().name(name).phone(phone).build();
        customerRepository.save(customer1);

        return customerRepository.findAll();
    }
    
    @PostMapping("/findAll")
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    //메서드이름으로 쿼리생성
    @PostMapping(value = "/findById")
    public Optional<Customer> findById(@RequestParam Map<String,String> param){
        Optional<Customer> result = customerRepository.findById(Long.parseLong(param.get("id")));
        return result;
    }
    @PostMapping("/findNameLike")
    public List<Customer> findNameLike(@RequestParam Map<String,String> param){
        String keyword = param.get("keyword");
        return customerRepository.findByNameLike('%'+keyword+'%');
    }

    //Named 쿼리
    //@NamedQuery Entity에 기술되어 있음
    @PostMapping("/Named")
    public List<Customer> Named(@RequestParam Map<String,String> param){
        return customerRepository.NamedQuery(param.get("keyword"));
    }
    //@Query Repository에 기술되어 있음
    @PostMapping("/query")
    public List<Customer> query(@RequestParam Map<String,String> param){
        return customerRepository.query(param.get("name"), param.get("phone"));
    }
}