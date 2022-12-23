package com.demo.qlem.dto.res;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SalariesDTO {

	private String first_name;
	private int emp_no;
	private int age;
	private int total;
	private int max_salary;
	
	
	
	public SalariesDTO(String first_name, Integer emp_no, BigInteger age, BigDecimal total) {
		super(); 
		this.first_name = first_name;
		this.emp_no = emp_no.intValue();
		this.age = age.intValue();
		this.total = total.intValue();
	}



	public SalariesDTO(String first_name, Integer emp_no, BigInteger age, Integer max_salary) {
		super();
		this.first_name = first_name;
		this.emp_no = emp_no.intValue();
		this.age = age.intValue();
		this.max_salary = max_salary.intValue();
	}
	
	


	
	
	
}
