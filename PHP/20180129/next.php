<?php $name=$_POST["name"];?>
<!--$_POSTのかっこは()でなく[]である。-->
<!DOCTYPE html>
<html lang=ja>
<head>
    <meta charset="UTF-8"/>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <title>確認画面</title>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <link rel="stylesheet" type="text/css" href="style3.css"/>
</head>
<body>
    <div id="header">
        <h2>Mail Form Practice</h2>
    </div>
    
    <div id="main">
        <p>以下の内容で登録しますか？</p>
        <table>
        <form method="post" action="complete.php">
            <!--formはmethodとactionを必ず指定する。
            また、値渡しで遷移先ページで$_POSTを使う場合
            その送信方式に合わせたmethodにする。-->
            <tr>
                <th>名前</th>
                <td><?php echo $name;?></td>
            </tr>
            <tr>
                <!-- phpタグ内で値を受け渡す場合は変数をそのまま対応付け(代入す)ればよいのに対し、
                phpタグからhtmlへ値を受け渡す場合はechoメソッドにより一度、変数の中の値をhtmlに表示させた後、
                各属性に対応付けることになる。 -->
                <td><input type="hidden" name="name" value="<?php echo $name;?>"></td>
                <!--valueをphpで指定する場合も値の両辺を”又は’で囲むことを忘れずに・・・。-->
                <td><button type="submit">登録</button></td>
            </tr>
        </form>
        </table>
    </div>
    
    <div id="footer">
        <span>Copyright(c) Mail Form Practice 2016 all right reserved</span>
    </div>
</body>
</html>