package com.manish.spring.jdbc.mysql.repository;

import java.util.List;

import com.manish.spring.jdbc.mysql.model.TraningCenter;

public interface TraningCenterRepository {
	int save(TraningCenter traningCenter);

	List<TraningCenter> findAll();
}
