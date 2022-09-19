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
  <h2>회원 등급 관리</h2>         
  <table class="table table-hover">
    <thead>
      <tr>
        <th>아이디</th>
        <th>등급</th>

      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" val="m">
	      <tr>
	        <td>${m.me_id}</td>
	        <td class="form-group">
	        	<select class="form-control">
	        		<c:forEach begin="1" end="${user.me_authority - 1}" var="i">
	        			<option <c:if test="${m.me_authority == i}">selected</c:if>>${i}</option>
	        		</c:forEach>
	        	</select>
	        </td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>