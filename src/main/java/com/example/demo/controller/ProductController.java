package com.example.demo.controller;

import com.example.demo.service.ProductListRepository;
import com.example.demo.vo.ProductList;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
 * @RestController view Resolver를 거치지 않고 리턴한다.
 * @EnableAutoConfiguration 자동설정 exclude와 excludeName속성을 통해 자동설정에서 제외 할수 있다.
 * */

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductListRepository productListRepository;

    @PostMapping(value = "/findAll")
    public List<ProductList> findAll(){
        return productListRepository.findAll();
    }

    /*
    * Pageable 객체를 통한 paging 처리 PageRequest.of()함수를 통해서 page,size,sort를 결정
    * */
    @PostMapping(value = "/findAllPage")
    public Page<ProductList> findAllPage(@RequestParam(name = "page") int page){
        Pageable pageable = PageRequest.of(page,5,Sort.by(Sort.Direction.ASC,"price"));
        return productListRepository.findAll(pageable);
    }
    /*
    * Sort 객체를 통해 sort 규칙 생성 Sort.by()함수 사용하여 direction(ASC/DESC), properties 설정
    * Sort.by(Orders)로 여러개 가능
    * */
    @PostMapping(value = "/findAllSort")
    public List<ProductList> findAllSort(){
        return productListRepository.findAll(Sort.by(Sort.Order.desc("price"),Sort.Order.asc("name")));
    }

    @PostMapping(value = "/insert")
    public List<ProductList> insert(@ModelAttribute ProductList productList){

        List<ProductList> lists = new ArrayList<ProductList>();
        for(int i=0;i<100;i++){
            lists.add(ProductList.builder().name("냉장고").price(i).build());
        }
        productListRepository.saveAll(lists);

        productListRepository.save(productList);
        return productListRepository.findAll();
    }
}
