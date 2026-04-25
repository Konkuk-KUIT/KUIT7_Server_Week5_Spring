<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Home</title>

    <style>
        * { box-sizing: border-box; }

        body {
            margin: 0;
            font-family: Arial;
            background: #f5f6fa;
            overflow-x: hidden;
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
            margin: 80px auto;
            padding: 40px;
            background: white;
            border-radius: 12px;
            text-align: center;
        }

        h1 { margin-bottom: 30px; }

        .btn {
            display: inline-block;
            margin: 10px;
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
</div>

<div class="container">
    <h1>🏠 Home</h1>

    <a href="/front-controller/members/new-form" class="btn">회원 등록</a>
    <a href="/front-controller/members" class="btn">회원 목록</a>
</div>

</body>
</html>