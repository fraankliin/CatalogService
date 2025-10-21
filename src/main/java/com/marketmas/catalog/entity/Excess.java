package com.marketmas.catalog.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "excess")
@Getter
@Setter
public class Excess {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer excessId;

    private Integer empresaId;
    private String productName;
    private String description;
    private String category;
    private Integer quantity;
    private String unitMeasurement;
    private LocalDateTime publishDate = LocalDateTime.now();
    private LocalDateTime expirationDate;
    private String city;
    private String address;

    private String status;


}
