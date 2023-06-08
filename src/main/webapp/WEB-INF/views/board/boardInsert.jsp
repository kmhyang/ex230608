<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<form name="insertForm" action="boardInsert" method="post">
		<div>
			<h3>게시글 등록</h3>
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="contents" cols="2" rows="3"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="text" name="image"></td>
				</tr>
			</table>
			<button type="submit">등록</button>
			<button type="button" onclick="location.href='boardList'">목록</button>
		</div>
	</form>
</body>
</html>