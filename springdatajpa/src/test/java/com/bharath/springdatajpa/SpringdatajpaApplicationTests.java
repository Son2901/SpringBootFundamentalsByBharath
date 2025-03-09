package com.bharath.springdatajpa;

import com.bharath.springdatajpa.entities.Student;
import com.bharath.springdatajpa.repositories.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	void testSaveStudent() {
		System.out.println("****************testSaveStudent****************");
		Student student=new Student();
		student.setId(1L);
		student.setName("Chandan");
		student.setTestScore(50);
		repository.save(student);

		Student saved = repository.findById(1L).get();
		Assertions.assertNotNull(saved);
		System.out.println("****************testSaveStudent****************");
	}

	@Test
	void testfindStudent() {
		System.out.println("****************testfindStudent****************");
		Student student=new Student();
		student.setId(2L);
		student.setName("john");
		student.setTestScore(40);
		repository.save(student);

		Student saved = repository.findById(2L).get();
		Assertions.assertNotNull(saved);
		System.out.println("****************testfindStudent****************");
	}

	@Test
	void testUpdateStudent() {
		System.out.println("****************testUpdateStudent****************");
		Student student=new Student();
		student.setId(3L);
		student.setName("Arti");
		student.setTestScore(40);
		repository.save(student);

		Student saved = repository.findById(3L).get();
		saved.setTestScore(45);
		Student updatedStudent = repository.save(saved);
		Assertions.assertNotNull(updatedStudent);
		Assertions.assertEquals(45, updatedStudent.getTestScore());
		System.out.println("****************testUpdateStudent****************");
	}

	@Test
	void testDeleteStudent() {
		System.out.println("****************testDeleteStudent****************");
		Student student=new Student();
		student.setId(4L);
		student.setName("Kash");
		student.setTestScore(10);
		repository.save(student);

		repository.deleteById(4L);

		Assertions.assertFalse(repository.findById(4L).isPresent());
		System.out.println("****************testDeleteStudent****************");
	}

}
