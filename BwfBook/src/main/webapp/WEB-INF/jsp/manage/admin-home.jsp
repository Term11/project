<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书网后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="/BwfBook/css/mgr.css"/>
  </head>
  <body>
    <div id="container">
    	<div id="header"><h1>博为峰教育--图书网后台管理系统</h1></div>
    	<%@ include file="inc/menu.jsp" %>
    	<div id="main">			
			<div class="section-left">
				<h3>管理员个人信息详情</h3>
				<ul style="margin-left: 50px;">
					<li>ID：${currAdmin.id }</li>
					<li>账号：${currAdmin.loginId }</li>
					<li>姓名：${currAdmin.name }</li>
				</ul>
			</div>			
			<div class="section-right">
				<a href="/BwfBook/manage/downloadTXL">下载员工通讯录</a>
			</div>						
			<div class="cf"></div>
		</div>  	
		<div id="footer"><p>版权所有&copy;博为峰教育</p></div>
	</div>
  </body>
</html>