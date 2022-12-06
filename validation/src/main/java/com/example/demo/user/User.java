package com.example.demo.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
	
	@NotBlank(message = "이름을 입력해주세요")
	private String name;
	
	@Max(value = 100, message = "100세 이하로 입력해 주세요")
	private int age; 
	
	@Email
	private String email;
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다.")
	private String phoneNumber;
	
	// 202212 
	@Size(max = 6, min = 6)
	private String reqYearMonth;
	
	// custom validation 을 적용해 보자.
	//1. 2 ~  들어오는 형식은 yyyyMM 형식이지만 DB --> yyyy-MM (저장 처리를 해야 한다) 
	@AssertTrue(message = "yyyyMM 형식이 아닙니다")
	public boolean isReqYearMonth() {
		System.out.println("여기 코드가 동작 하나요?");
		// 로직 구현 
		// 구분자 값이 있어나 구분해서 값을 넣어주면 LocalDate 객체를 생성할 수 있다.
		// 555555
		// 5555 
	
		try {
			int tempYear = Integer.parseInt(getReqYearMonth().substring(0, 4));
			int tempMonth = Integer.parseInt(getReqYearMonth().substring(4, 6));
			System.out.println("tempYear " +  tempYear);
			System.out.println("tempMonth " +  tempMonth);
			// 2022-12-01
			LocalDate date = LocalDate.of(tempYear, tempMonth, 01);
			String converReqYerMont = date.format(DateTimeFormatter.ofPattern("yyyy-MM"));
			System.out.println(date);
			System.out.println("-----------");
			System.out.println(converReqYerMont);
			System.out.println("-----------");
			// false <--- date 가 기준 이다. 
//			boolean isAfter = date.isAfter(LocalDate.of(2023, 11, 01));
//			System.out.println("is After : " + isAfter);
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
		
		
		return true; 
	}
	
}