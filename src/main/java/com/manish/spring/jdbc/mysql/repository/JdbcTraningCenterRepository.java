package com.manish.spring.jdbc.mysql.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manish.spring.jdbc.mysql.model.TraningCenter;

@Repository
public class JdbcTraningCenterRepository implements TraningCenterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(TraningCenter traningCenter) {
		return jdbcTemplate.update("INSERT INTO traningcenter (centerName, CenterCode, address,studentCapacity, coursesOffered, contactEmail, ContactPhone) VALUES(?,?,?,?,?,?,?)",
				new Object[] { traningCenter.getCenterName(), 
						traningCenter.getCenterCode(), traningCenter.getAddress(),
						traningCenter.getStudentCapacity(), traningCenter.getCoursesOffered(), traningCenter.getContactEmail(),
						traningCenter.getContactPhone() });
	}

	@Override
	public List<TraningCenter> findAll() {
		return jdbcTemplate.query("SELECT * from traningcenter", BeanPropertyRowMapper.newInstance(TraningCenter.class));
	}

}
