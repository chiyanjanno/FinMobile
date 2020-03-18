<?php

define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('databaseName', 'users');

$con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');


if($_SERVER['REQUEST_METHOD']=='POST'){

    
    $users_tableid=$_POST['users_tableid'];
    $Amount=$_POST['Amount'];
    $Loan_period=$_POST['Loan_period'];
    $email =$_POST['email'];
        
  /*  $sq="SELECT * FROM `users_table` WHERE email='".$email."'";
    $rj=mysqli_query($con,$sq);
    $row = mysqli_fetch_assoc($rj);
        if($row){
    echo("exit");
    }*/
    
    $result = mysqli_query($con, $mysql_query2);
  
    
    if(mysqli_num_rows($result)>0){
       echo "The given Email Address is already registered to another user";
    }
       else{
        $mysql_query2= "INSERT INTO  loan_request  (Loan_period,Amount,users_tableid)
        VALUES ('".$Loan_period."','".$Amount."',
               (SELECT users_tableid FROM users_table WHERE email ='chia@gmail.com')";
        
        
           
        
            
        if(mysqli_query($con, $mysql_query2)){
            echo "Loan application sent";
        }
        else{
            echo "Error! application Failed. Try again later";
        }
 
    }
}
 

    

        

          
    
?>