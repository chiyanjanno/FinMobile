<?php

    define('hostname', 'localhost');
    define('user', 'root');
    define('password', '');
    define('databaseName', 'users');

    

   $con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');
  

   $stmt = $con -> prepare("SELECT Full_name FROM users_table;");

   $stmt-> execute(); 
   $stmt-> bind_result($Full_name);

   $member = array();

   while ($stmt->fetch()){
       $temp = array();
       $temp['Full_name']= $Full_name;

       array_push($member, $temp); 
   }

    echo json_encode($member);
?> 