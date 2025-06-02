package com.microservice.course.http.response;

import com.microservice.course.dto.ProductDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor

public class ProductByCourseResponse {
    private String courseName;
    private String teacher;
    private List<ProductDTO> productDTOList;
}
