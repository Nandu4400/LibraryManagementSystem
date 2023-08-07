<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="unpkg.com_sweetalert@2.1.2_dist_sweetalert.min.js"></script>
    <title>Registration</title>
    <link rel="stylesheet" href="css/Rstyle.css">
</head>
<body>
    <div class="Container">
        <div class="title">Registration</div>
        <form action="Registration" method="post">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">First Name</span>
                    <input type="text" name="FirstName" id="FirstName" placeholder="Enter your First Name" required>
                </div>
                <div class="input-box">
                    <span class="details">Last Name</span>
                    <input type="text" name="LastName" id="LastName" placeholder="Enter your Last Name" required>
                </div>
                <div class="input-box">
                    <span class="details">Guardian Name</span>
                    <input type="text" name="GuardianName" id="GuardianName" placeholder="Enter your Guardian Name">
                </div>
                <div class="input-box">
                    <span class="details">Mobile number</span>
                    <input type="text" name="Contact" id="Contact" placeholder="Contact number" required>
                </div>
                <div class="input-box">
                    <span class="details">Email Id</span>
                    <input type="text" name="Email" id="Email" placeholder="Enter your Email Id" required>
                </div>
                <div class="input-box">
                    <span class="details">Full Name</span>
                    <input type="text" name="FullName" id="FullName" placeholder="Full Name ">
                </div>
                <div class="input-box">
                    <span class="details">Address line 1</span>
                    <input type="text" name="Address" id="Address" placeholder="Enter your permanent Address " required>
                    <span class="city">City</span>
                    <input type="text" name="City" id="City"  placeholder="Enter city">
                    
                    <span class="city">District</span>
                    <input type="text" name="District" id="District" placeholder="Enter District">
                   
                    <span class="city">State</span>
                    <input type="text" name="State" id="State" placeholder="Enter State">
                    
                    <span class="city">Country</span>
                    <input type="text" name="Country" id="Country" placeholder="Enter Country">
                </div>
                
                <div class="input-box">
                    <span class="details">Address line 2</span>
                    <input type="text" name="Address2" id="Address2" placeholder="Enter your current Address " required>
                 </div>
                <hr>
                <h4>Types of user</h4>
        <div class="user-details"></div>
            <div class="input-box">
                <span class="details">User Id</span>
                <input type="text" name="user" id="user" placeholder="Enter your User Id" required>
            </div>
           
            <div class="input-box">
                <span class="details">Password</span>
                <input type="password" name="Password" id="Password" placeholder="Enter your Password" required>
            </div>
            <div class="Student"> 
                <label for="dot">
                    <input type="radio" name="dot">
                <span class="same as home">Student</span>
                </label>
            </div>
            <br>
            <div class="Teacher"> 
                <label for="dot">
                    <input type="radio" name="dot">
                <span class="same as home">Teacher</span>
                </label>
            </div>
            <br>
              <div class="button">
                <input type="submit" value="Register" onclick="function1()" class="btn" >
              </div>
           </div> 
           
    
          </form>
        </div>
    
</body>
<script type="text/javascript">
    function function1(){
      alert("You have registered Successfully");
    }
</script>
</html>