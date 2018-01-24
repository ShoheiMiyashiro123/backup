<?php
    $a1 = 3;

    switch($a1){
        case 2:
            echo "a1は2に等しい";
            break;
        
        case 3:
            echo "a1は3に等しい";
            break;
    }
?>

<?php
    $a2 = 5;

    switch($a2){
        case 0:
            echo "a2は0に等しい";
            break;
        
        case 1:
            echo "a2は1に等しい";
            break;
            
        default:
            echo "a2は0でも1でもない";
    }
?>

<?php
   $a3 = "青";

    switch($a3){
        case "赤":
            echo "赤組";
            break;
            
        case "青":
            echo "青組";
            
        default:
            echo "白組";
    }
?>

<?php
    $a4 = "東京";

    switch($a4){
        case "千葉":
            echo "千葉県です";
            break;
            
        case "東京":
            echo "東京です";
            break;
            
        default:
            echo "その他関東地方です";
    }
?>

<?php
     $a5 = "父";

    switch($a5){
        case "母":
            echo "両親です";
            break;
            
        case "父":
            echo "両親です";
            break;
    }
?>

