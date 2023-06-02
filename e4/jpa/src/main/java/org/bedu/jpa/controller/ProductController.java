package org.bedu.jpa.controller;

import org.bedu.jpa.entity.Product;
import org.bedu.jpa.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private IProductRepository repository;
    @Autowired
    public ProductController(IProductRepository repository){
        this.repository = repository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product data){
        return repository.save(data);
    }

}
