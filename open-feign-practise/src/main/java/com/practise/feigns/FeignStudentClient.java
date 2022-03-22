package com.practise.feigns;

import java.util.List;

import com.practise.models.Course;
import com.practise.models.Review;
import com.practise.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Service
@FeignClient(value = "relation-mapping-service")  // this specifies the microservice name to connect To.
public interface FeignStudentClient {

	// get details of all the students

	@RequestMapping( method = RequestMethod.GET, value = "request/student/all",
			produces = "application/json", consumes = "application/json")
	public List<Student> getAllStudents();


	// get a student's details by student id.
	@RequestMapping( method = RequestMethod.GET, value = "feign-service/student/{id}",
			produces = "application/json", consumes = "application/json")
	public Student getStudentById(@PathVariable("id") int id);


	// get a list  of all course details
	@RequestMapping( method = RequestMethod.GET, value = "feign-service/course/all",
			produces = "application/json", consumes = "application/json")
	public List<Course> getAllCourses();


	// get a list of all reviews for all courses.
	@RequestMapping( method = RequestMethod.GET, value = "feign-service/review/all",
			produces = "application/json", consumes = "application/json")
	public List<Review>  getAllReviews();


	// get reviews for a given course id.
	@RequestMapping( method = RequestMethod.GET, value = "feign-service/review/{course_id}",
			produces = "application/json", consumes = "application/json")
	public List<Review>  getCourseReview(int courseId);


}
