package br.com.magu.magu.controller;

import br.com.magu.magu.repository.model.Products.Products;
import br.com.magu.magu.service.ProductsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/magu/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping()
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productsService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
