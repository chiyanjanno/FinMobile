<?php


define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('databaseName', 'users');



$con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');


$stmt = $con->prepare("SELECT welfare_contribution, welfare_month, welfare_mode, welfare_date  FROM welfare");

$stmt->execute(); 
$stmt->bind_result($welfare_contribution,$welfare_month, $welfare_mode, $welfare_date);

$member = array();

while ($stmt->fetch()){
   $temp = array();
   $temp['welfare_contribution']= $welfare_contribution;
   $temp['welfare_month']= $welfare_month;
   $temp['welfare_mode']= $welfare_mode;
   $temp['welfare_date']= $welfare_date;
 
   array_push($member, $temp); 
}

echo json_encode($member);

