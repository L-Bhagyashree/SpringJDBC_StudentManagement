package com.SpringJDBC.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SpringJDBC.RowMapper.StudentRowMapper;
import com.SpringJDBC.Entity.StudentEntity;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<StudentEntity> loadStudent() {
		
		
		String sql="select * from student;";
		List<StudentEntity> studentList=jdbcTemplate.query(sql, new StudentRowMapper());
		
		return studentList;
	}
	
	@Override
	public void saveStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		
		Object[] args= {student.getName(), student.getMobile(), student.getCountry()};
		String sql="insert into student(name, mobile, country)  values(?,?,?)";
		jdbcTemplate.update(sql, args);
		System.out.println("1 record inserted");
	}

	@Override
	public StudentEntity getStudent(int id) {
		// TODO Auto-generated method stub
		
		String sql="SELECT * from Student where id=?";
		StudentEntity Student=jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return Student;
	}

	@Override
	public void updateStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		
		String sql="update student set name=?, mobile=?, country=? where id=?";
		jdbcTemplate.update(sql, student.getName(),student.getMobile(), student.getCountry(), student.getId());
		System.out.println("one record updated");
		
	}

	@Override
	public void deleteStudent(int id) {
		
		String sql="delete from student where id=?";
		jdbcTemplate.update(sql,id);
		
		
	}

	

}
