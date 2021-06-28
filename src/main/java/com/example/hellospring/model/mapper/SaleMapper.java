package com.example.hellospring.model.mapper;

import com.example.hellospring.entity.Sale;
import com.example.hellospring.model.dto.SaleDTO;

public class SaleMapper {
    public static SaleDTO saleDTO (Sale sale) {
        SaleDTO tmp = new SaleDTO();
        tmp.setSalesManName(sale.getSalesManName());
        tmp.setSalesManID(sale.getSalesManID());
        tmp.setDOS(sale.getDOS());
        tmp.setProdID(sale.getProdID());
        return tmp;
    }
}
