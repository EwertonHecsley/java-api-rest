package br.com.project.api.apirest.controllers;

import br.com.project.api.apirest.models.Product;
import br.com.project.api.apirest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public List<Product> listar(){
    return productRepository.findAll();
    }
}
