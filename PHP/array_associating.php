<?php
    $country = array(
        "アジア"=>"日本",
        "アメリカ"=>"アメリカ",
        "欧州"=>"フランス"
    );

    echo $country["欧州"];
?>

<?php
    $name = array(
        "第一走者"=>"田中",
        "第二走者"=>"山田",
        "第三走者"=>"高橋"
    );

    echo $name["第一走者"];
?>

<?php
    $score=array(
        "数学"=>92,
        "国語"=>70,
        "英語"=>86
    );

    echo $score["国語"];
?>

<?php
    $country = array(
        array("日本","タイ"),
        array("アメリカ","ブラジル"),
        array("フランス","ロシア")
    );

    echo $country[0][0];
?>

<?php
    $country = array(
        array("東京","神奈川"),
        array("大阪","兵庫"),
        array("福岡","鹿児島")
    );

    echo $country[1][0];
?>

<?php
    $japan = array(
        array("東京","神奈川"),
        array("大阪","兵庫"),
        array("福岡","鹿児島")
    );

    echo $japan[1][0];
    echo "<br>";
    echo $japan[2][1];
?>

<?php
    $abc = array(
        array(18,"加藤","東京"),
        array(32,"清水","愛知"),
        array(21,"田中","沖縄")
    );

    echo $abc[2][1];
    echo "<br>";
    echo $abc[1][1];
?>

<?php
    $abc = array(
        array(18,"加藤","東京"),
        array(32,"清水","愛知"),
        array(21,"田中","沖縄")
    );

    echo $abc[2][1];
    echo "<br>";
    echo $abc[1][1];
?>

<?php
    $asia = array("日本","タイ");
    $america = array("アメリカ","ブラジル");

    $country = array($asia,$america);

    echo $country[0][0];
?>

<?php
    $class1 = array("Misa","Takeru");
    $class2 = array("Takeshi","Ryo");

    $school = array($class1,$class2);

    echo $school[1][0];
?>

<?php
    $group1 = array("赤","青","黄");
    $group2 = array("白","黒");
    $group3 = array("紫","緑");

    $color = array($group1,$group2,$group3);

    echo $color[0][2];
    echo "<br>";
    echo $color[2][1];
?>

<?php
    $country = array(
        "アジア"=>array("東アジア"=>"日本","東南アジア"=>"タイ"),
        "アメリカ"=>array("北米"=>"アメリカ","南米"=>"ブラジル"),
        "欧州"=>array("西欧"=>"フランス","東欧"=>"ロシア")
    );

    echo $country["アジア"]["東南アジア"];
?>

<?php
    $color = array(
        "No1"=>array("赤"=>"red","青"=>"blue"),
        "No2"=>array("黄"=>"yellow","黒"=>"black"),
        "No3"=>array("白"=>"white","緑"=>"green")
    );

    echo $color["No3"]["白"];
?>