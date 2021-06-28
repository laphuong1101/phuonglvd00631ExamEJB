package com.example.hellospring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProdId;
    private String ProdName;
    private String Description;
    private String DateOfManf;
    private int Price;


    @OneToMany(mappedBy="product", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Set<Sale> sales = new HashSet<>();

    public void setSales(Set<Sale> sales) {
        this.sales = sales;

        for(Sale s : sales) {
            s.setProduct(this);
        }
    }

    public Product(int prodId, String prodName, String description, String dateOfManf, int price) {
        ProdId = prodId;
        ProdName = prodName;
        Description = description;
        DateOfManf = dateOfManf;
        Price = price;
    }
}
