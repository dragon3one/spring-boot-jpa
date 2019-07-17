package com.example.demo;

import com.example.demo.service.CustomerRepository;
import com.example.demo.service.ProductListRepository;
import com.example.demo.vo.Customer;
import com.example.demo.vo.ProductList;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductListRepository productListRepository;

    @Test
    public void testCustomerRepository(){
        Customer customer = Customer.builder().name("크리스").phone("010-2222-2223").build();
        customerRepository.save(customer);
        List<Customer> customerList = customerRepository.findAll();

        /*Customer chris = customerList.get(0);
        assertThat(chris.getName(), is("크리스"));
        assertThat(chris.getPhone(), is("010-2222-2222"));*/
    }

    @Test
    public void testProductList1(){
//        ProductList product = ProductList.builder().name("냉장고").price(100).build();
//        productListRepository.save(product);
//        List<ProductList> productLists = productListRepository.findAll();

        List<ProductList> lists = new ArrayList<ProductList>();
        for(int i=0;i<100;i++){
            lists.add(ProductList.builder().name("냉장고").price(i).build());
        }
        productListRepository.saveAll(lists);
    }


    @After
    public void deleteAll() {
        customerRepository.deleteAll();
        productListRepository.deleteAll();
    }

}