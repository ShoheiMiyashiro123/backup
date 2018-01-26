<?php
    for($a=1;$a<=10;$a++){
        if($a%2==0){
            echo $a."<br>";
        }
    }
?>

<?php
    for($b=22;$b>=0;$b--){
        if($b%2==0){
            echo $b."<br>";
        }
    }
?>

<?php
    for($c=1;$c<=30;$c++){
        if($c%2==0&&$c%3==0){
            echo $c."<br>";
        }
    }
?>

<?php
    for($d=1;$d<=10;$d++){
        if($d%2==0||$d==5){
            echo $d."<br>";
        }
    }
?>

<?php
    for($i=1;$i<=9;$i++){
        for($a=1;$a<=9;$a++){
            echo $i*$a;
        }
        echo "→".$i."の段<br>";
    }
?>

<?php
    for($x=1;$x<=5;$x++){
        for($z=1;$z<=5;$z++){
            echo "★";
        }
        echo "<br>";
    }
?>

<?php
    echo "<select name='month'>";
    echo "<option value'未選択'>月</option>";

    for($i=1;$i<=12;$i++){
        echo "<option value='{$i}'>{$i}</option>";
    }

    echo "</select>";
?>

<?php
    echo '<select name="day">';
    echo "<option value='未選択'>日付</option>";
    for($a=1;$a<=31;$a++){
        echo "<option value='{$a}'>{$a}</option>";
    }

    echo '</select>';
?>