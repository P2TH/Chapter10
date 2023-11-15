<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
<style type="text/css">
	table { border-collapse:collapse; }
	table.wth { width:500px; }
	tr, td { padding:3px; }
	td.head{
		font-size:25px; font-weight:bold;
		text-align:center; padding:10px;
	}
	td.left { width:80px; background-color:#dddddd; }
	a { text-decoration:none; }
</style>
</head>
<body>
	<table class="wth">
		<tr><td class="head">레코드 리스트</td></tr>
		<tr><td align="right"><a href="logout.do">${userID }님 로그아웃</a></td></tr>
	</table>
	<table border=1 class="wth">
		<tr align=center>
			<td class="left">번호</td>
			<td class="left">제목</td>
			<td class="left">작성자</td>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td width=50 align=center>${board.seq}</td>
				<td width=350 align=left>
					<a href="getBoard.do?seq=${board.seq}">${board.title}</a>
				</td>
				<td width=100 align=center>${board.writer}</td>
			</tr>
		</c:forEach>
	</table>
	<table class="wth" border=0>
		<tr>
			<td align="center">
				<input type="button" value="입력" onClick=location.replace("insertBoardForm.do")>
			</td>
		</tr>
	</table>

</body>
</html>