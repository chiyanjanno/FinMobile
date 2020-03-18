<?php


define('hostname', 'localhost');
define('user', 'root');
define('password', '');
define('databaseName', 'users');



$con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');


$stmt = $con->prepare("SELECT Full_name FROM users_table;");

$stmt->execute(); 
$stmt->bind_result($Full_name);

$member = array();

while ($stmt->fetch()){
   $temp = array();
   $temp['Full_name']= $Full_name;

   array_push($member, $temp); 
}

echo json_encode($member);

/*
    define('hostname', 'localhost');
    define('user', 'root');
    define('password', '');
    define('databaseName', 'users');

    if($_SERVER['REQUEST_METHOD']=='POST'){

   $con = mysqli_connect(hostname, user, password, databaseName) or die('Unable to connect to database.');
   
   $Full_name = $_POST["Full_name"];

   if(mysqli_connect_error($con)){
	   echo "Failed to connect to database".mysqli_connect_error();
   }
   
   else
   
   
   $mysql_query = "SELECT * Full_name FROM users_table";

   $result = mysqli_query($con, $mysql_query);
   
   
   
   if(mysqli_num_rows($result)>0){
	   if($result) {
			$member = array();
			while($row =mysqli_fetch_assoc($result)){
				$member[] = $row;
			}
			echo(json_encode($member));      
		}
   }
   else{
	   echo "Sorry, can't connect to the server right now";
   }

   mysqli_close($con);*/