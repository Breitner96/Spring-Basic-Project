package com.platzi.projectoplatzi.persistence.mapper;

import com.platzi.projectoplatzi.domain.DomainProduct;
import com.platzi.projectoplatzi.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({

            @Mapping(source = "idProducto",target = "productId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "precioVenta",target = "price"),
            @Mapping(source = "cantidadStocks",target = "stock"),
            @Mapping(source = "estado",target = "active"),
//            Como domainCategory tiene su mapper propio debemos de hacer otra
//            Configuracion, que es incluir en Mapper un nuevo parametro
            @Mapping(source = "category",target = "domainCategory"),

    })

    DomainProduct toDomainProduct(Product product);
    List<DomainProduct> toDomainProducts(List<Product> products);


    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras",ignore = true)
    Product toProduct(DomainProduct domainProduct);
}
