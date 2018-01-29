<?php
    mb_internal_encoding("utf8");

    $pdo = new PDO("mysql:dbname=form;host=localhost;","root","");
    $pdo->exec('insert into form(name) values("'.$_POST["name"].'");');
    /*sql文に文字列を記述する場合は文字列型の値が格納された変数を結合することによる場合も該当部の前後に”又は’を付ける必要がある。*/
?>

<!DOCTYPE html>
<html lang=ja>
<head>
    <meta charset="UTF-8" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <title>完了画面</title>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <link rel="stylesheet" type="text/css" href="style3.css"/>
</head>
<body>
    <div id="header">
        <h2>Mail Form Practice</h2>
    </div>
    <div id="main">
        <p>登録が完了しました。</p>
        <div>
            <a href="form.php">こちら</a>よりお戻りください。
        </div>
    </div>
    <div id="footer">
        <span>Copyright(c) Mail Form Practice 2016 all right reserved</span>
    </div>
</body>
</html>