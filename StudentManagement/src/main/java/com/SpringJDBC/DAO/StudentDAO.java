package com.SpringJDBC.DAO;

import java.util.List;
import com.SpringJDBC.Entity.StudentEntity;

public interface StudentDAO {
	
	List<StudentEntity> loadStudent();
	  void saveStudent(StudentEntity student);
	  StudentEntity getStudent(int id);
	void updateStudent(StudentEntity student);
	void deleteStudent(int id);
}
