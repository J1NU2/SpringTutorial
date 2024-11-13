<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<style>
	body {
        width: 1400px;
		padding: 30px;
	}
    .board {
        border: 1px solid black;
        padding: 20px;
    }
    .board_table {
        width: 100%;
        border: 1px solid black;
    }
    th, td {
        border: 1px solid black;
        padding: 10px 5px;
        text-align: center;
    }
    .write_button {
        margin-top: 20px;
        text-align: center;
    }
    .write_button input {
        font-size: 20px;
        padding: 10px 20px;
    }
</style>
<body>
	<div class="board">
		<table class="board_table">
			<thead>
				<tr>
					<th style="width: 5%;">번호</th>
					<th style="width: 45%;">제목</th>
					<th style="width: 15%;">작성자</th>
					<th style="width: 15%;">작성일</th>
					<th style="width: 10%;">공개여부</th>
					<th style="width: 10%;">삭제</th>
				</tr>
			</thead>
			<tbody>
                <!--
                <tr>
                    <td>1</td>
                    <td>김아무개의 글</td>
                    <td>김아무개</td>
                    <td>xxxx.xx.xx</td>
                    <td>공개</td>
                    <td>삭제</td>
                </tr>
                -->
                <c:forEach items="${boardlist}" var="boardvo">
                    <tr>
                        <td>${boardvo.num}</td>
                        <td>${boardvo.title}</td>
                        <td>${boardvo.username}</td>
                        <td>${boardvo.indate}</td>
                        <td>${boardvo.release}</td>
                        <td><a href="board_del?num=${boardvo.num}">삭제</a></td>
                    </tr>
                </c:forEach>
			</tbody>
		</table>
		<div class="write_button">
            <form action="board_write" method="get">
            	<!-- form태그 또는 a태그 사용 -->
                <input type="button" value="게시글 쓰기">
            </form>
		</div>
	</div>
</body>
</html>
