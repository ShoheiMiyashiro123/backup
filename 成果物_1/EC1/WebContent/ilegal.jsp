<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp"/>
	<title>ILEGAL画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>Ilegal</p>
		</div>

		<div>
			<p>不正なページの遷移が行われました。
			<a href=<s:url value="HomeAction" />>こちら</a>よりもう一度ログインしてください。</p>
		</div>
	</div>
	<s:include value="footer.jsp"/>
</body>
</html>