<?php
 try {  
 require 'DB_Manage.php';  
// if (isset($_REQUEST["_id"]))  
	 $id = $_REQUEST["_id"]; 
 //else    
	// $id = 'NULL';    
 $familyName = $_REQUEST["familyName"]; 
 $name = $_REQUEST["name"]; 
 $telNum = $_REQUEST["telNum"]; 
 $mail = $_REQUEST["mail"];  
 $accountNum = $_REQUEST["accountNum"];  
 $sql = "INSERT INTO `client_table`(`familyName`, `name`,`_id`, `telNum`,`mail`,`accountNum`)
 VALUES ('$familyName', '$name', '$id', '$telNum',' $mail', ' $accountNum')";   
 if ($conn->query($sql) === TRUE)
	 {  
 $last_id = $conn->insert_id; 
 echo $last_id; 
 } 
 else 
 {  
 echo "Error: " . $sql . "\n" . $conn->error;  
 } 
 } 
 catch(Exception $e)
 {  echo "Exception Error See Log...."; 
 error_log($e->getMessage() , 0); 
 } 
 $conn->close(); 
 ?> 