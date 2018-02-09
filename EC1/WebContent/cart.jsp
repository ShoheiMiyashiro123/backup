<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type"
 content="text/css" />
<meta http-equiv="Content-Script-Type"
 content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<title>カート画面</title>
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
	<p>カートの中身</p>
	<table>
		<tr>
			<th></th>
			<th>商品ID</th>
			<th>商品名</th>
			<th>価格</th>
			<th>在庫</th>
		</tr>
		<s:iterator value="cart">
		<!-- ここに最新のレコードに"カートに加わりました"マークを付ける -->
		<s:if test=""></s:if>
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