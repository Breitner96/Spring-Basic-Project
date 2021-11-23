package com.platzi.projectoplatzi.domain.service;

import com.platzi.projectoplatzi.domain.DomainProduct;
import com.platzi.projectoplatzi.domain.repository.DomainProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private DomainProductRepository domainProductrepository;

    public List<DomainProduct> getAll() {

        return domainProductrepository.getAll();
    }

    public Optional<DomainProduct> getProduct(Long productId) {

        return domainProductrepository.getProduct(productId);
    }

    public Optional<List<DomainProduct>> getByCategory(Long categoryId) {

        return domainProductrepository.getByCategory(categoryId);
    }

    public DomainProduct save(DomainProduct domainProduct){

        return domainProductrepository.save(domainProduct);
    }

//    Puede ser una alternativa con mejor rendimiento
    public boolean deleteById(Long productId) {

        try {
            domainProductrepository.deleteById(productId);
            return true;

        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

//    Otra alternativa para el borrado pude ser uso del map del Optional seria asi

//    public boolean deleteById(Long productId) {
//        return getProduct(productId).map(product ->
//        {domainProductrepository.deleteById(productId);
//        return true;
//        }).orElse(false);
//
//    }

}
