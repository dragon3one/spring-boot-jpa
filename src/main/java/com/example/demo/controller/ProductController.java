package com.example.demo.controller;

import com.example.demo.service.ProductListRepository;
import com.example.demo.vo.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @RestController view Resolver를 거치지 않고 리턴한다.
 * @EnableAutoConfiguration 자동설정 exclude와 excludeName속성을 통해 자동설정에서 제외 할수 있다.
 * */

@RestController
@EnableAutoConfiguration
@RequestMapping(name = "/product")
public class ProductController {

    @Autowired
    ProductListRepository productListRepository;

    @PostMapping("/findAll")
    public List<ProductList> findAll(){
        return productListRepository.findAll();
    }

}
