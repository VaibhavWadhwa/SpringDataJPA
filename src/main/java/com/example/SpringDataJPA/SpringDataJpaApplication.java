package com.example.SpringDataJPA;

import com.example.SpringDataJPA.model.OrderId;
import com.example.SpringDataJPA.model.Orders;
import com.example.SpringDataJPA.model.Student;
import com.example.SpringDataJPA.repo.OrderRepo;
import com.example.SpringDataJPA.repo.StudentRepo;
import com.example.SpringDataJPA.service.PaymentService;
import com.example.SpringDataJPA.service.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) throws Exception {

	ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);


		PaymentService paymentService = context.getBean(PaymentService.class);

		Thread t1 = new Thread(() -> {
			paymentService.setAmount(1);
		});

		Thread t2 = new Thread(() -> {
			int amount = paymentService.readAmount(20);

		});

				t1.start();
		t2.start();

		t1.join();
		t2.join();

//
//		Service service = context.getBean(Service.class);
//
//		service.placeOrder(100);


//		StudentRepo repo = context.getBean(StudentRepo.class);
//
//		Student s1 = context.getBean(Student.class);
//
//		s1.setName("Vaibhav");
//		s1.setMarks(99);
//		s1.setRollNo(101);

//		List<Student> list = repo.findAll();
//		System.out.println(list);

//		repo.save(s1);

	}

}
