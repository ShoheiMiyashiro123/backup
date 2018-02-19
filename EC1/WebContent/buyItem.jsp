<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>BuyItem画面</title>
<style type="text/css">
	/*=====TAG LAYOUT======*/
	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana, Helvetica, sans-serif;
		font-size:12px;
		color:#333;
		background:#fff;
	}

	table{
		text-align:center;
		margin:0 auto;
	}

	/*======ID LAYOUT=========*/
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

	#main{
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
</head>
<body>
	<div id="header">
		<div id="pr">
			<ul>
				<li class="bar"><a href='<s:url action="MyPageAction" />'>マイページ</a></li>
				<li class="bar"><a href='<s:url action="CartAction" />'>カートの中身を見る</a></li>
				<li class="bar"><a href='<s:url action="SearchAction" />'>商品一覧</a></li>
				<li class="bar"><a href='<s:url action="HomeAction" />'>ログアウト</a></li>
			</ul>

		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<s:if test="errorMessage!=null">
			<h3><s:property value="errorMessage"/></h3>
		</s:if>
		<div id="buyItem">
		<s:form action="BuyItemConfirmAction" theme="simple">
			<s:iterator value="session.cart" status="st">

			<div class="content">
				<div><input type="hidden" name="itemId" value='<s:property value="itemId"/>'></div>
				<table>
					<tr>
						<td>
							<span>商品名</span>
						</td>
						<td>
							<s:property value="itemName" />
						</td>
					</tr>
					<tr>
						<td>
							<span>値段</span>
						</td>
						<td>
							<s:property value="itemPrice" />
						</td>
					</tr>

					<!-- 在庫ではなく数量ではないか？？？ -->
					<tr>
						<td>
							<span>在庫</span>
						</td>
						<td>
							<s:select name='buyInfo[%{#st.index}].totalCount'
							list='%{session.stock[#st.index]}' value='1'/>
						</td>
					</tr>
					<tr>
						<td>
							<span>支払い方法</span>
						</td>
						<td>
							<s:radio list='#{"現金払い":"現金払い","クレジットカード":"クレジットカード"}'
							name='buyInfo[%{#st.index}].payment' class="empty"/>
						</td>
					</tr>
				</table>
			</div>
			</s:iterator>
			<div id="buy"><s:submit value="確認" /></div>
		</s:form>
		</div>

	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
	<script type="text/javascript">
		$(".empty[value='現金払い']").prop("checked",true);
	</script>
</body>
</html>