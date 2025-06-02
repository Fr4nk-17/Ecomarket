package com.microservice.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.course.client.ProductClient;
import com.microservice.course.dto.ProductDTO;
import com.microservice.course.http.response.ProductByCourseResponse;
import com.microservice.course.model.Course;
import com.microservice.course.repository.ICourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private ICourseRepository iCourseRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) iCourseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return iCourseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        iCourseRepository.save(course);
    }

    @Override
    public ProductByCourseResponse findProductByIdCourse(Long idCourse){


        //Consultar el curso
        //Porque devuelve un optional
        Course course = iCourseRepository.findById(idCourse).orElse(new Course());

        //Obtener los estudiantes que estan en el curso obtenido
        List<ProductDTO> productDTOList = productClient.findAllProductByCourse(idCourse);


        return ProductByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .productDTOList(productDTOList)
                .build();
    }
}
