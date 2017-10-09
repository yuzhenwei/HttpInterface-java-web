<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="addHeader_page" class="easyui-dialog" modal=true closed="true" buttons="#add_headerButton" style="width:400px;height:400px">
		
		<form id="addHeaderForm" style="padding:30px;">
		   	<label>请求头名称</label>
		   	<input id=headerName name="headerName"/><span class="red"> * </span><br><br><br>
		   	<label>请求头信息</label>
		   	<textarea id=headerContent name="headerContent" style="width:300px; height:180px" onfocus="header_onfocus()"/><br>
		   	<span id='headerspan'></span>
 
		</form> 
	
	</div>
	
	<div id="add_headerButton">
			<a class="easyui-linkbutton" iconCls="icon-save" onClick="saveHeader()">保存</a>
			<a class="easyui-linkbutton" iconCls="icon-no" onclick="colseHeader()">取消</a>			
	</div>

</body>
</html>