package com.buyukli.ivan.productappangular.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Scope("prototype")
public class Cart {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private List<Product> products;
}
