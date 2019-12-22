package com.bisnode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository reactiveCrudRepository;
    @Autowired
    ProductJPARepository productJPARepository;


    public void initializeData(){
        Flux saved = reactiveCrudRepository.saveAll(generateListOfProducts(1000000));
        saved.count().log().subscribe();
    }
    public List<Product> getProducts(){
            return productJPARepository.findAll();
    }

    public Flux<Product> getProductStream(){

        return reactiveCrudRepository.findAll();
    }

    private List<Product> generateListOfProducts(int i) {
        List<Product> products = new ArrayList<>();
        int x = 0;
        while (x<i){
            products.add(new Product(x, "com.lkadalski.Product"+x, (x*x+2)/6));
            x++;
        }
        return products;
    }
}
