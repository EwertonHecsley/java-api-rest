package br.com.project.api.apirest.controllers;

import br.com.project.api.apirest.models.Product;
import br.com.project.api.apirest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public List<Product> listar(){
    return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> obter(@PathVariable Integer id){
      Optional<Product> product = productRepository.findById(id);

      if (!product.isPresent()){
          return ResponseEntity.notFound().build();
      }
      return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
    }
}
