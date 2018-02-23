<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<s:include value="head.jsp" />
<title>BUYITEMCONFIRM画面</title>
<script type="text/javascript">
/*$(function() {
	$("button").onclick(function(){
		//$(this).parents("form").attr("action",url);
		//$(this).parents("form").submit();
	});
});*/


	function submitAction(url){
//		$(this).parents("form").attr("action",url);
//		$(this).parents("form").submit();

		$("form").attr("action",url);
		$("form").submit();
	}
</script>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="main">
		<div id="top">
			<p>BuyItemConfirm</p>
		</div>

		<div>
			<h3>
				購入する商品の確認をお願いします。
			</h3>
			<s:form theme="simple">
			<s:iterator value="buyInfo" status="st">
			<table>
				<tr>
					<td><span>商品名</span></td>
					<td>
						<s:property value="itemName" />
					</td>
				</tr>
				<tr>
					<td><span>値段</span></td>
					<td>
						<s:property value="totalPrice" />
					</td>
				</tr>
				<tr>
					<td><span>購入数量</span></td>
					<td>
						<s:property value="totalCount" />
						<span>個</span>
					</td>
				</tr>
				<tr>
					<td><span>支払方法</span></td>
					<td>
						<s:property value="payment" />
					</td>
				</tr>
			</table>
			</s:iterator>
			<div id="buy">
				<button onclick='submitAction("BuyItemAction")' >戻る</button>
				<span>&nbsp;</span>
				<button onclick='submitAction("BuyItemCompleteAction")'>購入</button>
			</div>
			</s:form>
		</div>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>