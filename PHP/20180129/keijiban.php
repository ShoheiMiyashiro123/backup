<?php 
    $Hello = "222ss";
    mb_internal_encoding("utf8");
    $pdo = new PDO("mysql:host=localhost;dbname=keijiban;","root","");
    
        if(!empty($_POST["id"])&&!empty($_POST["name"])){
            
            $Hello="this";
            
            $stmt=$pdo->query('select * from keijiban where id='.$_POST["id"].';');
            
            if($stmt->rowCount()==0){
                $Hello="Hello";
                date_default_timezone_set("Asia/Tokyo");
                $date=date("Y-m-d H:i:s");
                $pdo->exec('insert into keijiban(name,comments,insert_date) values("'.$_POST["name"].'","'.$_POST["comments"].'","'.$date.'");');
            }
        }
    
    $stmt=$pdo->query("select * from keijiban order by insert_date desc;");
?>
<!DOCTYPE html>
<html lang=ja>
<head>
    <meta charset="UTF-8" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <title>フォーム</title>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <link rel="stylesheet" type="text/css" href="style4.css"/>
</head>
<body>
    <div id="header">
        <h2>KEIJIBAN Practice</h2>
    </div>
    <div id="main">
    <?php 
        /*echo $Hello;
        echo $stmt;
        echo gettype($stmt);
        echo get_class($stmt);
        echo $stmt->rowCount();*/?>
    <?php 
        /*echo $_POST["id"];
        echo $_POST["name"];
        echo $_POST["comments"];*/
        ?>
    <!--action属性変え忘れるな！！-->
    <form method="post">
        <p>
        <span class="term">名前</span><br>
        <input type="text" placeholder="名前を入力してください" name="name" />
        </p>
        <p>
        <span class="term">コメント</span><br>
            <textarea name="comments" rows="20" cols="80"></textarea>
        </p>
        <p id=onclick>
            <input type="submit" value="登録する" onClick="submitAction('keijiban.php');"/>
        </p>
    </form>
    <table border="5" cellspacing="1" cellpadding="30">
        <?php 
            while($result=$stmt->fetch(PDO::FETCH_ASSOC)){
                echo "<tr><td>";
                echo "<label>".$result["name"]."</label><br><br>";
                echo "<span>".$result["comments"]."</span>";
                echo "</td></tr>";
            }
        ?>
    </table>
    </div>
    <div id="sub">
        <img src="img/01.jpg"/>
        <img src="img/02.jpg"/>
    </div>
    <div id="footer">
        <span>2016 KEIJIBAN Practice all right reserved</span>
    </div>
    <script type="text/javascript">
        function submitAction(url){
            var id;
            id = $.ajax({
                type:"POST",
                url:"getid.php",
                success:function(id){
                    $("#onclick").append(
                        "<input type='hidden' name='id' value='"+id+"'>"
                    );

                    $("form").submit();
                    $("form").attr("action",url);
                }
            }); 
        }
    </script>
</body>
</html>