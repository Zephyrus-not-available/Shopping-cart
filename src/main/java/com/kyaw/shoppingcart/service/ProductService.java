package com.kyaw.shoppingcart.service;

import com.kyaw.shoppingcart.dto.ProductDto;
import com.kyaw.shoppingcart.repositorys.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductsRepository productsRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductsRepository productsRepository, ProductMapper productMapper) {
        this.productsRepository = productsRepository;
        this.productMapper = productMapper;
    }

    public ProductDto createProduct(
             ProductDto productDto) {
        var product = productMapper.toProductEntity(productDto);
        var savedProduct = productsRepository.save(product);
        return productMapper.toProductDto(savedProduct);

    }

    public List<ProductDto> getAllProducts() {
        var products = productsRepository.findAll();
        return products.stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }


}
