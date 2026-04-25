<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>회원 목록</title>

    <style>
        * { box-sizing: border-box; }

        body {
            margin: 0;
            font-family: Arial;
            background: #f5f6fa;
        }

        .navbar {
            width: 100%;
            padding: 15px 30px;
            background: white;
            display: flex;
            justify-content: space-between;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        .home-btn {
            background: #4CAF50;
            color: white;
            padding: 8px 14px;
            border-radius: 6px;
            text-decoration: none;
        }

        .container {
            max-width: 600px;
            margin: 60px auto;
            padding: 30px;
            background: white;
            border-radius: 12px;
            text-align: center;
        }

        h1 { margin-bottom: 30px; }

        .card {
            background: #e9ecf1;
            padding: 20px;
            margin: 10px 0;
            border-radius: 10px;
            text-align: center;
        }

        .member-btn {
            display: inline-block;
            padding: 12px 20px;
            background: #4CAF50;
            color: white;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
        }

        .btn {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 20px;
            background: #4CAF50;
            color: white;
            border-radius: 6px;
            text-decoration: none;
        }
    </style>
</head>

<body>

<div class="navbar">
    <div>🚀 Member App</div>
    <a href="/front-controller/home" class="home-btn">🏠 Home</a>
</div>

<div class="container">
    <h1>회원 목록</h1>

    <c:forEach var="m" items="${members}">
        <div class="card">
            <a href="/front-controller/members/detail?id=${m.id}" class="member-btn">
                    ${m.name}
            </a>
        </div>
    </c:forEach>

    <a href="/front-controller/members/new-form" class="btn">회원 등록</a>
</div>

</body>
</html>