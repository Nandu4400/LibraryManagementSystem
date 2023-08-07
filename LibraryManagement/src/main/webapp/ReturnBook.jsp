<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Returning Book</title>
    <link rel="stylesheet" href="css/Returnstyle.css">
</head>
<body>
    <div class="Container">
    <form action="Return" method="post">
        <h4> Returning Book</h4>
        <div class="user-details">
            <div class="input-box">
                <span class="Book name">Book Name</span>
                <input type="text" name="BookName" placeholder="Enter book name" required>
            </div>
            <div class="input-box">
                <span class="Book name">User Name</span>
                <input type="text" name="user" placeholder="Enter your Username" required>
            </div>
            <div class="input-box">
                <span class="Publication Date">Lend Date</span>
                <input type="text" name="LendDate" placeholder="Enter Lend Date" required>
            </div>
            <div class="input-box">
                <span class="Book name">Return Date</span>
                <input type="text" name="ReturnDate" placeholder="Enter the Date" required>
            </div>
            <input type="submit" value="Return Book" class="btn" >
        </div>
    </form>
</div>
</body>
</html>