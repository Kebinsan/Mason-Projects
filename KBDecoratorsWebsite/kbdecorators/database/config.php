<?php

//creates variables with database login info
$servername="kbdecorators.cvols2uxqnri.us-east-2.rds.amazonaws.com";
$username="admin";
$password="yucwpxzs2rcpspb3";
$port="3306";
$dbname="kbdecorators";

//creates connection
$conn=mysqli_connect($servername, $username, $password, $dbname, $port);

//checks connection
if (!$conn) {
 die("Connection failed: " . mysqli_connect_error());
}

?>