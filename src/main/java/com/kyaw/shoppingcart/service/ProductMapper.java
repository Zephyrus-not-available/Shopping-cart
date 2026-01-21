package com.kyaw.shoppingcart.service;

import com.kyaw.shoppingcart.dto.ProductDto;
import com.kyaw.shoppingcart.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProductEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(null); // always let DB generate id on create
        product.setName(productDto.name());
        product.setBrand(productDto.brand());
        product.setCategory(productDto.category());
        product.setPrice(productDto.price());
        product.setDescription(productDto.description());
        product.setImageFileName(productDto.imageFileName());
        return product;
    }

    public ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getCategory(),
                product.getPrice(),
                product.getDescription(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getImageFileName()
        );
    }

}
