<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<div id="editHeader_page" class="easyui-dialog" modal=true closed="true" buttons="#edit_headerButton" style="width:400px;height:400px">
		
		<form id="editHeaderForm" style="padding:30px;">
			<label>序号</label>
		   	<input id="id" name="id" readonly=true/><br><br><br>
		   	<label>请求头名称</label>
		   	<input id=headerName name="headerName"/><span class="red"> * </span><br><br><br>
		   	<label>请求头信息</label>
		   	<textarea id=headerContent name="headerContent" style="width:300px; height: 180px"/>
 
		</form> 
	
	</div>
	
	<div id="edit_headerButton">
			<a class="easyui-linkbutton" iconCls="icon-save" onClick="editSaveHeader()">保存</a>
			<a class="easyui-linkbutton" iconCls="icon-no" onclick="editcColseHeader()">取消</a>			
	</div>
</body>
</html>