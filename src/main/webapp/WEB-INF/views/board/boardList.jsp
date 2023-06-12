<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
table, th, td{
	border : 1px solid black;
  border-collapse : collapse;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="board">
				<tr onclick="location.href='boardInfo?bno=${board.bno}'">
					<td>${board.bno}</td>
					<td>${board.title }</td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy년 MM월 dd일"/></td> <!-- type="date" -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>