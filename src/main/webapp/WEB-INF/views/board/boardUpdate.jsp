<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<!-- update를 Map으로 반환해서 form submit 속성을 막음.-->
	<form name="updateForm" action="boardUpdate" method="post" onsubmit="return false;"> 
		<div>
			<h3>게시글 수정</h3>
			<table>
				<tr>
					<th>번호</th>
					<td><input type="number" name="bno" value="${board.bno}" readonly></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${board.title}"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" value="${board.writer}" readonly></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="contents">${board.contents}</textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="text" name="image" value="${board.image }"></td>
				</tr>
				<tr>
					<th>수정날짜</th>
					<!-- <td><input type="date" name="updatedate" --> 
					<!-- <td><input type="date" name="updatedate" value="${board.updatedate}"></td> --> <!-- value는 html속성이지만 같은 시점에 컴파일 하지 않음 -->
					<td><input type="date" name="updatedate" 
								value='<fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd"/>'></td>
				</tr>
			</table>
			<button type="submit">수정</button>
			<button type="button" onclick="location.href='boardInfo?bno=${board.bno}'">취소</button>
		</div>
	</form>
	<script>
		function updateAjax(e){
				let boardDate = new FormData(document.querySelector("[name='updateForm']"));

				fetch(updateForm.action, {
					method : 'POST',
					// headers : {
					// 	'Content-Type': 'application/json' // json타입으로 넘어올 경우
					// },
					body : boardDate
				})
				.then(response=>response.json())
				.then(data=>{
					let message = '결과 : '+ data.result+' 게시글 번호 : '+ data['board_no'];
					alert(message);
				})
				.catch(err=>console.log(err));
		}
		document.querySelector('button[type="submit"]').addEventListener('click', updateAjax);

	</script>
</body>
</html>