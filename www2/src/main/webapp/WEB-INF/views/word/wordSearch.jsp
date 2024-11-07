<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Word Search</title>
</head>
<body>
	<h2>&quot;${search}&quot;의 검색 결과</h2>
	<div>
		<p>단어 : ${word}</p>
		<p>뜻 : ${meaning}</p>	
	</div>
	<form action="word" method="get">
		<a href="word"><input type="button" value="뒤로가기"></a>
	</form>
</body>
</html>