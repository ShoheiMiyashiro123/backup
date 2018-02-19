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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Search画面</title>
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
		clear:right;
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

	img{
		width:60px;
		height:60px;
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
		<p>商品一覧</p>
	</div>
	<div>
		<s:form method="post" action="SearchAction" theme="simple">
			以下に検索ワードを入力してください。
			<div><s:textfield name="keyword" size="24"/></div>
			<div><s:submit value="検索"/></div>
		</s:form>
		<s:if test="errorMessage!=null">
			<h3><s:property value="errorMessage"/></h3>
		</s:if>
		<div id="main">
			<s:form method="post" action="CartAction" theme="simple">
			<table>
				<tr>
					<th></th>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫</th>
				</tr>
				<s:iterator value="searchDTOs">

				<tr class="click">
					<td>
						<img src='<s:property value="itemImage" />'>
					</td>
					<td class="itemId">
						<s:property value="itemId" />
					</td>
					<td>
						<s:property value="itemName" />
					</td>
					<td>
						<s:property value="itemPrice" />
					</td>
					<td>
						<s:property value="itemStock" />
					</td>
				</tr>
				</s:iterator>
			</table>

			</s:form>
		</div>
	</div>
</div>
<div id="footer">
	<div id="pr">
	</div>
</div>
<script type="text/javascript">

//クリックされた行の商品の商品IdをCartActionに渡す。
$(function(){
		$(".click").on("click",function(){
			var value = parseInt($(this).children(".itemId").text(),10);
			$(this).append('<td><input type="hidden" name="itemId" value="'+value+'"></td>');
			$(this).parents("form").submit();
		}
	)
});
</script>
</body>
</html>