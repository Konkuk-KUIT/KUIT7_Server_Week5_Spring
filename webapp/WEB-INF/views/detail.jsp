<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>회원 상세</title>

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

        .card {
            background: #e9ecf1;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 20px;
        }

        .btn {
            padding: 10px 15px;
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
    <a href="/home" class="home-btn">🏠 Home</a>
</div>

<div class="container">
    <h1>회원 상세</h1>

    <div class="card">
        <p>ID: ${member.id}</p>
        <p>Name: ${member.name}</p>
    </div>

    <a href="members" class="btn">목록</a>
</div>

</body>
</html>