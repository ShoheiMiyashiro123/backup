<?php
    function totalPrice
        ($fruitprice,$tax=1.08,$haiso=350){
        return ($fruitprice+$haiso)*$tax;
    }

    $mikan = totalPrice(300);
    echo $mikan."<br>";
    $ringo = totalPrice(450);
    echo $ringo."<br>";
?>

<?php
   function score($kokugo,$suugaku,$eigo){
       return($kokugo+$suugaku+$eigo);
   } 

    $test1 = score(88,71,98);
    echo $test1."<br>";
    $test2 = score(100,79,89);
    echo $test2."<br>";
    $test3 = score(55,76,67);
    echo $test3."<br>";
?>

<?php
    function average(
        $person1,$person2,$person3
    ){
        return($person1+$person2+$person3)/3;
    }

    $group1 = average(160,172,180);
    echo $group1."<br>";

    $group2 = average(154,179,166);
    echo $group2."<br>";

    $group3 = average(162,192,180);
    echo $group3."<br>";
?>

<?php
    function nameHello($name){
        return $name."様。はじめまして。";
    }

    echo nameHello("山田");
    echo "<br>";
    echo nameHello("鈴木");
    echo "<br>";
    echo nameHello("佐藤");
?>

<?php
    function nenrei($age){
        return "○○さんは".$age."歳です。";
    }

    echo nenrei(17);
    echo "<br>";
    echo nenrei(25);
    echo "<br>";
    echo nenrei(22);
?>

<?php
    function price($vegetable){
        return $vegetable * 1.08;
    }

    echo price(100);
    echo "<br>";
    echo price(210);
    echo "<br>";
    echo price(150);
?>

<?php
    function cost($go,$back){
        return $go+$back;
    }

    echo cost(150,150);
    echo "<br>";
    echo cost(210,180);
    echo "<br>";
    echo price(300.120);
?>

<?php
    function shikaku($tate,$yoko){
        $abc = $tate*$yoko;
        return $abc;
    }

    echo shikaku(10,50);
    echo "<br>";
    echo shikaku(14,5);
    echo "<br>";
    echo shikaku(75,30);
?>

<?php
    function sendmail($name){
        $xyz = $name."様、お世話になります。";
        return $xyz;
    }

    echo sendmail("田中");
    echo "<br>";
    echo sendmail("高橋");
    echo "<br>";
    echo sendmail("村田");
?>

    