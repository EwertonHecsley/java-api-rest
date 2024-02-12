package br.com.project.api.apirest.repositories;

import br.com.project.api.apirest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
