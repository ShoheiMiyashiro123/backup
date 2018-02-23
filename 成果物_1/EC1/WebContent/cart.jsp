<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp" />
	<title>CART画面</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="main">
		<div id="top">
			<p>カートの中身</p>
		</div>
		<s:form action="CartAction" method="post" theme="simple">
		<table id="cart">
			<tr>
				<th></th>
				<th>商品ID</th>
				<th>商品名</th>
				<th>価格</th>
				<th>在庫</th>
			</tr>
			<s:iterator value="session.cart" status="st">
			<!-- ここに最新のレコードに"カートに加わりました"マークを付ける -->
			<s:if test="%{#st.index==0}"><h2><s:property value="addMessage" /></h2></s:if>
			<tr>
				<td>
					<img src='<s:property value="itemImage" />' style="display:flex;
					align-items:center;width:60px;height:60px;">
				</td>
				<td class="itemId">
					<s:property value="itemId" />
				</td>
				<td>
					<s:property value="itemName" />
				</td>
				<td>
					<s:property value="itemPrice" />
				</td>
				<td>
					<s:property value="itemStock" />
				</td>
				<td>
					<button class="remove" type="submit">削除</button>
				</td>
			</tr>
			</s:iterator>
		</table>
		<div id="delete">
			<input type="hidden" name="deleteFlg" value="1">
		</div>
		</s:form>
		<div style="font-size:24px;">
			<span>購入ページへ進む場合は</span>
			<a href='<s:url action="BuyItemAction"/>'>こちら</a>
		</div>
		<div>
			<span>商品一覧に戻る場合は</span>
			<a href='<s:url action="SearchAction"/>'>こちら</a>
		</div>
	</div>
	<s:include value="footer.jsp" />
<script type="text/javascript">
$(function(){
		$(".remove").on("click",function(){
			var tr = $(this).parents("tr");
			var value = parseInt(tr.children(".itemId").text(),10);
			tr.append('<td><input type="hidden" name="itemId" value="'+value+'"></td>');
			$(this).parents("form").submit();
		});
});
</script>
</body>
</html>