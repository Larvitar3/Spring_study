package strategy;

import java.util.Base64;

public class Base64Straregy implements EncodingStatregy{

	@Override
	public String enciding(String text) {
		return Base64.getEncoder().encodeToString(text.getBytes());
		
	}

	
}
