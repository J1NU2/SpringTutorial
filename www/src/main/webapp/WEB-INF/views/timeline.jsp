<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Timeline</title>
</head>
<body>
오후 일정 (5시 30분까지)<br>
　- 숨 쉬기<br>
　- 화장실 가지 말기<br>
　- 공부하기<br>
　- 졸지 않기<br>

<a href="<%=request.getContextPath()%>/viewMessage">[시간표보기]</a>
<!--
<a href="<%=request.getContextPath()%>/viewMessage?time=4&name=human">[시간표보기]</a>
-->

<br>GET방식<br>
<form action="viewMessage" method="get">
	<input type="text" name="time">
	<input type="text" name="name">
	<input type="submit" value="전송">
</form>

<br>POST방식<br>
<form action="viewMessage" method="post">
	<input type="text" name="time">
	<input type="text" name="name">
	<input type="submit" value="전송">
</form>
</body>
</html>