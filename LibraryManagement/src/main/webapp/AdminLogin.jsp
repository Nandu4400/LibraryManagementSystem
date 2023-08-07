<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminLogin</title>
    <link rel="stylesheet" href="css/ALstyle.css">
</head>
<body>
    <div class="wrapper">
        <form method="post" action="Admin" id="Admin">
            <h1>Admin Login</h1>
            <div class="input-box">
                <input type="text" name="user" id="user" placeholder="Username"
                required>
                <i class='bx bxs-user' ></i>
            </div>
            <div class="input-box">
                <input type="password" name="password" id="password" placeholder="Password"
                required>
                <i class='bx bxs-lock' ></i>
            </div>
            <div class="Forgot-password">
                <a href="#">Forgot Password?</a>
            </div>
            <input type="submit" value="Login" class="btn">
        </form>
    </div>
    
</body>
</html>