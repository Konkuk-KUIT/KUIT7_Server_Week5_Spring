<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>회원 등록</title>

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

        input {
            width: 100%;
            padding: 12px;
            margin-bottom: 15px;
        }

        .btn {
            width: 100%;
            padding: 12px;
            background: #4CAF50;
            color: white;
            border: none;
            border-radius: 6px;
        }
    </style>
</head>

<body>

<div class="navbar">
    <div>🚀 Member App</div>
    <a href="/home" class="home-btn">🏠 Home</a>
</div>

<div class="container">
    <h1>회원 등록</h1>

    <form method="post" action="/members/save">
        <input name="name" placeholder="이름 입력">
        <button class="btn">등록</button>
    </form>
</div>

</body>
</html>