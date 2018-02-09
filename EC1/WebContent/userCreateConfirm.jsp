<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<!-- 変えちゃった！ -->
<meta http-equiv="imagetoolbar" content="yes" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>UserCreateConfirm画面</title>
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
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>
		<div>
			<p>以下の情報で登録します。よろしいですか？</p>
			<table>
			<s:form action="UserCreateCompleteAction">
				<tr>
					<td>ログインID</td>
					<td><s:property value="loginUserId" /></td>
				</tr>
				<tr>
					<td>名前</td>
					<td><s:property value="userName" /></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><s:property value="loginPassword" /></td>
				</tr>
				<tr>
					<td><s:submit value="登録" /></td>
				</tr>
			</s:form>
			</table>
		</div>
		<div>
			<span>前画面に戻る場合は</span><a href='<s:url action="UserCreateAction" />'>こちら</a>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>