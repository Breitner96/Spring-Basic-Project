package com.platzi.projectoplatzi.persistence;

import com.platzi.projectoplatzi.domain.Purchase;
import com.platzi.projectoplatzi.domain.repository.PurchaseRepository;
import com.platzi.projectoplatzi.persistence.crud.CompraCrudRepository;
import com.platzi.projectoplatzi.persistence.entity.Compra;
import com.platzi.projectoplatzi.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository  implements PurchaseRepository {

    @Autowired
    CompraCrudRepository compraCrudRepository;

    @Autowired
    PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras->mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {

        Compra compra=mapper.toCompra(purchase);
//      Esto se realiza porque tenemos que estar seguros de que compras
//      Conoce los productos y que los productos saben a que compra pertenecen

        compra.getProducts().forEach(producto-> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
