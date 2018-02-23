<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp" />
	<title>MYPAGE画面</title>
</head>
<body>
	<s:include value="header.jsp" />
	<s:if test="myPageDTOs == null">
		<h3>ご購入情報はありません。</h3>
	</s:if>
	<s:elseif test="message == null">
		<h3>ご購入情報は以下になります。</h3>
		<table border="1">
			<tr>
				<th>商品名</th>
				<th>値段</th>
				<th>購入個数</th>
				<th>支払方法</th>
			</tr>
			<s:iterator value="myPageDTOs" status="st">
				<tr style="background-color:aqua;">
					<td colspan="4"><span>購入Id：</span><s:property value="%{myPageDTOs[#st.index][0].buyId}" /><span>,&nbsp;</span>
					<span>購入日時：</span><s:property value="%{myPageDTOs[#st.index][0].insertDate}" />
					</td>
				</tr>
				<s:iterator value="%{myPageDTOs[#st.index]}">
					<tr>
						<td>
							<s:property value="itemName" />
						</td>
						<td>
							<s:property value="totalPrice" />
						</td>
						<td>
							<s:property value="totalCount" />
						</td>
						<td>
							<s:property value="payment" />
						</td>
					</tr>
				</s:iterator>
			</s:iterator>
		</table>
		<s:form action="MyPageAction">
			<input type="hidden" name="deleteFlg" value="1">
			<s:submit value="削除" method="delete" />
		</s:form>
	</s:elseif>
	<s:if test="message != null">
		<h3><s:property value="message" /></h3>
	</s:if>
	<div id="text-right">
		<p>Homeへ戻る場合は
			<a href='<s:url action="GoHomeAction" />'>こちら</a>
		</p>
		<p>ログアウトする場合は
			<a href='<s:url action="HomeAction" />'>こちら</a>
		</p>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>