package com.microservice.course.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.course.dto.ProductDTO;

@FeignClient(name = "msvc-product", url = "localhost:8090")
public interface ProductClient {

    
    @GetMapping("/api/v1/product/search-by-course/{courseId}")    
    List<ProductDTO> findAllProductByCourse(@PathVariable Long courseId);

}
