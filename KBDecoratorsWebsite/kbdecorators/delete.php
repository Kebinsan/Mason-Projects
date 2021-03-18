<?php	
	$id = $_GET['storeID'];
	
	include("database/config.php");
	
	$sql = "DELETE FROM inventory WHERE storeID = $id";
	
	if(mysqli_query($conn, $sql)) {
		mysqli_close($conn);
		header('Location: testInventory.php'); //should be the webpage with the inventory table
		exit;
	}
	else {
		echo "Error: " . $sql . "<br>" . mysqli_error($conn);
	}
?>