package services;

import entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filteredSum(List<Product> list) {
        double total = 0;
        for (Product p : list) {
                total += p.getPrice();
        }
        return total;
    }
}
