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
					<td><textarea name="contents" cols="20" rows="3"></textarea></td>
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
	<script>
		
		document.querySelector("[name='insertForm']").addEventListener('submit',function(e){
			e.preventDefault(); // 기존에 default로 등록된  submit 동작을 막음.
			//getElementsByName : 배열이라서 인덱스 지정해줘야 됨.
			let title = document.getElementsByName('title')[0];
			let writer = document.getElementsByName('writer')[0];
			let contents = document.getElementsByName('contents')[0];

			if(title.value == ''){
				alert('제목 입력하세요 ');
				title.focus();
				return;
			}
			if(contents.value == ''){
				alert('내용 입력하세요 ');
				contents.focus();
				return;
			}
			if(writer.value == ''){
				alert('작성자 입력하세요 ');
				writer.focus();
				return;
			}

			insertForm.submit();
		})

	</script>
</body>
</html>