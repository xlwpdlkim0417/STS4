<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<head>
<title>top page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
h1 {
	font-size: 18pt;
	font-weight: bold;
	color: gray;
}

body {
	font-size: 13pt;
	color: gray;
	margin: 5px 25px;
}

tr {
	margin: 5px;
}

th {
	padding: 5px;
	color: white;
	background: darkgray;
}

td {
	padding: 5px;
	color: black;
	background: #e0e0ff;
}

.err {
	color: red;
}
</style>
</head>
<body>
	<h1>Hello page</h1>
	<hr />

	<table>

		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>연령</th>
			<th>메일</th>
			<th>메모</th>
			<th colspan="2">Action</th>
		</tr>

		<c:forEach var="member" items="${members}">
			<tr>

				<td>${member.id }</td>
				<td>${member.name }</td>
				<td>${member.age }</td>
				<td>${member.email }</td>
				<td>${member.memo }</td>
				<td>
					<form method="post" action="updateForm">
						<input type="hidden" name="id" value="${member.id}" /> <input
							type="submit" name="업데이트" value="Update">
					</form>
				</td>
				<td>
					<form method="post" action="delete">
						<input type="hidden" name="id" value="${member.id}" /> <input
							type="submit" value="Delete" />
					</form>

				</td>

			</tr>
		</c:forEach>

	</table>


</body>
</html>
