<?php
//include 'groupsign.php';

define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('databaseName', 'users');

$con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');



if($_SERVER['REQUEST_METHOD']=='POST'){

    
    $group_name2=$_POST['group_name2'];
    $Full_name=$_POST['Full_name'];
    $phone_number=$_POST['phone_number'];
    $current_home_address=$_POST['current_home_address'];
    $password=$_POST['password'];
    $group_post=$_POST['group_post'];
    $email=$_POST['email'];
        
  /*  $sq="SELECT * FROM `users_table` WHERE email='".$email."'";
    $rj=mysqli_query($con,$sq);
    $row = mysqli_fetch_assoc($rj);
        if($row){
    echo("exit");
    }*/
    $mysql_query = "SELECT email FROM users_table WHERE email = '".$email."'";   
    $result = mysqli_query($con, $mysql_query);
    
    if(mysqli_num_rows($result)>0){
       echo "The given Email Address is already registered to another user";
    }
    else{
    $mysql_query2= "INSERT INTO users_table (Full_name,phone_number,current_home_address,group_post,password, email ,group_tableid) VALUES
        ('".$Full_name."','".$phone_number."','".$current_home_address."','".$group_post."','".$password."','".$email."',(SELECT group_tableid FROM group_table WHERE group_name = '".$group_name2."'))";
    }
            
         if(mysqli_query($con, $mysql_query2)){
            echo "member successfully added";
        }
        else{
            echo "Error! Registration Failed. Try again later";
        }
 
    

    
   /* if(mysqli_query($con,$sql)){
        echo("yes");,
        
        
        }else{
        echo("no");
        }
    }*/
}     

          
    mysqli_close($con);