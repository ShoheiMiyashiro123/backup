<!DOCTYPE html>
<html lang=ja>
<head>
    <meta charset="UTF-8" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <title>フォーム</title>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <link rel="stylesheet" type="text/css" href="style3.css"/>
</head>
<body>
    <div id="header">
        <h2>Mail Form Practice</h2>
    </div>
    <div id="main">
    <form method="post" action="next.php">
        <input type="text" placeholder="名前を入力してください" name="name" />
        <input type="submit" value="登録する" />
    </form>
    </div>
    <div id="footer">
        <span>Copyright(c) Mail Form Practice 2016 all right reserved</span>
    </div>
</body>
</html>