package com.buyukli.ivan.productappangular.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private List<Product> products;
}
