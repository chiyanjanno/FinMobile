<?php


define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('databaseName', 'users');



$con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');


$stmt = $con->prepare("SELECT Monthly_contribution, Month,date_of_payment  , Paid_through FROM monthly_contributions");

$stmt->execute(); 
$stmt->bind_result($Monthly_contribution,$Month,$date_of_payment, $Paid_through);

$member = array();

while ($stmt->fetch()){
   $temp = array();
   $temp['Monthly_contribution']= $Monthly_contribution;
   $temp['Month']= $Month;
   $temp['date_of_payment']= $date_of_payment;
   $temp['Paid_through']= $Paid_through;
 
   array_push($member, $temp); 
}

echo json_encode($member);

