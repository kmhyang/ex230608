<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시글 정보</title>
</head>

<body>
	<table>
		<tr>
			<th>번호</th>
			<td>${board.bno}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="2" cols="6" readonly>${board.contents}</textarea>
			</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
				<!-- <img src="{pageContext.request.contextPath}/resources/images/{board.image}" style="width: 300px;"> -->
				<c:choose>
					<c:when test="${not empty board.image}"><!-- 문자열 : 비어있지 않다?? empty : 객체 값을 체크함 -->
						<img src='<c:url value="/resources/images/${board.image}"/>' style="width: 500px;" />
						<!-- c:url이 자동으로 절대 경로 잡아줌 -->
						${board.image}
			</td>
			</c:when>
			<c:otherwise>
				<td>파일 없음</td>
			</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>
				<fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
	</table>
	<button type="button" onclick="location.href='boardUpdate?bno=${board.bno}'">수정</button>
	<button type="button" onclick="location.href='boardDelete?bno=${board.bno}'">삭제</button>
</body>
</html>