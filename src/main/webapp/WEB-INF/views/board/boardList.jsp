<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table, tr, th, td {
	border-collapse: collapse;
}

td, th {
	border: 1px solid gray;
	text-align: center;
	width: 150px;
	height: 30px;
}

.content {
	width: 400px;
}
</style>
<title>**Spring MVC2 BoardList**</title>
</head>
<body>
	<h2>**Spring MVC2 BoardList(조회수증가, 답글)**</h2>
	<c:if test="${message!=null }">
	${message }
	<br>
	</c:if>

	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.seq}</td>
				<td>
					<!--indent값에 따른 들여쓰기  -->
					<a href="bdetail?seq=${list.seq}&id=${list.id}">
						<c:if test="${list.indent > 0}">
							<c:forEach begin="1" end="${list.indent}">
								<span>&nbsp;&nbsp;</span>
							</c:forEach>
							<span style="color:orange">RE..</span>
						</c:if>
						${list.title}</a>
					<!-- ----------------------------- -->
				</td>
				<td>${list.id}</td>
				<td>${list.regdate}</td>
				<td>${list.cnt}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<c:if test="${logID != null}">
		<a href="binsertf">[글쓰기]</a>
		<br>
	</c:if>
	<a href="home">[home]</a>
</body>
</html>