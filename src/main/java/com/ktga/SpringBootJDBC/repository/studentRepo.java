package com.ktga.SpringBootJDBC.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ktga.SpringBootJDBC.model.student;

@Repository
public class studentRepo {
	
	@Autowired
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(student s) {
		String sql="insert into jdbc_template (id,name,mark)values(?,?,?)";
		int row = template.update(sql,s.getId(),s.getName(),s.getMark());
		System.out.println(row + "row/s affected");
	}
	
	public List<student> getStudent(){
		String sql="select * from jdbc_template";
		
		RowMapper<student> rm = new RowMapper<student>() {
			@Override
			public student mapRow(ResultSet rs, int rowNum) throws SQLException {
				student s = new student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setMark(rs.getInt(3));
				return s;
			}
		};
		
//		RowMapper<student> st = (rs,rowNum) -> {
//			student s = new student();
//			s.setId(rs.getInt(1));
//			s.setName(rs.getString(2));
//			s.setMark(rs.getInt(3));
//			return s;
//		};
		
		List<student> students = template.query(sql, rm);
		return students;
	}
}
