<?php 

    header("Content-type:application/x-javascript");

    mb_internal_encoding("utf8");
    $pdo = new PDO("mysql:host=localhost;dbname=keijiban;","root","mysql");
    $stmt=$pdo->query('select max(id)+1 as id from keijiban;');
    if($result=$stmt->fetch(PDO::FETCH_ASSOC)){
        $id = $result['id'];
    }
     echo $id;   
?>
