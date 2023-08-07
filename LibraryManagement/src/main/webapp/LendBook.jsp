<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lending book</title>
    <link rel="stylesheet" href="css/Lstyle.css">
</head>
<body>
    <div class="Container">
    <form action="LendBook" method="post">
        <h4>Lending Book</h4>
        <div class="user-details">
            <div class="input-box">
                <span class="Book name">Book Name</span>
                <input type="text" name="BookName" placeholder="Enter book name" required>
            </div>
            <div class="input-box">
                <span class="Book name">Username</span>
                <input type="text" name="user" placeholder="Enter your Username" required>
            </div>
            <div class="input-box">
                <span class="Book name">Lend Date</span>
                <input type="text" name="LendDate" placeholder="Enter the Date" required>
            </div>
            <input type="submit" value="Lend Book" class="btn" >
        </div>
    </form>
</div>
</body>
</html>