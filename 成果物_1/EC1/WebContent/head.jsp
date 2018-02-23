<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<meta http-equiv="Content-Type"
 content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type"
 content="text/css" />
<meta http-equiv="Content-Script-Type"
 content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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

	#userInfo{
		float:left;
		color:aqua;
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

	.clear{
		clear:right;
	}

	#cart tr:nth-child(2){
		margin-bottom:10px;
		line-height:100px;
		background-color:aqua;
	}
</style>