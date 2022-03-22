package com.practise.ribbons;

import com.practise.feigns.FeignStudentClient;
import com.practise.models.Course;
import com.practise.models.Review;
import com.practise.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("ribbonStudentClient")
public class RibbonStudentClient implements FeignStudentClient {


    // This should also specify the complete, url to communicate using restTemplate.
    private static final String STUDENT_SERVICE_URL = "http://relation-mapping-service/request";

    @Autowired
    RestTemplate loadBalanced;


    @Override
    public List getAllStudents() {

        return loadBalanced.getForObject(STUDENT_SERVICE_URL + "/student/all", List.class);
    }

    @Override
    public Student getStudentById(int id) {

        return loadBalanced.getForObject(STUDENT_SERVICE_URL + "/student/" + id, Student.class);
    }

    @Override
    public List<Course> getAllCourses() {
        return loadBalanced.getForObject(STUDENT_SERVICE_URL + "/course/all", List.class);
    }

    @Override
    public List<Review> getAllReviews() {
        return loadBalanced.getForObject(STUDENT_SERVICE_URL + "/review/all", List.class);
    }

    @Override
    public List<Review> getCourseReview(int courseId) {
        return loadBalanced.getForObject(STUDENT_SERVICE_URL + "/student/" + courseId, List.class);
    }
}
