<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<style>
	body {
        width: 1400px;
		padding: 30px;
	}
    form {
        width: 100%;
        border: 1px solid black;
        padding: 30px;
        
        text-align: center;
    }
    .board_info > div {
        margin: 20px;
    }
    label {
        font-size: 20px;
        width: 200px;
        border: 1px solid black;
        display: inline-block;
    }
    input[type="text"] {
        font-size: 20px;
        width: 500px;
        height: 30px;
    }
    select[name="category"] {
        font-size: 20px;
        width: 507px;
        height: 30px;
    }
    textarea[name="content"] {
        font-size: 20px;
        width: 500px;
        height: 100px;
    }
    input[type="checkbox"] {
        width: 20px;
        height: 20px;
    }
    .submit_button {
        margin-top: 20px;
        text-align: center;
    }
    .submit_button input {
        font-size: 20px;
        padding: 10px 20px;
    }
</style>
<body>
    <form action="board_add" method="post">
        <div class="board_info">
            <div>
                <!-- 작성자 -->
                <label>작성자</label>
                <input type="text" name="username">
            </div>
            <div>
                <!-- 카테고리 -->
                <label>카테고리</label>
                <select name="category">
                    <option selected>자유</option>
                    <option>공부</option>
                    <option>취업</option>
                </select>
            </div>
            <div>
                <!-- 제목 -->
                <label>제목</label>
                <input type="text" name="title">
            </div>
            <div>
                <!-- 내용 -->
                <label>내용</label>
                <textarea name="content"></textarea>
            </div>
            <div>
                <!-- 공개여부 -->
                <label>공개여부</label>
                <input type="checkbox" name="release" value="1">
            </div>
        </div>
        <div class="submit_button">
            <input type="submit" value="등록하기">
        </div>
    </form>
</body>
</html>