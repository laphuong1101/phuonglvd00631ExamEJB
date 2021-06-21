package com.example.hellospring.model.mapper;

import com.example.hellospring.entity.Product;
import com.example.hellospring.model.dto.ProductDTO;

public class ProductMapper {
    public static ProductDTO productDTO (Product product) {
        ProductDTO tmp = new ProductDTO();
        tmp.setName(product.getName());
        tmp.setPrice(product.getPrice());
        return tmp;
    }
}
