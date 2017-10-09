<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<%@ include file="addHeader_page.jsp" %>
<%@ include file="editHeader_page.jsp" %>
<body>

	<div class="easyui-panel" style="padding:15px 5px 5px 5px;" >
		<label>请求头名称</label>
		<input id="headerName" name="headerName"></input>
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="searchHeader()">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearHeader()">清除</a>
		<br>
		<br>
		<div class="easyui-panel"  title="请求头列表" >
			<table id="headerTag" class="easyui-datagrid" singleSelect=true toolbar="#headerButton" url="header/getHeaders.action">   
			    <thead>   
			        <tr>   
			        	
			        	<th field="id" checkbox=true/> 
			            <th field="headerName" width=300 align="center">请求头名称</th>   
			            <th field="headerContent" width=600 align="left">请求内容</th>   
			        </tr>   
			    </thead>    
			</table>  
		</div>
		<div id="headerButton">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"  onclick="add_Header()">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="updateHeader()">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="delHeader()">删除</a>				
		</div>
	</div>
	
</body>
</html>