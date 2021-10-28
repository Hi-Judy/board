<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 정보</title>
</head>
<body>
	<jsp:include page="../home/header.jsp"/>
	<div align="center">
		<div><h1>나의 회원 정보 보기</h1></div>
		<div>
			<form id="frm" action="memberSelect.do" method="post">
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width="150">${member.id }</td>
					</tr>
					<tr>
						<th width="150">이름</th>
						<td width="150">${member.name }</td>
					</tr>
					<tr>
						<th width="150">비밀번호</th>
						<td width="150">${member.password }</td>
					</tr>
					<tr>
						<th width="150">주소</th>
						<td width="150">${member.address }</td>
					</tr>
					<tr>
						<th width="150">전화번호</th>
						<td width="150">${member.tel }</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>