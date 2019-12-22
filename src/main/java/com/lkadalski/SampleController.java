package com.bisnode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Controller
public class SampleController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/initialize")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void initialize() {
        productService.initializeData();
    }

    @GetMapping(value = "/traditional", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Product> getAllProducts() {
        LocalTime startTime = LocalTime.now();
        System.out.println("Traditional way started " + startTime);
        List<Product> products = productService.getProducts();
        LocalTime endTime = LocalTime.now();
        System.out.println("Traditional way completed " + endTime);
        System.out.println("Duration " + Duration.between(startTime, endTime).toMillis() + " ms");
        return products;
    }

    @GetMapping(value = "/reactive", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public @ResponseBody
    Flux<Product> getAll() {
        LocalTime startTime = LocalTime.now();
        System.out.println("Reactive way using Flux started " + startTime);
        Flux<Product> fluxProducts = productService.getProductStream();
        LocalTime endTime = LocalTime.now();
        System.out.println("Reactive way completed " + endTime);
        System.out.println("Duration " + Duration.between(startTime, endTime).toMillis() + " ms");
        return fluxProducts;
    }
}
