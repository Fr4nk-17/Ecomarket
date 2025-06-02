package com.microservice.course.service;

import com.microservice.course.model.Course;
import com.microservice.course.http.response.ProductByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    ProductByCourseResponse findProductByIdCourse(Long idCourse);
}
