package com.example.demo.service;

import com.example.demo.vo.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductListRepository extends JpaRepository<ProductList,Long> {

    public List<ProductList> findByPrice(ProductList productList);
}
