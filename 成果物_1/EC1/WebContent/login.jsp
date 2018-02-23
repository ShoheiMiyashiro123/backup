<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp"/>
	<title>LOGIN画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>Login</p>
		</div>

		<div>
			<h3>
				商品を購入する際にはログインをお願いします。
			</h3>
			<s:form action="LoginAction" theme="simple">
				<s:textfield name='loginUserId' />
				<s:password name="loginPassword" />
				<s:submit value="ログイン"/>
			</s:form>
			<br/>
			<div>
				<span>
					新規ユーザ登録は
					<a href='<s:url action="UserCreateAction" />'>こちら</a>
				</span>
			</div>
		</div>
	</div>

	<s:include value="footer.jsp" />
</body>
</html>