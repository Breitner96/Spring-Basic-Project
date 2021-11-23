package com.platzi.projectoplatzi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class DomainProduct {

    private Long productId;
    private String name;
    private Long categoryId;
    private double price;
    private Long stock;
    private boolean active;
    private DomainCategory domainCategory;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public DomainCategory getDomainCategory() {
        return domainCategory;
    }

    public void setDomainCategory(DomainCategory domainCategory) {
        this.domainCategory = domainCategory;
    }
}
