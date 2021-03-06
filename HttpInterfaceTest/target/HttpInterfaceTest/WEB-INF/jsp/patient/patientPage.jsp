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
	<!-- 引入easyui的样式 -->
	<base href="<%=basePath %>"> 
	
		<!-- 引入js -->
<!-- 	<script type="text/javascript"  src="js/jquery.min.js"></script>
	<script type="text/javascript"  src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/caseManger/caseManger.js"></script>
	<script type="text/javascript" src="js/caseManger/caseExecute.js"></script>

	<link rel="stylesheet" type="text/css" href="css/themes/icon.css"/>
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css"/>
 -->
	
</head>
	<%@include file="../caseManger/AddCasePage.jsp"  %>
	<%@include file="../caseManger/EditCasePage.jsp" %>
<body>
	<!-- 用例集管理页面----------------------------------------------------------------------------------------------------------------------------------  -->

	<div style="padding:5px;" class="easyui-panel" fit=true >
		<div style="padding:15px 5px 5px 5px;">
			<label>接口名称</label>
			<input id="interfaceName_patient" name="interfaceName" class="easyui-textbox"></input>
			<a class="easyui-linkbutton" iconCls="icon-search" onClick="searchInterface_patient()">查询</a>
			<button class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearInterface_patient()">清除</button>
		</div>
			<table id="caseListDlgTab_patient" class="easyui-datagrid"  title="用例集列表" 
			pagination=true rownumbers=true   resizable=true  url="case/selectCase.action?region=patient" 
			toolbar="#caseListTb_patient,#edListTb_patient" fitColumns=true pageSize=15 pageList=[15,30]>
		        <thead>
		            <tr>
		            	<th checkbox="true">
						<th field="caseId" >接口序号</th>
						<th field="interfaceName" width=110px align="left">接口名称</th>
						<th field="interfaceAdress" width=130px  >接口地址</th>
						<th field="depend" width=130px  >依赖关系</th>
						<th field="interfaceType" width=50px align="left">请求方式</th>
						<th field="interfaceParameter" width=170px align="left">请求参数</th>
						<th field="expectResult" width=110px align="left">预期结果</th>
						<!-- <th field="runTime" width=110px align="center">执行时间</th> -->
						<!-- <th field="authResult" width=110px align="center">实际结果</th>
						<th field="authStatus" width=110px align="center">状态</th> -->
						<th field="interfaceDese" width=170px align="left">用例描述</th>	           
		            </tr>
		        </thead>
		    </table>	
		
			
	    <div id="caseListTb_patient" style="padding:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"  onClick="addCaseList()">添加</a>&nbsp;
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"  onClick="editCaseList_patient()">修改</a>&nbsp;
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove"  onClick="deleteCaseList_patient()">删除</a>	&nbsp;		
		</div>
		<!-- 注释 -->
		<div id="edListTb_patient" style="padding:5px;">
			<label>测试地址</label>
			<input id="testLocationIp_patient" class="easyui-combobox"  valueField="address" textField="locationName" url="location/searchLocation.action" /> 
			&nbsp;
			<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut"  onClick="cutCaseList()">执行</a> -->
			<label>请求头</label>
			<input id="headerIp_patient" class="easyui-combobox"  valueField="headerContent" textField="headerName" url="header/getHeaders.action" /> 
			&nbsp;
			<a href="#" class="easyui-linkbutton" iconCls="icon-cut"  onClick="cutmuchCaseList_patient()">执行</a>
		</div>
	</div>	

		   
</body>
</html>