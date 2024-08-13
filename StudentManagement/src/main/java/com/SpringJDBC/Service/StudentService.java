package com.SpringJDBC.Service;

import java.util.List;

import com.SpringJDBC.Entity.StudentEntity;

public interface StudentService {
	
	List<StudentEntity> loadStudent();
	void saveStudent(StudentEntity student);
	StudentEntity getStudent(int id);
	void updateStudent(StudentEntity student);
	void deleteStudent(int id);
	
}
