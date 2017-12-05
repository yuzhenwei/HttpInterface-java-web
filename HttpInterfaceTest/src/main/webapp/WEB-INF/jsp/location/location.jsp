<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath %>"> 
	
		<!-- 引入js -->
<!-- 	<script type="text/javascript"  src="js/jquery.min.js"></script>
	<script type="text/javascript"  src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript"  src="js/location/location.js"></script>
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css"/>
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css"/>
	 -->
	<%@ include file="addLocation_page.jsp"%>
	<%@ include file="editlocation_page.jsp"%>

</head>
<body>
	<div class="easyui-panel" style="padding:15px 5px 5px 5px;" >
		<label>环境名称</label>
		<input id="locationName" name="locationName"></input>
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="searchLocation()">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearLocation()">清除</a>
		<br>
		<br>
		<div class="easyui-panel"  title="测试地址列表" >
			<table id="locationTag" class="easyui-datagrid" singleSelect=true toolbar="#locationButton" url="location/searchLocation.action">   
			    <thead>   
			        <tr>   
			        	
			        	<th field="id" checkbox=true/> 
			            <th field="locationName" width=300 align="center">环境名称</th>   
			            <th field="address" width=300 align="center">环境地址</th>  
			        </tr>   
			    </thead>    
			</table>  
		</div>
		<div id="locationButton">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"  onclick="addLocation()">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="updateLocation()">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="delLocation()">删除</a>							
		</div>
	</div>
	
</body>
</html>