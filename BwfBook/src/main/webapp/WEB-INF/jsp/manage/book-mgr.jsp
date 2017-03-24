<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书网后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="/BwfBook/css/mgr.css"/>
    <script type="text/javascript" src="/BwfBook/js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
    	
    	$(function(){
    		getBookList(1);  
    		$("#txtTitle").on("blur", checkBookTitle);
    	})
    	
    	function checkBookTitle() {
    		var title = $.trim(this.value);
    		$.getJSON("/BwfBook/manage/bookTitleCheck", {"title": title}, function(exists){
    			alert(typeof exists + ", " + exists);
    			
    		});
    	}
    	
    	function getBookList(pageNO) {
   			$.getJSON("/BwfBook/manage/bookList", {"pageNO": pageNO}, function(result){    	
   				$("#book-list tr:gt(0)").remove();
       			var books = result["books"];
       			var paging = result["paging"];
       			
       			var trs = "";
       			for(var i = 0; i < books.length; i++) {
       				var b = books[i];
       				trs += "<tr><td>《" + b.title + "》</td>";
       				trs += "<td>" + b.author + "</td>";
       				trs += "<td>" + b.category.name + "</td>";
       				trs += "<td>￥" + b.price + "》</td>";
       				trs += "<td><a href=\"/BwfBook/manage/bookDelete?bid=" + b.id + "\">删除</a>&nbsp;<a href=\"/BwfBook/manage/bookEdit?bid=" + b.id + "\">编辑</a></td></tr>";
       			}        			
       			$("#book-list tr:eq(0)").after(trs);
       			
       			var pagingBar = '<a href="javascript:getBookList(1)">首页</a>&nbsp;';
       			pagingBar += '<a href="javascript:getBookList(' + paging.prev + ')">上一页</a>&nbsp;';
       			pagingBar += '<a href="javascript:getBookList(' + paging.next + ')">下一页</a>&nbsp;';
       			pagingBar += '<a href="javascript:getBookList(' + paging.total + ')">尾页</a>&nbsp;';
       			pagingBar += '&nbsp;' + paging.curr + '页/' + paging.total + '页&nbsp;&nbsp;共计' + paging.count + '条';
       			
       			$("#paging-bar").html(pagingBar);
       			
       		});
    	}
    </script>
  </head>  
  <body>
  
    <div id="container">
    	<s:debug></s:debug>
    	<div id="header"><h1>博为峰教育--图书网后台管理系统</h1></div>
    	<%@ include file="inc/menu.jsp" %>
    	<div id="main">
			<div class="section-left">    
				
				<h2>图书信息列表</h2>		
				<table id="book-list" class="table" cellspacing="0" style="font-size: 12px;">
			    	<tr>
			    		<td class="header" width="100">书名</td>
			    		<td class="header" width="60">作者</td>
			    		<td class="header" width="60">类型</td>
			    		<td class="header" width="60">售价</td>
			    		<td class="header" width="60">操作</td>
			    	</tr>		   
			    </table>
			    <div id="paging-bar" style="line-height: 40px; font-size:12px; font-weight: bold;"></div>
			</div>
			<div class="section-right">
				<h2>添加图书信息</h2>
				<form action="/BwfBook/manage/bookSave" method="post" enctype="multipart/form-data">
					<p>图书书名：<input type="text" name="book.title" id="txtTitle" /></p>
					<p>图书作者：<input type="text" name="book.author"  /></p>
					<p>图书分类：
						<select name="book.category.id">
						<c:forEach items="${ allCategories }" var="c">
							<option value="${c.id }">${c.name }</option>
						</c:forEach>
						</select>
					</p>
					<p>图书售价：<input type="text" name="book.price"  />&nbsp;<span class="fail"><s:property value="fieldErrors['book.price'][0]" /></span></p>
					<p>图书出版社：<input type="text" name="book.publisher"  /></p>   
					<p>图书图片：<input type="file" name="bphoto"  />&nbsp;<span class="fail"><s:property value="fieldErrors['bphoto'][0]" /></span></p>    				 				
					<p><input type="submit" value=" 保 存 "  />&nbsp;${saveTip  }</p>
				</form>
			</div>			
			<div class="cf"></div>
		</div>  	
		<div id="footer"><p>版权所有&copy;博为峰教育</p></div>
	</div>
  </body>
</html>
