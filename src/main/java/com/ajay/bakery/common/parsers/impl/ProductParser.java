package com.ajay.bakery.common.parsers.impl;

import java.util.List;
import java.util.Map;

import com.ajay.bakery.common.parsers.Parser;
import com.ajay.bakery.models.Product;

import static java.util.stream.Collectors.toMap;

public class ProductParser implements Parser<Product> {
    @Override
    public Map<String, Product> parseList(List<String> lines) {
        return lines.stream()
                .map(this::getProduct)
                .collect(toMap(Product::getCode, product -> product));
    }

    private Product getProduct(String row) {
        String[] values = row.split(CSV_SEPARATOR);
        return new Product(values[0].trim(), values[1].trim());
    }
}
