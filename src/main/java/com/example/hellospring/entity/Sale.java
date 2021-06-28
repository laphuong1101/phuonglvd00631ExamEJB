package com.example.hellospring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SlNo;
    private int SalesManID;
    private String SalesManName;
    private String DOS;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "ProdID", nullable = false, referencedColumnName = "ProdId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;

    @Column(insertable = false, updatable = false)
    private int ProdID;

    public Sale(int slNo, int salesManID, String salesManName, String DOS, int prodID) {
        SlNo = slNo;
        SalesManID = salesManID;
        SalesManName = salesManName;
        this.DOS = DOS;
        ProdID = prodID;
    }
}
