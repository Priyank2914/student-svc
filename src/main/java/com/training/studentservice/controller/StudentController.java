package com.training.studentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.studentservice.model.Student;
import com.training.studentservice.repository.StudentRepository;

@RestController  // combination of controller and responsebody
@RequestMapping("/studapi")
public class StudentController {
	
	public StudentController studentController;
	@Autowired
	StudentRepository repository;
	
	@GetMapping("/stud")
	//@ResponseBody
	public List<Student> getStud() {
		//return "Hey There...";
		
		return repository.findAll();
//		List<Student> studList=new ArrayList<>();
//		studList.add(new Student("Raj", 21, "A+"));
//		studList.add(new Student("aman", 31, "B+"));
//		studList.add(new Student("priya", 41, "O+"));
//		studList.add(new Student("sara", 35, "A+"));
//		return studList;
		
	}
	
	@PostMapping("/post")
	public void post(@RequestBody Student stud) {
		
		repository.save(stud);
//		System.out.println("Testing");
//		System.out.println(stud.getStudName());
	}
	
	@GetMapping("/stud/{id}")
	public Student getStudByid(@PathVariable("id" ) long id) {
		Optional<Student> stud = repository.findById(id);
		if(stud.isPresent()) {
			return stud.get();
			
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/stud")
	public Student getStud(@RequestBody long id) {
		Optional<Student> stud = repository.findById(id);
		if(stud.isPresent()) {
			return stud.get();
			
		}
		else {
			return null;
		}
	}
	
	@PutMapping("/stud/{id}")
	public void updateUser(@PathVariable("id" ) long id, @RequestBody Student stud) {
		Optional<Student> oldData =repository.findById(id);
		if(oldData.isPresent()) {
			Student std=oldData.get();
			std.setAge(stud.getAge());
			std.setGrade(stud.getGrade());
			std.setStudName(stud.getStudName());
			repository.save(std);
			
		}
	}
	
	@DeleteMapping("/stud/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		 Optional<Student> stud = repository.findById(id);
	    if (stud.isPresent()) {
	        repository.delete(stud.get());
	    } else {
	        return ;
	    }

}
}
