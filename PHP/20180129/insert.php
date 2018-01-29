<?php
    /*$sql = "insert into contactform(name,mail,age,comments) values('".$_POST['name']."','".$_POST['mail']."','".$_POST['age']."','".$_POST['comments']."');";+*/

    $name=echo $_POST["name"];
    $mail=echo $_POST['mail'];
    $age=echo $_POST['age'];
    $comments=echo $_POST['comments'];

    mb_internal_encoding("utf8");
    
    $pdo = new PDO("mysql:dbname=lessonnew;host=localhost;","root","");

    /*$pdo->exec("insert into contactform(name,mail,age,comments) values('".echo $_POST['name']."','".echo $_POST['mail']."','".echo $_POST['age']."','".echo $_POST['comments']."');");*/

    $pdo->exec("insert into contactform(name,mail,age,comments) values('".$name."','".$mail."','".$age."','".$comments."');");
?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <title>お問い合わせ完了</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <meta http-equiv="Content-Stile-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <style type="text/css">
        .term{
           margin-bottom:10px;
        }
        
        .form-style{
            max-width:450px;
            font-family:"游ゴシック", "Lucida Grande",sans-serif;
        }
        
        fieldset{
            border-radius:10px;
            -webkit-border-radius:10px;
            -moz-border-radius-10px;
            margin:0px 0px 10px 0px;
            border:1px solid #FFD2D2;
            padding:20px;
            background:#FFF4F4;
            box-shadow:inset 0px 0px 15px #FFE5E5;
            -moz-box-shadow:inset 0px 0px 15px #FFE5E5;
            -webkit-box-shadow:inset 0px 0px 15px #FFE5E5;
        }
        
        button{
            float:left;
        }
        
        .clear{
            clear:left;
        }
    </style>
</head>
<body>
    <h1>お問い合わせフォーム</h1>
    <div class="confirm">
        <p>お問い合わせ有難うございました。<br>
        3営業日以内に担当者よりご連絡差し上げます。</p>
    </div>
    <a href="index.html">戻る</a>
</body>
</html>