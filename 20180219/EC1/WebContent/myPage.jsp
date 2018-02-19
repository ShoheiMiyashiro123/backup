<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
 content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type"
 content="text/css" />
<meta http-equiv="Content-Script-Type"
 content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<title>myPage画面</title>
<style type="text/css">
	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana,Helvetica,sans-selif;
		font-size:12px;
		color:#333;
		background:#fff;
	}

	table{
		text-align:center;
		margin:0 auto;
	}


	/*==========TEMPLATE LAYOUT============*/
	#top{
		width:780px;
		margin:30px auto;
		border:1px solid #333;
	}

	#header{
		width:100%;
		height:80px;
		background-color:black;
	}

	#main {
		width:100%;
		height:500px;
		text-align:center;
	}

	#footer{
		width:100%;
		height:80px;
		background-color:black;
		clear:both;
	}
	/*==============TEBLE LAYOUT================*/
	.buy_info{
		background-color:blue;
		color:white;
	}

	.bar{
		float:right;
		list-style:none;
		font-weight:bold;
		line-height:80px;
		margin:5px;
	}

	.bar a{
		text-decoration:none;
	}

	.bar a:link{
		color:yellow;
	}

	.bar a:visited{
		color:#FFF;
	}
</style>
</head>
<body>
	<div id="header">
		<div id="pr">
			<ul>
				<li class="bar"><a href='<s:url action="MyPageAction" />'>マイページ</a></li>
				<li class="bar"><a href='<s:url action="CartAction" />'>カートの中身を見る</a></li>
				<li class="bar"><a href='<s:url action="SearchAction" />'>商品一覧</a></li>
			</ul>

		</div>
	</div>
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
				<tr class="buy_info">
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
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>