<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sec:csrfMetaTags/>
<title>top.jsp</title>
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
			<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	</ul>
	
	<sec:authorize access="isAuthenticated()"> <!-- 인증만 되어있으면 접근 허용 -->
		<form action="logout" method="post">
			<sec:csrfInput/>
			<button>로그아웃</button>
		</form>
	</sec:authorize>
	
	<!-- header : <sec:csrfMetaTags/> 같이 사용해야 함. -->
	<input type="hidden" name="csrf_name" value="${_csrf.parameterName }">
	<input type="hidden" name="csrf_val" value="${_csrf.token }">
	<!-- name="" parameterName 변동성이 있음. -->
</body>
</html>