package com.demo.qlem.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.qlem.dto.res.EmployeeDTO;
import com.demo.qlem.dto.res.SalariesDTO;
import com.demo.qlem.repository.EmployeeRepository;

@RestController
public class HomeApiController {

	// service를 만들지 않고 바로 repository 테스트
	
	private EmployeeRepository employeeRepository;
	
	public HomeApiController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping({"", "/index", "/home"})
	public ResponseEntity<?> home() {
//		EmployeeDTO resultDTO = employeeRepository.getOldEmployeeAgeInfo();
		
		SalariesDTO resultDTO = employeeRepository.getSalarInfo();

		
		return new ResponseEntity(resultDTO, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> homeList(){
		
		List<SalariesDTO> list = employeeRepository.getSalarList();
		
		return new ResponseEntity<List<SalariesDTO>>(list, HttpStatus.OK);
	}
	
}
