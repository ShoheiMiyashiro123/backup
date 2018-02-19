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
</style>
</head>
<body>
<h1>商品一覧</h1>
<s:form method="post" action="SearchAction">
	<div>検索したいキーワードを入力してください。</div>
	<p>
		<input type="search" name="search">
		<s:submit value="検索" />
	</p>
</s:form>
<table>

	<tr>
		<th></th>
		<th>商品ID</th>
		<th>商品名</th>
		<th>価格</th>
		<th>在庫</th>
	</tr>
<s:iterator value="searchDTOs">
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
	</tr>
</s:iterator>
</table>
</body>
</html>