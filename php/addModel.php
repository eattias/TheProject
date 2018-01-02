<?php
 try {  
 require 'DB_Manage.php';  
   
 $modelCode = $_REQUEST["modelCode"]; 
 $companyName = $_REQUEST["companyName"]; 
 $modelName = $_REQUEST["modelName"]; 
 $engineCapacity = $_REQUEST["engineCapacity"];  
 $seatsNum = $_REQUEST["seatsNum"]; 
 $gearBox = $_REQUEST["gearBox"];  
 
 $sql = "INSERT INTO `client_table`(`modelCode`, `companyName`,`modelName`, `engineCapacity`,`seatsNum`, `gearBox`)
 VALUES ('$modelCode', '$companyName', '$modelName', '$engineCapacity','$seatsNum', '$gearBox')";   
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