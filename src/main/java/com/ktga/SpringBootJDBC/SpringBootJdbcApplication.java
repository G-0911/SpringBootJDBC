package com.ktga.SpringBootJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ktga.SpringBootJDBC.model.student;
import com.ktga.SpringBootJDBC.repository.studentRepo;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		
		studentRepo sr = context.getBean(studentRepo.class);
		
		student st = context.getBean(student.class);
		st.setId(104);
		st.setName("kumar");
		st.setMark(99);
		
		sr.save(st);
		
		System.out.println(sr.getStudent());
		
	}

}
