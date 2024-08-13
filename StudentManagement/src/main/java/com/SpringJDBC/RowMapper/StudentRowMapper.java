package com.SpringJDBC.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.SpringJDBC.Entity.StudentEntity;

public class StudentRowMapper implements RowMapper<StudentEntity> {

	@Override
	public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		StudentEntity s1=new StudentEntity();
		s1.setId(rs.getInt("id"));
		s1.setName(rs.getString("name"));
		s1.setMobile(rs.getLong("mobile"));
		s1.setCountry(rs.getString("country"));
		return s1;
	}

}
