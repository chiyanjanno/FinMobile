<?php
define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('databaseName', 'users');

if($_SERVER['REQUEST_METHOD']=='POST'){

$con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');
  

 $email = $ema = $_POST['email'];
 
 $password = $pass = $_POST['password'];
 
 
 
 $sql = "SELECT * FROM `users_table` WHERE email='".$email."' AND password='".$password."'";
 

 $result = mysqli_query($con,$sql);
 

 $check = mysqli_fetch_array($result);
 

  $sqli = "SELECT  Full_name, phone_number,email, password FROM `users_table` WHERE email ='".$email."' AND password='".$password."'";

   $resulti = mysqli_query($con,$sqli);
   while($row=mysqli_fetch_assoc($resulti)){
     $data=array();
	 $Full_name["success"]=false;
   $data=$Full_name+$row;
         echo json_encode($data);
        
   }
   
}
else{
    echo "Error! Login failed. check email or password";
}
 mysqli_close($con);
    
  