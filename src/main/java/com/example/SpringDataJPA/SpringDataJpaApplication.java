package com.example.SpringDataJPA;

import com.example.SpringDataJPA.model.Student;
import com.example.SpringDataJPA.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);

//		Student s1 = context.getBean(Student.class);
//
//		s1.setName("Vaibhav");
//		s1.setMarks(99);
//		s1.setRollNo(101);

		List<Student> list = repo.findAll();
		System.out.println(list);

//		repo.save(s1);


	}

}
