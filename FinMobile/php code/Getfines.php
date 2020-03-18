<?php


define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('databaseName', 'users');



$con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');


$stmt = $con->prepare("SELECT fine_amount, fine_month, fine_date, fine_description,fine_mode FROM fines");

$stmt->execute(); 
$stmt->bind_result($fine_amount,$fine_month,$fine_date,$fine_description, $fine_mode);

$member = array();

while ($stmt->fetch()){
   $temp = array();
   $temp['fine_amount']= $fine_amount;
   $temp['fine_month']= $fine_month;
   $temp['fine_date']= $fine_date;
   $temp['fine_description']= $fine_description;
   $temp['fine_mode']= $fine_mode;
 
   array_push($member, $temp); 
}

echo json_encode($member);

