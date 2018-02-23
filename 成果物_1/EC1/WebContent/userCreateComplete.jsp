<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp" />
	<title>USERCREATECOMPLETE画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserCreateComplete</p>
		</div>
		<div>
			<p>登録が完了しました。</p>
		</div>
		<div>
			<span>ログイン画面に戻る場合は</span><a href='<s:url action="HomeAction" />'>こちら</a>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>