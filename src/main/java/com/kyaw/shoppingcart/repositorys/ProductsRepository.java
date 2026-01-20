package com.kyaw.shoppingcart.repositorys;

import com.kyaw.shoppingcart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Integer> {

}
