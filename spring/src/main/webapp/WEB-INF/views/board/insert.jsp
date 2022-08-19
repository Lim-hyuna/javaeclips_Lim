<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="post" class="mt-5" enctype="multipart/form-data"> <!-- action 생략-> 현제 url을 기준으로 전송함 -->
			<h1>게시글 등록</h1>
			<div class="form-group">
			  <input type="text" class="form-control" name="bd_title" placeholder="제목">
			</div>
			<div class="form-group">
			  <textarea class="form-control" rows="10" name="bd_content" placeholder="내용"></textarea>
			</div>
			<div class="form-group">
				<label>첨부파일(최대 3개 선택)</label>
				<input type="file" class="form-control" name="files">
				<input type="file" class="form-control" name="files">
				<input type="file" class="form-control" name="files">
			</div>
			<button class="btn btn-outline-primary col-12 mb-3">게시글 등록</button>
		</form>
	</div>
</body>
</html>