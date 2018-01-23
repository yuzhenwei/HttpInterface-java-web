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
	
</head>	
<body>
	<!-- 用例集管理页面----------------------------------------------------------------------------------------------------------------------------------  -->

	<div style="padding:5px;" class="easyui-panel" fit=true >
		
			<table id="quartz_page" class="easyui-datagrid" resizable="true" toolbar="#quartz_page_icon" title="任务列表"
   			 rownumbers="true" fitColumns="true" singleSelect="true" url="Quartz/JobsList.action"  >
		        <thead>
		            <tr>
						<!-- <th field="caseId" checkbox="true"> -->
												
						<th field="jobName" width=110px align="center">定时名称</th>
						<th field="triggerName" width=130px  align="center">触发器名称</th>
						<th field="jobStatus" width=130px  formatter="forStats" align="center">状态</th>
						<th field="desc" width=130px align="center" >任务描述</th>
						<th data-options="field:'Oper',formatter:formatOper" width=80px align="center">操作</th>
		            </tr>
		        </thead>
		    </table>	
		    
		    <div id="quartz_page_icon" style="padding:5px;">
			&nbsp;&nbsp;
			<a href="#" class="easyui-linkbutton"  iconCls="icon-man" onClick="allStart()">&nbsp;&nbsp;All START&nbsp;&nbsp;</a>			
		</div>	
		
	</div>	
	
		   
</body>
</html>