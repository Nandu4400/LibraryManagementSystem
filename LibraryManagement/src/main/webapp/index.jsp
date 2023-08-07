<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href ="css/Style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link href="Registration.jsp">
</head>
<body>
    <div class="wrapper">
        <form action="login" method="post">
            <h1>Login</h1>
            <div class="input-box">
                <input type="text" name="user" id="user" placeholder="Username"
                required>
                <i class='bx bxs-user-circle'></i>
            </div>
            <div class="input-box">
                <input type="password" name="password" id="password" placeholder="Password"
                required>
                <i class='bx bxs-lock' ></i>
            </div>
            <div class="Forgot-password">
                <a href="#">Forgot Password?</a>
            </div>
            <input type="submit" value="Login" id="loginButton" class="btn">
            <br> <br>
            <a href="AdminLogin.jsp">
            <button type="button" class="btn"> Admin Login</button>
        </a>
            <div class="registration-link">
                <p>Don't have an account?
                    <a href="Registration.jsp">Sign Up</a>
                </p>
            </div>
        </form> 
    </div>
</body>
</html>