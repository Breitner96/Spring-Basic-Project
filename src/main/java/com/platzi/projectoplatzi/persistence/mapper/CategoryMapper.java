package com.platzi.projectoplatzi.persistence.mapper;

import com.platzi.projectoplatzi.domain.DomainCategory;
import com.platzi.projectoplatzi.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

//    Convierte Category a DomainCategory para separar la capa de
//    persistencia con la de dominio
    @Mappings({

//          Va desde la variable de persistencia hasta la de dominio
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),

    })
    DomainCategory toDomainCategory(Category category);

//  Con este decorador le decimos a spring que el procedimiento
//  Es el inverso del anterior
    @InheritInverseConfiguration
//    Como la clase Category tiene ver productos y este no este en nuestro
//    DomainCategory debemos de ingnorarlo con la siguiente sentencia
    @Mapping(target = "productos",ignore = true)
    Category toCategory(DomainCategory domainCategory);
}
