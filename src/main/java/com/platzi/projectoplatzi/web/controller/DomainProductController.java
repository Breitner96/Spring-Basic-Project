package com.platzi.projectoplatzi.web.controller;

import com.platzi.projectoplatzi.domain.DomainProduct;
import com.platzi.projectoplatzi.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class DomainProductController {

    @Autowired
    private ProductService productService;

//    Para control de respuestas http hacemos uso de ResponseEntity<> y HttpStatus
//    de la siguiente manera
    @GetMapping()
    public ResponseEntity<List<DomainProduct>> getAll() {

        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainProduct> getProduct(@PathVariable("id") Long productId) {

        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<DomainProduct>> getByCategory(@PathVariable("id") Long categoryId) {

        return productService.getByCategory(categoryId)
                .map(produts->new ResponseEntity<>(produts,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<DomainProduct> save(@RequestBody DomainProduct domainProduct){

        return new ResponseEntity<>(productService.save(domainProduct),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long productId){

        if(productService.deleteById(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        else{

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


}
