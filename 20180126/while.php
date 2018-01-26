<?php
    $a = 1;
    while($a <= 50){
        echo $a."-";
        $a++;
    }
?>

<?php
    $day=1;
    while($day<=31){
        echo $day."/";
        $day++;
    }
?>

<?php
    $b=20;
    while($b>=10){
        echo $b."<br>";
        $b--;
    }
?>

<?php
    $c = 0;
while($c <= 10){
    if($c%2==0){
        echo $c."<br>";
    }
    $c++;
}
?>

<?php
    $d=0;
    while($d<=25){
        if($d%2==0&&$d%5==0){
            echo $d."<br>";
        }
        $d++;
    }
?>

<?php
    $e = 1;
    while($e<=10){
        if($e%2==1){
            echo "★"."<br>";
        }
        $e++;
    }
?>

<?php
    $f = 0;
    while($f <= 5){
        for($g = 0;$g < 5;$g++){
            echo "★";
        }
        echo "<br>";
        $f++;
    }
?>