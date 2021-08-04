package com.spring.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.spring.pojo.Student;

public class StudentDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Integer saveStudent(Student student) {
		String query="insert into student_details values(?,?,?,?)";
		PreparedStatementCallback<Integer> statement=(preparedStatement)->{
			preparedStatement.setInt(1,student.getStudID());  
			preparedStatement.setString(2,student.getStudName());  
			preparedStatement.setInt(3,student.getStudAge());
			preparedStatement.setString(4, student.getStudEmail());
	              
	        return preparedStatement.executeUpdate(); 
		};
		
		return jdbcTemplate.execute(query, statement);
	}
	
	public List<Student> getStudents() {
		String query="select * from student_details";
		RowMapper<Student> map=(resultSet,rowNumber)->{
			Student student=new Student();
			student.setStudID(resultSet.getInt(1));
			student.setStudName(resultSet.getString(2));
			student.setStudAge(resultSet.getInt(3));
			student.setStudEmail(resultSet.getString(4));
			
			return student;
		};
		
		return jdbcTemplate.query(query, map);
	}
	
	
	public Student getStudentById(int id) { 
		  String query="select * from student_details where studId=?";
		  
		  return jdbcTemplate.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
	  
	}
	 
	public Integer updateStudent(Student student) {
		String query="update student_details set studName=?,studAge=?,studEmail=? where studId=?";
		PreparedStatementCallback<Integer> statement=(preparedStatement)->{
			preparedStatement.setString(1, student.getStudName());
			preparedStatement.setInt(2, student.getStudAge());
			preparedStatement.setString(3, student.getStudEmail());
			preparedStatement.setInt(4, student.getStudID());
			
			return preparedStatement.executeUpdate();
		};
		
		return jdbcTemplate.execute(query, statement);
	}
	
	public int deleteStudentById(int id) {
		String query="delete from student_details where studId="+id;
		return jdbcTemplate.update(query);
	}
}
