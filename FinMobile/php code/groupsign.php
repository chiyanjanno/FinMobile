<?php

define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('databaseName', 'users');

$con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');


if($_SERVER['REQUEST_METHOD']=='POST'){

    

    
    $group_type=$_POST['group_type'];
    $group_name=$_POST['group_name'];
    $cycle_start_date=$_POST['cycle_start_date'];
    $cycle_end_date =$_POST['cycle_end_date'];
    $number_of_members=$_POST['number_of_members'];
   
        
  /*  $sq="SELECT * FROM `users_table` WHERE email='".$email."'";
    $rj=mysqli_query($con,$sq);
    $row = mysqli_fetch_assoc($rj);
        if($row){
    echo("exit");
    }*/
   // $mysql_query = "SELECT email FROM users_table WHERE email = '".$email."'"; 

    $mysql_query = "SELECT group_name FROM group_table WHERE group_name = '".$group_name."'";

    $result = mysqli_query($con, $mysql_query);

    if(mysqli_num_rows($result)>0){
        echo "The given group name is already registered ";
    }
    else{
    $mysql_query2 = "INSERT INTO group_table (group_type, group_name,cycle_start_date,cycle_end_date
    ,number_of_members) VALUES('".$group_type."','".$group_name."','".$cycle_start_date."','".$cycle_end_date."','".$number_of_members."')";

        if(mysqli_query($con, $mysql_query2)){
            echo "Group Added Successfully.";
        }
        else{
            echo "Error! Registration Failed.";
        }
    mysqli_close($con);
    }   
}