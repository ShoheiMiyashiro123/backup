<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp" />
	<title>BUYITEM画面</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<s:if test="errorMessage!=null">
			<h3><s:property value="errorMessage"/></h3>
		</s:if>
		<div id="buyItem">
		<s:form action="BuyItemConfirmAction" theme="simple">
			<s:iterator value="session.cart" status="st">

			<div class="content">
				<div><input type="hidden" name="itemId" value='<s:property value="itemId"/>'></div>
				<table>
					<tr>
						<td>
							<span>商品名</span>
						</td>
						<td>
							<s:property value="itemName" />
						</td>
					</tr>
					<tr>
						<td>
							<span>値段</span>
						</td>
						<td>
							<s:property value="itemPrice" />
						</td>
					</tr>

					<!-- 在庫ではなく数量ではないか？？？ -->
					<tr>
						<td>
							<span>在庫</span>
						</td>
						<td>
							<s:select name='buyInfo[%{#st.index}].totalCount'
							list='%{session.stock[#st.index]}' value='1'/>
						</td>
					</tr>
					<tr>
						<td>
							<span>支払い方法</span>
						</td>
						<td>
							<s:radio list='#{"現金払い":"現金払い","クレジットカード":"クレジットカード"}'
							name='buyInfo[%{#st.index}].payment' class="empty"/>
						</td>
					</tr>
				</table>
			</div>
			</s:iterator>
			<div id="buy"><s:submit value="確認" /></div>
		</s:form>
		</div>

	</div>

	<s:include value="footer.jsp" />
	<script type="text/javascript">
		$(".empty[value='現金払い']").prop("checked",true);
	</script>
</body>
</html>