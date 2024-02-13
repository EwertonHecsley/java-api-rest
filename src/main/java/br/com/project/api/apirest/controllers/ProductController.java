package br.com.project.api.apirest.controllers;

import br.com.project.api.apirest.models.Product;
import br.com.project.api.apirest.repositories.ProductRepository;
import br.com.project.api.apirest.utils.ResponseHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> obter(@PathVariable Integer id){
      Optional<Product> product = productRepository.findById(id);

      if (!product.isPresent()){
          return ResponseHandle.generate("Produto não encontrado",HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<Object>(product.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Product product){
    Product newProduct = productRepository.save(product);

    return new ResponseEntity<Object>(newProduct,HttpStatus.CREATED);
    }
}




