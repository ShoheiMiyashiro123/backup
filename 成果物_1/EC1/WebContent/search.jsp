<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<s:include value="head.jsp" />
	<title>SEARCH画面</title>
</head>
<body>
<s:include value="header.jsp" />
<div id="main">
	<div id="top">
		<p>商品一覧</p>
	</div>
	<div>
		<s:form method="post" action="SearchAction" theme="simple">
			以下に検索ワードを入力してください。
			<div><s:textfield name="keyword" size="24"/></div>
			<div><s:submit value="検索"/></div>
		</s:form>
		<s:if test="errorMessage!=null">
			<h3><s:property value="errorMessage"/></h3>
		</s:if>
		<div id="main">
			<s:form method="post" action="CartAction" theme="simple">
			<table>
				<tr>
					<th></th>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫</th>
				</tr>
				<s:iterator value="session.searchDTOs">

				<tr class="click">
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
				</tr>
				</s:iterator>
			</table>

			</s:form>
		</div>
	</div>
</div>
<s:include value="footer.jsp" />
<script type="text/javascript">

//クリックされた行の商品の商品IdをCartActionに渡す。
$(function(){
		$(".click").on("click",function(){
			var value = parseInt($(this).children(".itemId").text(),10);
			$(this).append('<td><input type="hidden" name="itemId" value="'+value+'"></td>');
			$(this).parents("form").submit();
		}
	);
});
</script>
</body>
</html>