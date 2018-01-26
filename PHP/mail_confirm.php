<?php
    $name=$_POST["name"];
    $mail=$_POST["mail"];
    $age=$_POST["age"];
    $comments=$_POST["comments"];
?>
<!DOCTYPE html>
<html lang=ja>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <title>お問い合わせ内容確認</title>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <!--<style type="text/css">
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
        }-->
    <link rel="stylesheet" type="text/css" href="style2.css">
    </style>
</head>
<body>
    <div class="form-style">
    <fieldset>
    <h1>お問い合わせ内容確認</h1>
    
        <p>お問い合わせ内容はこちらでよろしいでしょうか？
        <br>よろしければ「登録する」ボタンを押してください。</p>
        <div class="items">
            <p class="item">
                <div class="term">名前</div>
                <?php echo $name;?>
            </p>
            <p class="item">
                <div class="term">メールアドレス</div>
                <?php echo $mail;?>
            </p>
            <p class="item">
                <div class="term">年齢</div>
                <?php echo $age;?>
            </p>
            <p class="item">
                <div class="term">コメント</div>
                <?php echo $comments;?>
            </p>
    </div>
    <form method="post" id="insert">
        <p class="item">
            <input type='hidden' name='name' value='<?php echo $name;?>'>
            <input type='hidden' name='mail' value='<?php echo $mail;?>'>
            <input type='hidden' name='age' value='<?php echo $age;?>'>
            <input type='hidden' name='comments' value='<?php echo $comments;?>'>
        </p>
        <button type="submit" class="submit" onClick="insertAction('insert.php')">登録する</button>
    <!--phpとjavascriptを連携させられないのか？-->
    </form>
    <form method="post" id="return">
        <button type="submit" class="return" onClick="returnAction('index.html')">戻って修正する</button>
        <div class="clear"></div>
    </form>
    </fieldset>
    </div>
    <script type="text/javascript">
        
        function insertAction(url){
            //$("#return").text($("#return").attr("action"));
            //$("#insert").text($("#insert").attr("action"));
            $("#insert").submit();
            $("#insert").attr("action",url);
        }
        
        function returnAction(url){
            $("#return").submit();
            $("#return").attr("action",url);
            //以下の文を入れたままだとaction属性がつけられたあとも
            //ページ遷移がおきずに処理が実行されてしまう。
            //$("#return").text($("#return").attr("action"));
            //$("#insert").text($("#insert").attr("action"));
        }
    </script>
</body>
</html>