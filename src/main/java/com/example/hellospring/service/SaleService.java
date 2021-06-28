package com.example.hellospring.service;

import com.example.hellospring.entity.Sale;
import com.example.hellospring.model.dto.SaleDTO;
import com.example.hellospring.model.mapper.SaleMapper;
import com.example.hellospring.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;


    // find all
    public List<SaleDTO> findAll(){
        List<Sale> sales = saleRepository.findAll();
        List<SaleDTO> saleDTOS = new ArrayList<>();

        for (Sale item : sales) {
            saleDTOS.add(SaleMapper.saleDTO(item));
        }
        return saleDTOS;
    }

    // seeding hard code
    public String seeding() {
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1,1, "a", "28/06/2021", 1));
        sales.add(new Sale(2,2, "b", "28/06/2021", 2));
        sales.add(new Sale(3,3, "c", "28/06/2021", 3));
        sales.add(new Sale(4,4, "d", "28/06/2021", 4));
        sales.add(new Sale(5,5, "e", "28/06/2021", 5));
        sales.add(new Sale(6,6, "f", "28/06/2021", 6));
        sales.add(new Sale(7,7, "g", "28/06/2021", 7));
        sales.add(new Sale(8,8, "h", "28/06/2021", 8));
        sales.add(new Sale(9,9, "i", "28/06/2021", 9));
        sales.add(new Sale(10,10, "k", "28/06/2021", 10));


        saleRepository.saveAll(sales);

        return "OK";
    }

}
