<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>241030 오후 웹 페이지</title>
</head>
<style>
    body {
        /* background-color: aquamarine; */
        width: 1280px;
        height: 1024px;
        /* border: 1px solid black; */
        margin: 5px;
    }
    header {
        background-color: whitesmoke;
        width: 100%;
        height: 80px;

        /* float: left; */
        display: flex;
    }
    .header_01 {
        width: 50%;
        height: 100%;
        padding-left: 30px;
        
        display: flex;
        justify-content: flex-start;
        align-items: center;
    }
    .header_01 * {
        margin-right: 30px;
        
    }
    .header_01 img {
        width: 45px;
        height: 45px;
        border-radius: 50%;
    }
    .header_02 {
        width: 50%;
        height: 100%;
        padding-right: 30px;
        
        display: flex;
        justify-content: flex-end;
        align-items: center;
    }
    .header_02 * {
        margin-left: 30px;
    }
    .header_02 input[type="text"] {
        width: 250px;
        height: 15px;
        border-radius: 10px;
        padding: 15px;
    }
    .header_02 img {
        width: 50px;
        height: 50px;
        border: 1px solid gainsboro;
        border-radius: 50%;
    }
    nav {
        background-color: whitesmoke;
        width: 100%;
        height: 80px;
        border-bottom: 1px solid gainsboro;
        
        /* float: left; */
        display: flex;
        align-items: center;
    }
    nav ul li {
        background-color: whitesmoke;
        border: 1px solid whitesmoke;
        border-radius: 15px;
        margin-right: 30px;
        padding: 10px;
        
        display: inline-block;
    }
    nav ul li:hover {
        background-color: gainsboro;
    }
    nav ul li span {
        font-size: 18px;
        /* font-weight: bold; */
    }
    aside {
        /* background-color: skyblue; */
        width: 30%;
        height: 700px;
        
        float: left;
    }
    .aside_img {
        /* background-color: red; */
        height: 50%;
        
        text-align: center;
    }
    .aside_img::after {
        height: 100%;
        
        display: inline-block;
        content: "";
        vertical-align: middle;
    }
    .aside_img img {
        width: 90%;
        height: 90%;
        border: 1px solid gainsboro;
        border-radius: 50%;

        vertical-align: middle;
    }
    .aside_name {
        /* background-color: wheat; */
        padding: 10px 20px;
        padding-top: 0;
    }
    .aside_name span {
        color: dimgray;
        font-size: 30px;
    }
    .aside_button {
        /* background-color: green; */
        height: 7%;

        text-align: center;
    }
    .aside_button input {
        background-color: white;
        font-size: 18px;
        font-weight: bold;
        width: 90%;
        height: 100%;
        border: 1px solid gainsboro;
        border-radius: 10px;
        padding: 15px;
    }
    .aside_button input:hover {
        background-color: gainsboro;
    }
    .aside_follow {
        /* background-color: yellow; */
        height: 5%;
        padding: 10px 20px;
    }
    .aside_follow span {
        color: dimgray;
        font-size: 18px;
        margin-right: 8px;
    }
    .follow_num {
        font-weight: bold;
    }
    .aside_org {
        /* background-color: purple; */
        height: 25%;
        padding: 10px 20px;
    }
    .aside_org hr {
        border: 1px solid gainsboro;
        margin-bottom: 25px;
    }
    .aside_org span {
        font-size: 20px;
        font-weight: bold;
    }
    .org_img {
        margin-top: 10px;
    }
    .org_img img {
        width: 50px;
        height: 50px;
        border: 1px solid gainsboro;
        border-radius: 10px;
        margin: 5px 5px 0 0;
    }
    section {
        /* background-color: deepskyblue; */
        width: 70%;
        height: 700px;
        
        float: left;
    }
    .pinned {
        /* background-color: skyblue; */
        width: 100%;
        height: 50px;
        /* margin-bottom: 10px; */

        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .pinned span {
        margin: auto 20px;
    }
    .pinned_content {
        /* background-color: aquamarine; */
        width: 100%;
        height: 350px;
        /* padding: 10px 0 0 20px; */
    }
    .pinned_one {
        /* background-color: skyblue; */
        width: 40%;
        height: 30%;
        border: 1px solid gainsboro;
        border-radius: 15px;
        margin: 10px 20px 10px 20px;
        padding: 15px 20px;

        display: inline-block;
    }
    .pinned_one p {
        color: dimgray;
    }
    .pinned_title {
        font-weight: bold;
    }
    .title_label {
        color: dodgerblue;
    }
    .access_label {
        color: dimgray;
        border: 1px solid gainsboro;
        border-radius: 15px;
        margin-left: 10px;
        padding: 0 5px;
    }
    footer {
        /* background-color: dodgerblue; */
        width: 100%;
        padding: 30px 0;
        
        float: left;
    }
    footer div {
        padding: 5px 0;

        text-align: center;
    }
    footer div span {
        color: dimgray;
    }
    .footer_first span {
        margin: 0 15px;
    }
</style>
<body>
    <header>
        <div class="header_01">
            <!-- 이미지 절대주소 지정 -->
            <img src="https://cdn.iconscout.com/icon/free/png-256/free-github-logo-3002017-2496133.png" alt="GitHub_Icon">
            <span style="font-size: 20px; font-weight: bold;">Racoon</span>
        </div>
        <div class="header_02">
            <form action="" method="">
                <input type="text" placeholder="Search">
            </form>
            <!-- 이미지 절대주소 지정 -->
            <img src="https://avatars.githubusercontent.com/u/104364437" alt="My_Profile">
        </div>
    </header>
    <nav>
        <ul>
            <li><span>Overview</span></li>
            <li><span>Repositories</span></li>
            <li><span>Projects</span></li>
            <li><span>Packages</span></li>
            <li><span>Stars</span></li>
            <li><a href="board"><span>게시판가기</span></a></li>
        </ul>
    </nav>
    <aside style="margin-top: 40px;">
        <div class="aside_img">
            <!-- 이미지 절대주소 지정 -->
            <img src="https://avatars.githubusercontent.com/u/104364437" alt="My_Profile">
        </div>
        <div class="aside_name">
            <span>Racoon</span>
        </div>
        <div class="aside_button">
            <form action="" method="">
                <input type="button" value="Edit profile">
            </form>
        </div>
        <div class="aside_follow">
            <span class="follow_num">3</span><span>followers</span>
            <span class="follow_num">3</span><span>following</span>
        </div>
        <div class="aside_org">
            <hr>
            <span>Organizations</span>
            <div class="org_img">
                <!-- 이미지 상대주소 지정 -->
                <img src="<%=request.getContextPath()%>/resources/img/org_1.jpg" alt="Org_img">
                <img src="<%=request.getContextPath()%>/resources/img/org_2.jpg" alt="Org_img">
            </div>
        </div>
    </aside>
    <section style="margin-top: 40px;">
        <div>
            <div class="pinned">
                <span style="font-size: 20px;">Pinned</span>
                <span style="color: dodgerblue">Customize your pins</span>
            </div>
            <div class="pinned_content">
                <div class="pinned_one">
                    <div class="pinned_title">
                        <span class="title_label">Repository Name</span>
                        <span class="access_label">Public</span>
                    </div>
                    <p>Repository Detail</p>
                    <p>Programming Language</p>
                </div>
                <div class="pinned_one">
                    <div class="pinned_title">
                        <span class="title_label">Repository Name</span>
                        <span class="access_label">Public</span>
                    </div>
                    <p>Repository Detail</p>
                    <p>Programming Language</p>
                </div>
                <div class="pinned_one">
                    <div class="pinned_title">
                        <span class="title_label">Repository Name</span>
                        <span class="access_label">Public</span>
                    </div>
                    <p>Repository Detail</p>
                    <p>Programming Language</p>
                </div>
            </div>
        </div>
    </section>
    <footer>
        <div class="footer_first">
            <span>박진우</span>
            <span>휴먼교육센터</span>
            <span>HTML</span>
            <span>GitHub</span>
            <span>Clone</span>
        </div>
        <div class="footer_second">
            <span>@ 2024.10.30</span>
        </div>
    </footer>
</body>
</html>