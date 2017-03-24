<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录</title>
    <link type="text/css" rel="stylesheet" href="/BwfBook/css/mgr.css"/>
  </head>  
  <body>
    <div id="container">    	
    	<div id="header"><h1>图书网后台管理</h1></div>
    	<div id="main">
    		<h2>管理员登录</h2>
			<form action="/BwfBook/manage/adminLogin" method="post">
				<p>账号：<input name="loginId" type="text" />&nbsp;<label class="fail"><s:property value="[1].fieldErrors.loginId[0]" /></label></p>
				<p>密码：<input name="loginPsw" type="password" />&nbsp;<label class="fail"><s:property value="[1].fieldErrors.loginPsw[0]" /></label></p>				
				<p><input type="submit" value="登录" />&nbsp;<label class="fail">${ msg }</label></p>
			</form>
    	</div>  	
		<div id="footer"><p>版权所有&copy;博为峰教育</p></div>
	</div>
  </body>
</html>