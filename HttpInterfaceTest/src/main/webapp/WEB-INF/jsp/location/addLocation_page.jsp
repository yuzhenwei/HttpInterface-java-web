<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div id="addLocation_page" class="easyui-dialog" modal=true closed="true" buttons="#add_locationButton" style="width:400px;height:400px">
		
		<form id="addlocationForm" style="padding:30px;">
		   	<label>环境名称</label>
		   	<input id="locationName" name="locationName"/><span class="red"> * </span><br><br><br>
		   	<label>环境地址</label>
		   	<input id="address" name="address"/><span class="red"> * </span>
 
		</form> 
	
	</div>
	<div id="add_locationButton">
			<a class="easyui-linkbutton" iconCls="icon-save" onClick="saveLocation()">保存</a>
			<a class="easyui-linkbutton" iconCls="icon-no" onclick="colseLocation()">取消</a>			
	</div>

</body>
</html>