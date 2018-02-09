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
</style>
</head>
<body>
<div id="header">
	<div id="pr">
	</div>
</div>
<div id="main">
	<div id="top">
		<p>商品一覧</p>
	</div>
	<div>
		<s:form method="post" action="SearchAction">
			以下に検索ワードを入力してください。
			<div><s:textfield name="keyword" size="24"/></div>
			<div><s:submit value="検索"/></div>
		</s:form>
		<div id="main">
			<table>
				<tr>
					<th></th>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫</th>
				</tr>
				<s:iterator value="searchDTOs">
				<s:form method="post" action="SearchAction">
				<tr>
					<td>
						<img src='<s:property value="itemImage" />'>
					</td>
					<td>
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
					<td>
						<input type="hidden" name="bought" value='<s:property value="itemId" />'>
					</td>
				</tr>
				</s:form>
				</s:iterator>
			</table>
		</div>
		<!-- <div id="sub">
			<p>カート</p>
			<table>
				<s:iterator value="boughts">
				<tr>
					<td>
						<s:property value="itemId" />
					</td>
					<td>
						<s:property value="itemName" />
					</td>
					<td>
						<s:property value="itemPrice" />
				</tr>
				</s:iterator>
			</table>
		</div> -->
	</div>
</div>
<div id="footer">
	<div id="pr">
	</div>
</div>
<script type="text/javascript">
/*	$(function(){
		$("form").on("click",function(){
			$(this).removeAttr("action");
			$(this).submit();
			$(this).attr("action","SearchAction");
		});
	});*/
</script>
</body>
</html>