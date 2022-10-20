package com.romanyou.KBE.demo1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private String type, brand, model;
    private double price;
}
