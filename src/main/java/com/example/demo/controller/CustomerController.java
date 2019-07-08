package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.example.demo.vo.Customer;
import com.example.demo.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import sun.security.ssl.Debug;

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
    public @ResponseBody List<Customer> createCustomer(@RequestParam HashMap<String,String> param){
        System.out.println(param);
        String name = param.get("name");
        String phone = param.get("phone");
        Customer customer1 = Customer.builder().name(name).phone(phone).build();
        customerRepository.save(customer1);

        return customerRepository.findAll();
    }
    
    @PostMapping("/findAll")
    public @ResponseBody List<Customer> findAll(@RequestBody Map<String,String> param){
        return customerRepository.findAll();
    }

    @PostMapping("/findNameLike")
    public @ResponseBody List<Customer> findNameLike(@RequestParam Map<String,String> param){
        String keyword = param.get("keyword");
        return customerRepository.findByNameLike('%'+keyword+'%');
    }

    @PostMapping("/Named")
    public @ResponseBody List<Customer> Named(@RequestParam Map<String,String> param){
        return customerRepository.NamedQuery(param.get("keyword"));
    }

    @PostMapping("/query")
    public @ResponseBody List<Customer> query(@RequestParam Map<String,String> param){
        return customerRepository.query(param.get("name"), param.get("phone"));
    }
}