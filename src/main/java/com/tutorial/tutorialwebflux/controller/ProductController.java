package com.tutorial.tutorialwebflux.controller;

import com.tutorial.tutorialwebflux.entity.Product;
import com.tutorial.tutorialwebflux.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product/v1")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable("id") int id){
        return productService.getById(id);
    }

    @PostMapping
    public Mono<Product> save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable("id") int id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") int id){
        return productService.delete(id);
    }
}
