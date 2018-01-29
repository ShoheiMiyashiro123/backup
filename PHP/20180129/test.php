<?php 
    $Hello = "222ss";
    mb_internal_encoding("utf8");
    $pdo = new PDO("mysql:host=localhost;dbname=keijiban;","root","");
    
        if(!empty($_POST["id"])&&!empty($_POST["name"])){
            
            $Hello="this";
            
            $stmt=$pdo->query('select * from keijiban where id='.$_POST["id"].';');
            
            /*if($stmt->rowCount()==0){
                $Hello="Hello";
                date_default_timezone_set("Asia/Tokyo");
                $date=date("Y-m-d H:i:s");
                $pdo->exec('insert into keijiban(name,comments,insert_date) values("'.$_POST["name"].'","'.$_POST["comments"].'","'.$date.'");');
            }*/
        }
    
    /*$stmt=$pdo->query("select * from keijiban order by insert_date desc;");*/
?>
<!DOCTYPE html>
<html lang=ja>
<head>
    <meta charset="UTF-8" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <title>フォーム</title>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <link rel="stylesheet" type="text/css" href="style4.css">
</head>
<body>
    <button type="button" onClick="submitAction();">押す</button>
    <script type="text/javascript">
        function submitAction(){
                $.ajax({
                type:"x",
                url:"getid.php",
                success:function(id){
                    document.write(id);
                }
            });
        }
    </script>
</body>
</html>