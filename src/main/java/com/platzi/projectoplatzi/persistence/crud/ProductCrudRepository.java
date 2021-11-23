package com.platzi.projectoplatzi.persistence.crud;

import com.platzi.projectoplatzi.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product,Long> {
//    Query method normal, nos ofrecen mayor flexibilidad
    List<Product> findByIdCategoriaOrderByNombreAsc(Long idCategoria);

    Optional<List<Product>> findByCantidadStocksLessThanAndAndEstado
            (Long cantidadStocks, boolean estado);

//    Con Query nativo

//    @Query(value = "SELECT * FROM productos WHERE id_categoria=?",
//    nativeQuery = true)
//    List<Product> getByCategoria(int idCategoria);


    Optional<Product> findByIdProducto(Long idProducto);
}
