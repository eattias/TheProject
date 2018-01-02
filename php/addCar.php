<?php
 try {  
 require 'DB_Manage.php';  
   
 $associetedBranch = $_REQUEST["associetedBranch"]; 
 $modelCode = $_REQUEST["modelCode"]; 
 $kilometers = $_REQUEST["kilometers"]; 
 $carNumber = $_REQUEST["carNumber"];  
 
 $sql = "INSERT INTO `client_table`(`associetedBranch`, `modelCode`,`kilometers`, `carNumber`)
 VALUES ('$associetedBranch', '$modelCode', '$kilometers', '$carNumber')";   
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