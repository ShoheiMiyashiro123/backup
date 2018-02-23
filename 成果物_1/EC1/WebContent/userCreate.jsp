<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp" />
	<title>USERCREATE画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserCreate</p>
		</div>
		<s:if test="errorMassage!=''">
			<s:property value="errorMassage" escape="false" />
		</s:if>
		<div>
			<p>以下にあなたの情報を登録してください。</p>
			<table>
			<s:form action="UserCreateConfirmAction" theme="simple">
				<tr>
					<td>ログインID</td>
					<td><s:textfield name="loginUserId" /></td>
				</tr>
				<tr>
					<td>名前</td>
					<td><s:textfield name="userName" /></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><s:password name="loginPassword" /></td>
				</tr>
				<tr>
					<td><s:submit value="確認" /></td>
				</tr>
			</s:form>
			</table>
		</div>
		<div>
			<span>前画面に戻る場合は</span><a href='<s:url action="HomeAction" />'>こちら</a>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>