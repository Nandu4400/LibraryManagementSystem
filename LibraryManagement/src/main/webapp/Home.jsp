<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Home Page</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/Hstyle.css">
    </head>
<body>
    <div class="Home">
    <form action="Home" method="post">
        <h1> Welcome to the Libaray </h1>
        <br> <br>
        <div class="input-box">
            <input type="text" name="search"  id="search" placeholder="Search book"
            required>
            <i  class='bx bx-search' id="search" ></i>
            </div>
            <br> <br>
        <input  type="submit" value="Lend Book" class="btn">
        <br> <br>
        <a href="ReturnBook.jsp">
        <button type="button" class="btn">Return Book</button>
        </a>
    </form>
        
    </div>
   </body>
</html>