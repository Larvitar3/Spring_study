package com.demo.qlem.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import com.demo.qlem.dto.res.EmployeeDTO;
import com.demo.qlem.dto.res.SalariesDTO;

@Repository
public class EmployeeRepository {

	// 준비물 1. EntityManager
	private final EntityManager entityManager;

	public EmployeeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// 기능 설계
	public EmployeeDTO getOldEmployeeAgeInfo() {

		// 어노테이션 기반이 아닌 직접 생성 ( native query )
		String strQuery = " SELECT " 
						+ " *, TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS age " 
						+ " FROM " 
						+ " employees "
						+ " WHERE " 
						+ " emp_no = 10001; ";

		Query nativeQuery = entityManager.createNativeQuery(strQuery);
		
		// QLRM 사용
		JpaResultMapper mapper = new JpaResultMapper();
		
		EmployeeDTO dto = mapper.uniqueResult(nativeQuery, EmployeeDTO.class);

		return dto;
		
	}
	
	// 사원번호 10312 직원의 이름, 사원번호, 나이, 연봉 총합 을 출력
	
	public SalariesDTO getSalarInfo() {
		String strQuery = " SELECT "
						+ " first_name,"
						+ " E.emp_no, "
						+ " TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS age, "
						+ " sum(salary) AS total "
						+ " FROM "
						+ " employees AS E "
						+ " JOIN "
						+ " salaries AS S ON E.emp_no = S.emp_no "
						+ " WHERE "
						+ " E.emp_no = 10312;";
		
		Query nativeQuery = entityManager.createNativeQuery(strQuery);
		JpaResultMapper mapper = new JpaResultMapper();
		SalariesDTO dto = mapper.uniqueResult(nativeQuery, SalariesDTO.class);
		return dto;
	}
	
	// 연봉이 78000 ~ 82000 인 사람들의 이름, 사원번호, 나이, 최고 연봉을 출력
	// (중복된 사원번호가 없게 출력)

	public List<SalariesDTO> getSalarList() {
		String strQuery = " SELECT "
						+ " first_name, "
						+ " E.emp_no, "
						+ " TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS age, "
						+ " max(salary) AS max_salary "
						+ " FROM "
						+ " employees AS E "
						+ " JOIN "
						+ " salaries AS S ON E.emp_no = S.emp_no "
						+ " WHERE "
						+ " salary > 78000 AND salary <  82000 "
						+ " GROUP BY e.emp_no;";
		
		Query nativeQuery = entityManager.createNativeQuery(strQuery);
		JpaResultMapper mapper = new JpaResultMapper();
		List<SalariesDTO> dtoList = mapper.list(nativeQuery, SalariesDTO.class);
		
		for(int i = 0; i < dtoList.size(); i++) {
			dtoList.get(i);
			i++;
		}
		
		return dtoList;
		
	}

	
	
	
	
	

}
