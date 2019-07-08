package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.example.demo.service.CustomerRepository;
import com.example.demo.vo.Customer;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testCustomerRepository(){
        Customer customer = Customer.builder().name("크리스").phone("010-2222-2222").build();
        customerRepository.save(customer);
        List<Customer> customerList = customerRepository.findAll();

        /*Customer chris = customerList.get(0);
        assertThat(chris.getName(), is("크리스"));
        assertThat(chris.getPhone(), is("010-2222-2222"));*/
    }

//    @After
//    public void deleteAll() {
//        customerRepository.deleteAll();
//    }

}