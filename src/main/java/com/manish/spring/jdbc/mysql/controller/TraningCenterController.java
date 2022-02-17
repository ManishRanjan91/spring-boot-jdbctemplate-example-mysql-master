package com.manish.spring.jdbc.mysql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.spring.jdbc.mysql.model.TraningCenter;
import com.manish.spring.jdbc.mysql.repository.TraningCenterRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TraningCenterController {

	@Autowired
	TraningCenterRepository traningCenterRepository;

	@GetMapping("/traningCenter")
	public ResponseEntity<List<TraningCenter>> getAllTraningCenters() {
		try {
			List<TraningCenter> traningCenters = new ArrayList<TraningCenter>();

			traningCenterRepository.findAll().forEach(traningCenters::add);

			if (traningCenters.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}


			return new ResponseEntity<>(traningCenters, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/traningCenter")
	public ResponseEntity<String> createTraningCenter(@RequestBody TraningCenter traningCenter) {
		try {
			if (traningCenter.getCenterName() == null || traningCenter.getCenterName() =="") {
				return new ResponseEntity<>("Please Enter center name",HttpStatus.NOT_FOUND);
			}
			else if (traningCenter.getCenterCode() == null || traningCenter.getCenterCode() =="") {
				return new ResponseEntity<>("Please Enter center code",HttpStatus.NOT_FOUND);
			}
			else if (traningCenter.getAddress() == null || traningCenter.getAddress() =="") {
				return new ResponseEntity<>("Please Enter address",HttpStatus.NOT_FOUND);
			}
			else if (traningCenter.getContactPhone() == null || traningCenter.getContactPhone() == "") {
				return new ResponseEntity<>("Please Enter phone number",HttpStatus.NOT_FOUND);
			}
			else {
				String phonePattern = "^[1-9][0-9]{9}$";
				String alphaNumericPattern = "[a-zA-Z0-9]+";
				if(traningCenter.getCenterName().length() > 40) {
					return new ResponseEntity<>("Please Enter center name less than 40 characters.",HttpStatus.NOT_FOUND);
				}
				else if(!traningCenter.getContactPhone().matches(phonePattern)) {
					return new ResponseEntity<>("Please Enter correct phone number",HttpStatus.NOT_FOUND);
				}
				else if(traningCenter.getCenterCode().length() > 12 || traningCenter.getCenterCode().length() < 12) {
					return new ResponseEntity<>("Please Enter center code 12 digit.",HttpStatus.NOT_FOUND);
				}
				else if(!traningCenter.getCenterCode().matches(alphaNumericPattern)) {
					return new ResponseEntity<>("Please Enter center code only alpha numeric.",HttpStatus.NOT_FOUND);
				}
				else {
					traningCenterRepository.save(new TraningCenter(
							traningCenter.getCenterName(), 
							traningCenter.getCenterCode(), traningCenter.getAddress(),
							traningCenter.getStudentCapacity(), traningCenter.getCoursesOffered(), traningCenter.getContactEmail(),
							traningCenter.getContactPhone()));
					return new ResponseEntity<>("Traning Center has been created successfully!", HttpStatus.CREATED);
				}
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
