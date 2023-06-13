package com.yedam.app.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

import com.yedam.app.user.mapper.UserMapper;

//@Service("UserDetailsService")
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;

	//로그인 정보처리 클래스
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = userMapper.getUser(username);

		// 해당 사용자 존재 유무 확인
		if (vo == null) {
			throw new UsernameNotFoundException("no user");
		}

		// 비밀번호 확인

		// 권한 지정
//		List<GrantedAuthority> auth = new ArrayList<>();
//		auth.add(new SimpleGrantedAuthority(vo.getRole()));
//
//		return new UserVO(username, vo.getPassword(), auth);
		return vo;
	}

}
