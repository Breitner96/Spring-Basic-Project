package com.platzi.projectoplatzi.persistence.mapper;

import com.platzi.projectoplatzi.domain.PurchaseItem;
import com.platzi.projectoplatzi.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring",uses ={ProductMapper.class} )
public interface PurchaseItemMapper {

    @Mappings({

            @Mapping(source = "id.idProducto",target = "productId"),
            @Mapping(source = "cantidad",target = "quantity"),
//            @Mapping(source = "total",target = "total"), No es necesario mapear
//            Porque tienen el mismo nombre.
            @Mapping(source = "estado",target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra",ignore = true),
            @Mapping(target = "product",ignore = true),
            @Mapping(target = "id.idCompra",ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
