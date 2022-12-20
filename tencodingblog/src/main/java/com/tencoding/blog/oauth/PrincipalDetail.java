package com.tencoding.blog.oauth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tencoding.blog.dto.User;
//시큐리티가 로그인 요청을 가로채서
//로그인을 처리하고(DB) 완료되면 UserDetails 타입의
//오브젝트를 시큐리티의 고유한 세션 저장소에 저장을 해준다.
//(우리가 새롭게 정의한 Object로 처리할 예정)
public class PrincipalDetail implements UserDetails{
	
	private User user;
	
	public PrincipalDetail(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collection = new ArrayList<>();
		
		collection.add(() -> {
			return "ROLE_" + user.getRole();
		});
		
		return collection;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
