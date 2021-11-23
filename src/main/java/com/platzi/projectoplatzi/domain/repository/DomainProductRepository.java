package com.platzi.projectoplatzi.domain.repository;

import com.platzi.projectoplatzi.domain.DomainProduct;
import com.platzi.projectoplatzi.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface DomainProductRepository {

    List<DomainProduct> getAll();
    Optional<List<DomainProduct>> getByCategory(Long categoryId);
    Optional<List<DomainProduct>> getScarseProducts(Long quantity);
    Optional<DomainProduct> getProduct(Long productId);
    DomainProduct save(DomainProduct product);
    void deleteById(Long productId);
}
