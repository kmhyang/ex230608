package com.yedam.app.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails { 
	// UserVO라고 쓰는걸 권장하지 않음 : json으로 넘길때 getAuthorities() : 에러날 수 있음
	// UserVO+필드를 따로 만들고
	
//	private MemberVO member; //(id, pwd, role 필드가 속한 memberVO를 가져옴)
	
	private String id;
	private String pwd;
	private String role;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> auth = new ArrayList<>();
	     auth.add(new SimpleGrantedAuthority(this.role));
	     return auth;
	}

	@Override
	public String getPassword() {
		return pwd;
	}

	@Override
	public String getUsername() {
		return id;
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
