<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Word</title>
</head>
<body>
	<h2>단어장</h2>
	<form action="word" method="post">
		<input type="text" name="word" placeholder="단어">
		<input type="text" name="meaning" placeholder="뜻">
		<input type="submit" value="등록">
	</form>
	<form action="wordSearch" method="get">
		<input type="text" name="search" placeholder="단어 찾기">
		<input type="submit" value="찾기">
	</form>
</body>
</html>