package com.platzi.projectoplatzi.web.controller;

import com.platzi.projectoplatzi.domain.DomainProduct;
import com.platzi.projectoplatzi.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class DomainProductController {

    @Autowired
    private ProductService productService;

//    Para control de respuestas hhttp
    @GetMapping()
    public List<DomainProduct> getAll() {

        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<DomainProduct> getProduct(@PathVariable("id") Long productId) {

        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public Optional<List<DomainProduct>> getByCategory(@PathVariable("id") Long categoryId) {

        return productService.getByCategory(categoryId);
    }

    @PostMapping()
    public DomainProduct save(@RequestBody DomainProduct domainProduct){

        return productService.save(domainProduct);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Long productId){

        return productService.deleteById(productId);
    }


}
