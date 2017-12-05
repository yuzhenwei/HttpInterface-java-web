<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div id="editLocation_page" class="easyui-dialog" modal=true closed="true" buttons="#edit_locationButton" style="width:400px;height:400px">
		
		<form id="editlocationForm" style="padding:30px;">
			<label>地址序号</label>
		   	<input id="id" name="id" readonly="true"  /><br><br><br>
		   	<label>环境名称</label>
		   	<input id="locationName" name="locationName"/><span class="red"> * </span><br><br><br>
		   	<label>环境地址</label>
		   	<input id="address" name="address"/><span class="red"> * </span><br><br><br>
		   	<label>归属平台</label>
		   	<select id="region" name="region" style="width:150px;">    
			    <option value="OFC">OFC</option>   
			    <option value="ODC">ODC</option>
			    <option value="SKU">基础数据平台</option>
			    <option value="Doctor">医生端</option>
			    <option value="patient">患者端</option>   
			</select>
		</form> 
	
	</div>
	<div id="edit_locationButton">
			<a class="easyui-linkbutton" iconCls="icon-save" onClick="editSaveLocation()">保存</a>
			<a class="easyui-linkbutton" iconCls="icon-no" onclick="editColseLocation()">取消</a>			
	</div>

</body>
</html>