<?php
    $num[0]="A";
    $num[1]="B";
    $num[2]="C";

    echo $num[0];
?>

<?php
    $num = array("A"."B","C");

    echo $num[0];
?>

<?php
    $name[0]="山田";
    $name[1]="河野";
    $name[2]="高木";

    echo $name[2];
?>

<?php
    $name = array("山田","河野","高木");
    echo $name[2];
?>

<?php
    $abc=array(3,9,21);
    echo $abc[1];
?>

<?php
    $person = array("山田",25,"東京");
    echo $person[1];
?>

<?php
    $name1 = array("高木","青木","田口");
    $name1[] = "山口";
    echo $name1[3];
?>

<?php
    $name2 = array("高橋","青木","田口");

    $name2[0]="田村";

    echo $name2[1];
    echo $name2[0];
?>

<?php
    $star = array("☆","○","◎");
    unset($star[1]);
    echo $star[2];
?>

<?php
    $star = array("☆","○","★");

    unset($star[1]);

    $star[1] = "★";

    echo $star[1];
?>