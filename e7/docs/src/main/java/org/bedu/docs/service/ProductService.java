package org.bedu.docs.service;

import org.bedu.docs.model.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductService {

    private List<Product> db = new LinkedList<>();

    public ProductService() {
        db.add(Product.builder().code("PR001").name("Gansito").price(15).description("Pastelito de chocolate").build());

        db.add(Product.builder().code("PR002").name("Topochico").price(19).description("Agua Mineral de Manantial").build());

        db.add(Product.builder().code("PR003").name("Cheetos").price(10).description("Fritura de maiz").build());
    }

    public List<Product> findAll(){
        return db;
    }

    public void save(Product data){
        db.add(data);
    }
}
