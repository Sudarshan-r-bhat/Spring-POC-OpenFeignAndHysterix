package com.practise.hysterix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.practise.feigns.FeignStudentClient;
import com.practise.models.Course;
import com.practise.models.Review;
import com.practise.models.Student;
import com.practise.ribbons.RibbonStudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hystrixStudentClient")
public class HysterixStudentClient implements FeignStudentClient {

    @Autowired
    RibbonStudentClient ribbonClient;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackStudents")
    public List<Student> getAllStudents() {

        return ribbonClient.getAllStudents();
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackSingleStudent")
    public Student getStudentById(int id) {
        return ribbonClient.getStudentById(id);
    }


    @HystrixCommand(fallbackMethod = "fallbackStudents" )
    @Override
    public List<Course> getAllCourses() {
        return ribbonClient.getAllCourses();
    }
    
    
    @HystrixCommand(fallbackMethod = "fallbackStudents")
    @Override
    public List<Review> getAllReviews() {
        return ribbonClient.getAllReviews();
    }

    @HystrixCommand(fallbackMethod = "fallbackStudents")
    @Override
    public List<Review> getCourseReview(int courseId) {

        return ribbonClient.getCourseReview(courseId);
    }
    
    private <T> List<T> fallbackStudents() {
        return null;
    }

    private <T> T fallbackSingleStudent() {
        return null;
    }
    
}
