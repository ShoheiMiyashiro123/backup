<?php
    $a1 = 40;
    if($a1 > 10){
        if($a1 < 50){
            echo "A";
        }
    }
?>

<?php
    $a2 = 4;
    if($a2<=10){
        if($a2>=3){
            echo "B";
        }
    }
?>

<?php
    $a3 = 18;
    if($a3<=20&&$a3>=10){
        if($a3==18){
            echo "C";
        }
    }
?>

<?php
    $age1 = 16;
    if($age1<20){
        echo "未成年";
    }else{
        echo "成人";
    }
?>

<?php
    $age2 = 36;
    if($age2<20){
        echo "未成年";
    }elseif($age2 > 80){
        "高齢者";
    }else{
        echo "成人";
    }
?>

<?php
    $math1 = 9;
    if($math1%2==0){
        echo "偶数";
    }else{
        echo "奇数";
    }
?>

<?php
    $math2 = 15;
    
    if($math2%3==0){
        echo "3の倍数";
    }else{
        echo "その他";
    }
?>

<?php
    $math3 = 5;
    if($math3>1){
        if($math3==2){
            echo "A";
        }elseif($math3==3){
            echo "B";
        }else{
            echo "C";        
        }
    }
?>

<?php
    $test1=95;
    $test2=78;

    if($test1>=70){
        if($test2>=70){
            echo "合格";
        }else{
            echo "不合格";
        }
    }
?>

<?php
    $age =12;
    $tall = 141;
    if($age>=10){
        if($tall>=130){
            echo "乗車可能";
        }else{
            echo "乗車不可能";
        }
    }
?>

<?php
    $age =22;
    $seibetsu = "男";
    $test = 99;
    if($age>=18 && $seibetsu="男"){
        if($test >= 90){
            echo "Aクラス";
        }else if($test<90){
            echo "Bクラス";
        }else{
            echo "Cクラス";
        }
    }
?>