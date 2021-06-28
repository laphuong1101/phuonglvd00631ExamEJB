package com.example.hellospring.service;

import com.example.hellospring.entity.Product;
import com.example.hellospring.model.dto.ProductDTO;
import com.example.hellospring.model.mapper.ProductMapper;
import com.example.hellospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // save
    public ProductDTO save (Product product) {
        productRepository.save(product);
        ProductDTO rs = ProductMapper.productDTO(product);
        return rs;
    }

    // find all
    public List<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product item : products) {
            productDTOS.add(ProductMapper.productDTO(item));
        }
        return productDTOS;
    }

    // seeding hard code
    public String seeding() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"iphone 11", "apple", "28/06/2021", 1000));
        products.add(new Product(2,"iphone 12", "apple", "28/06/2021", 1200));
        products.add(new Product(3,"iphone 12 pro max", "apple", "28/06/2021", 1500));
        products.add(new Product(4,"iphone 12 pro mini", "apple", "28/06/2021", 1300));
        products.add(new Product(5,"iphone 11 pro max", "apple", "28/06/2021", 1100));
        products.add(new Product(5,"samsung", "samsung", "28/06/2021", 1000));
        products.add(new Product(5,"oppo", "china", "28/06/2021", 800));
        products.add(new Product(5,"pixel 3", "google", "28/06/2021", 900));
        products.add(new Product(5,"vsmart", "vin group", "28/06/2021", 500));
        products.add(new Product(5,"nokia", "nokia", "28/06/2021", 110));

        productRepository.saveAll(products);

        return "OK";
    }

}
