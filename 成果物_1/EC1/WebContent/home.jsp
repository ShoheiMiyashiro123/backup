<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp"/>
	<title>HOME画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>

		<div>
			<s:form action="HomeAction">
				<s:submit value="商品購入" />
			</s:form>
		</div>
	</div>
	<s:include value="footer.jsp"/>
</body>
</html>

