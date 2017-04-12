<?php

$name = "charan";

$connection = mysqli_connect('localhost' , 'root' , '');

mysqli_select_db($connection , 'library');

 $result  = mysqli_query($connection , "select * from user where name = '$name' ");
 
 while($r = mysqli_fetch_assoc($result))
 $row[] = $r;

$response['result']= $row;
 
 echo json_encode($response);


?>