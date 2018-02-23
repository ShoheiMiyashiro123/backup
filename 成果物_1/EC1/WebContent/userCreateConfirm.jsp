<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp" />
	<title>USERCREATECONFIRM画面</title>
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
	<s:include value="footer.jsp" />
</body>
</html>