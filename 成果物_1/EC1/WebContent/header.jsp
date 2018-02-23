<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="header">
	<div id="pr">
		<s:if test="session.loginUser!=null">
		<h1 id="userInfo"><s:property value="session.loginUser.userName" />さん、ようこそ
			(ユーザID：<s:property value="session.loginUser.loginId" />)</h1>
		</s:if>
		<ul>
			<li class="bar"><a href='<s:url action="MyPageAction" />'>マイページ</a></li>
			<li class="bar"><a href='<s:url action="CartAction" />'>カートの中身を見る</a></li>
			<li class="bar"><a href='<s:url action="SearchAction" />'>商品一覧</a></li>
			<li class="bar"><a href='<s:url action="HomeAction" />'>ログアウト</a></li>
		</ul>
		<div class="clear"></div>
	</div>
</div>