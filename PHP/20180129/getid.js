function submitAction(url){
    mb_internal_encoding("utf8");
    $pdo = new PDO("mysql:host=localhost;dbname=keijiban;","root","");
    <?php $stmt=$pdo->query('select max(id)+1 as id from keijiban;');
    if($result=$stmt->fetch(PDO::FETCH_ASSOC)){
        $id = $result['id'];
    }?>
            
    $("#onclick").append(
        "<input type='hidden' name='id' value='"+<?php echo $id ?>+"'>"
    );
            
    $("form").submit();
    $("form").attr("action",url);
}