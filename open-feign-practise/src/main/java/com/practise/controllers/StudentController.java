package com.practise.controllers;

import com.practise.feigns.FeignStudentClient;
import com.practise.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feign-service")
public class StudentController {

    @Autowired
    FeignStudentClient feignClient;

    @RequestMapping( method = RequestMethod.GET, value = "/student/all",
            produces = "application/json", consumes = "application/json")
    public List<Student> getAllStudents() {

        return feignClient.getAllStudents();
    }

}
