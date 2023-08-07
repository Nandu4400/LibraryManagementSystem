<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administrator</title>
    <link rel="stylesheet" href="css/Astyle.css">
</head>
<body>
    <div class="Container">
    <form action="adminwork" method="post">
        <h4>Administrator</h4>
        <div class="user-details">
            <div class="input-box">
                <span class="Book Id">Unique Book Id</span>
                <input type="text" name="unique" placeholder="Unique book Id" required>
            </div>
            <div class="input-box">
                <span class="Book Id">Book Id</span>
                <input type="text" name="bookId" placeholder="Enter book Id" required>
            </div>
            <div class="input-box">
                <span class="Book name">Book Name</span>
                <input type="text" name="bookName" placeholder="Enter book name" required>
            </div>
            <div class="input-box">
                <span class="Publication Date">Published Date</span>
                <input type="text" name="publishDate" placeholder="Enter Publication Date" required>
            </div>
            <div class="input-box">
                <span class="Book name">BookAddition Date</span>
                <input type="text" name="BookAddDate" placeholder="BookAddition Date" required>
            </div>
            <br> <br>
            
        </div>
        <div class="box">
            <input type="submit" name="action" class="btn" value="Add book">
            <input type="submit" name="action" class="btn" value="Remove book">
            </div>
    </form>
</div>

    
</body>
</html>