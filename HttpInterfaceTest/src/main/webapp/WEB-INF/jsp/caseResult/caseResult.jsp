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
	<!-- <script type="text/javascript"  src="js/jquery.min.js"></script>
	<script type="text/javascript"  src="js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css"/>
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css"/> -->

</head>
<body>
	<!-- 用例集管理页面----------------------------------------------------------------------------------------------------------------------------------  -->

	<div style="padding:5px;" class="easyui-panel">
		<div style="padding:5px;">
			<select id="selectNameId" class="easyui-combobox" name="dept" style="width:130px;" panelHeight=100>    
			    <option value="interfaceName">接口名称</option>   
			    <option value="authStatus">执行结果</option> 
			</select> 
			<input type="text" id="inputText" name="inputText" /> 
			<a class="easyui-linkbutton" iconCls="icon-search" onClick="searchRunCaseResultInterface()">查询</a>
		</div>		
			<table id="runCaseListDlgTab" class="easyui-datagrid"  title="执行结果集列表" 
			pagination=false rownumbers=true  singleSelect=true resizable=true
			url="case/searchRunCaseResult.action?region=OFC" fitColumns=true nowrap=false toolbar="#deleteCaseListResultId"
			>
		        <thead>
		            <tr>
						<!-- <th field="caseId" checkbox="true">  -->
						<th field="interfaceName" width=110px align="center">接口名称</th>
						<th field="interfaceAdress" width=110px align="left" >接口地址</th>
						<th field="interfaceParameter" width=170px align="left">请求参数</th>
						<!-- <th field="expectResult" width=110px align="center">预期结果</th> -->
						<th field="authStatus" width=110px align="center">执行结果</th>
						<th field="reason" width=110px align="left">原因</th>
						<th field="runTime" width=110px align="center">执行时间</th>
						<!-- 		
						<th field="interfaceDese" width=160px align="center">用例描述</th>
 						-->						
		             
		            </tr>
		        </thead>
		    </table>
		    <div id="deleteCaseListResultId" style="padding:5px;">
				<a class="easyui-linkbutton" iconCls="icon-cancel" onClick="deleteCaseListResult()">删除执行结果</a>
		    </div>	
	
	</div>	
	
</body>
</html>