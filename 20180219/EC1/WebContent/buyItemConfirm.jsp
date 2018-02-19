<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
 content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type"
 content="text/css" />
<meta http-equiv="Content-Script-Type"
 content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<title>BuyItemConfirm画面</title>
<style type="text/css">
	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana,Helvetica,sans-selif;
		font-size:12px;
		color:#333;
		background:#fff;
	}

	table{
		text-align:center;
		margin:0 auto;
	}


	/*==========TEMPLATE LAYOUT============*/
	#top{
		width:780px;
		margin:30px auto;
		border:1px solid #333;
	}

	#header{
		width:100%;
		height:80px;
		background-color:black;
	}

	#main {
		width:100%;
		height:500px;
		text-align:center;
	}

	#footer{
		width:100%;
		height:80px;
		background-color:black;
		clear:both;
	}

	.bar{
		float:right;
		list-style:none;
		font-weight:bold;
		line-height:80px;
		margin:5px;
	}

	.bar a{
		text-decoration:none;
	}

	.bar a:link{
		color:yellow;
	}

	.bar a:visited{
		color:#FFF;
	}
</style>
<script type="text/javascript">
/*$(function() {
	$("button").onclick(function(){
		//$(this).parents("form").attr("action",url);
		//$(this).parents("form").submit();
	});
});*/


	function submitAction(url){
//		$(this).parents("form").attr("action",url);
//		$(this).parents("form").submit();

		$("form").attr("action",url);
		$("form").submit();
	}
</script>
</head>
<body>
	<div id="header">
		<div id="pr">
			<ul>
				<li class="bar"><a href='<s:url action="MyPageAction" />'>マイページ</a></li>
				<li class="bar"><a href='<s:url action="CartAction" />'>カートの中身を見る</a></li>
				<li class="bar"><a href='<s:url action="SearchAction" />'>商品一覧</a></li>
			</ul>

		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItemConfirm</p>
		</div>

		<div>
			<h3>
				購入する商品の確認をお願いします。
			</h3>
			<s:form theme="simple">
			<s:iterator value="buyInfo" status="st">
			<table>
				<tr>
					<td><span>商品名</span></td>
					<td>
						<s:property value="itemName" />
					</td>
				</tr>
				<tr>
					<td><span>値段</span></td>
					<td>
						<s:property value="totalPrice" />
					</td>
				</tr>
				<tr>
					<td><span>購入数量</span></td>
					<td>
						<s:property value="totalCount" />
						<span>個</span>
					</td>
				</tr>
				<tr>
					<td><span>支払方法</span></td>
					<td>
						<s:property value="payment" />
					</td>
				</tr>
			</table>
			</s:iterator>
			<div id="buy">
				<button onclick='submitAction("BuyItemAction")' >戻る</button>
				<span>&nbsp;</span>
				<button onclick='submitAction("BuyItemCompleteAction")'>購入</button>
			</div>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>