package com.SpringJDBC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringJDBC.DAO.StudentDAO;
import com.SpringJDBC.Entity.StudentEntity;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDAO studentDao;
	
	@Override
	public List<StudentEntity> loadStudent() {
		// TODO Auto-generated method stub
		List<StudentEntity> studentList=studentDao.loadStudent();
		return studentList;
	}

	@Override
	public void saveStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		
		if(student.getCountry().equals("UK")) {
			System.out.println("mail sent to:"+student.getName());
		}
		
		studentDao.saveStudent(student);

	}

	@Override
	public StudentEntity getStudent(int id) {
		// TODO Auto-generated method stub
		StudentEntity student=studentDao.getStudent(id);
		return  student;
	}

	@Override
	public void updateStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		studentDao.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(id);
		
	}

}
