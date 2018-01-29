<?php
    $a=array(
        "tottori"=>"shikoku",
        "tokyo"=>"shikoku",
        "zeon"=>"aki"
    );

    krsort($a);
    foreach($a as $key=>$value){
        echo $key.":".$value."<br>";
    }
?>

<?php
    $a = array("東京","千葉","埼玉","神奈川");
    foreach($a as $value){
        echo $value;
    }
?>

<?php
    $b = array(12,13,14,15,16);
    foreach($b as $value){
        echo $value."<br>";
    }
?>

<?php
    $c = array("月","火","水","木","金","土","日");
    foreach($c as $youbi){
        echo $youbi."/";
    }
?>

<?php
    $a=10;
    $b=20;
    $c=35;

    $num=array($a,$b,$c);
    foreach($num as $value){
        echo $value;
    }
?>

<?php
    $e = array("山田","佐藤","鈴木");

    foreach($e as $b=>$c){
        echo $b."=".$c;
        echo "<br>";
    }
?>

<?php
    $name = array("高橋","田中","鈴木");
    foreach($name as $z=>$c){
        echo $z."の番号は".$c;
        echo "<br>";
    }
?>

<?php
    $youbi = array("月曜日","火曜日","水曜日");
    foreach($youbi as $num =>$abc){
        echo $num."日後は".$abc;
        echo "<br>";
    }
?>

<?php
    $name = array("上野様","高橋様","田中様");
    foreach($name as $num =>$xyz){
        echo $xyz."は".$num."番にお願いします。";
        echo "<br>";
    }
?>