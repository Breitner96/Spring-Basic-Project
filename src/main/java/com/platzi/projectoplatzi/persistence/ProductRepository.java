package com.platzi.projectoplatzi.persistence;

import com.platzi.projectoplatzi.domain.DomainProduct;
import com.platzi.projectoplatzi.domain.repository.DomainProductRepository;
import com.platzi.projectoplatzi.persistence.crud.ProductCrudRepository;
import com.platzi.projectoplatzi.persistence.entity.Product;
import com.platzi.projectoplatzi.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class ProductRepository implements DomainProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;



    @Override
    public List<DomainProduct> getAll(){
        List<Product> products=(List<Product>) productCrudRepository.findAll();
        return mapper.toDomainProducts(products);
    }

    @Override
    public Optional<List<DomainProduct>> getByCategory(Long categoryId) {
        List<Product> products=productCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);

        return Optional.of(mapper.toDomainProducts(products));
    }

    @Override
    public Optional<List<DomainProduct>> getScarseProducts(Long quantity) {

        Optional<List<Product>> products=productCrudRepository.findByCantidadStocksLessThanAndAndEstado(quantity,true);
        return products.map(prods->mapper.toDomainProducts(prods));
    }

    @Override
    public Optional<DomainProduct> getProduct(Long idProducto){

        Optional<Product> product=productCrudRepository.findByIdProducto(idProducto);
        return product.map(producto->mapper.toDomainProduct(producto));
    }


//  Por ejemplo, en el caso del código de barras, como no
//  tenemos acceso a este desde la API, si queremos agregarlo programáticamente,
//  sería algo como:
//  product.setCodigoBarras("1354885");
    @Override
    public DomainProduct save(DomainProduct domainProduct) {
        Product product=mapper.toProduct(domainProduct);

//        aqui iria la logica para generar codigos de barra automaticos

        return mapper.toDomainProduct(productCrudRepository.save(product));
    }

    @Override
    public void deleteById(Long productId) {

        productCrudRepository.deleteById(productId);
    }


}
