package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Student;

public interface StudentService {

	void saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudent(int id);

	void deleteStudent(int id);

}
