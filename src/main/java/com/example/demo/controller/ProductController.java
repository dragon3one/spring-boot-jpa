package com.example.demo.controller;

import com.example.demo.service.ProductListRepository;
import com.example.demo.vo.OrderPrice;
import com.example.demo.vo.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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

    @Autowired
    protected EntityManager entityManager;

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

    //JPA Dynamic Qurey Criteria 쿼리
    @PostMapping(value = "/criteria")
    public List<ProductList> criteria(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductList> criteriaQuery = builder.createQuery(ProductList.class);
        Root<ProductList> root = criteriaQuery.from(ProductList.class);

        //where 옵션들
        List<Predicate> predicates = new ArrayList<>();

        //where LIKE문 추가
        predicates.add(builder.like(root.get("name"),"%냉%"));

        //where 절에 join추가
        // JOIN실패...
//        Join<ProductList,OrderPrice> joinin = root.join("id");
//        predicates.add(builder.equal(joinin.get("discountPrice"),"0"));

        //옵션항목을 where절에 추가
        criteriaQuery.where(predicates.toArray( new Predicate[]{} ));

        //쿼리를 select문 추가
        criteriaQuery.select(root);

        //최종쿼리
        TypedQuery<ProductList> typedQuery = entityManager.createQuery(criteriaQuery);

        //쿼리 실행후 결과
        List<ProductList> lists = typedQuery.getResultList();
        return  lists;
    }
}
