<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp"/>
	<title>BUYITEMCOMPLETE画面</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="main">
		<p>購入手続きが完了しました。</p>
		<div>
			<a href='<s:url action="MyPageAction" />'>マイページ</a>
			<span>から購入履歴の確認が可能です。</span>
			<p>
				Home画面へ戻る場合は
				<a href='<s:url action="GoHomeAction" />'>こちら</a>
			</p>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>