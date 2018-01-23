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
	<script type="text/javascript"  src="js/jquery.min.js"></script>
	<script type="text/javascript"  src="js/jquery.easyui.min.js"></script>	
	<script type="text/javascript"  src="js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"  src="js/report/reportJs_ODC.js"></script>	
	
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css"/>
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css"/>
</head>	
<body>
	<!-- 用例集管理页面----------------------------------------------------------------------------------------------------------------------------------  -->

	<div style="padding:5px;" class="easyui-panel" fit=true >
		<div style="font-size:30px;width:270px; height:30px; margin:0 auto; ">
			接口平台测试报告
		</div>
		<br>
		<div style="font-size:16px">
			用例总个数:<a id="sumNub_ODC"></a>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			失败个数:<a id="failNub_ODC"></a>数&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			通过个数:<a id="psNub_ODC"></a>数&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			执行时间:<a id="runTime_ODC"></a>s		
		</div>	
		<table id="runCaseListDlgTab_ODC" class="easyui-datagrid"  title="执行结果集列表" 
			pagination=false rownumbers=true  singleSelect=true resizable=true
			url="case/searchRunCaseResult.action?region=ODC" fitColumns=true nowrap=false>
		        <thead>
		            <tr>
						<th field="caseId">接口序号</th>
						<th field="interfaceName" width=110px align="center">接口名称</th>
						<th field="interfaceAdress" width=110px align="left" >接口地址</th>
						<th field="interfaceParameter" width=170px align="left">请求参数</th>
						<th field="authStatus"  width=110px formatter="frAuthStats_ODC"align="center" >执行结果</th>
						<th field="reason"  width=110px align="left">原因</th>
						<th field="runTime" width=110px formatter="runTimeSum_ODC" align="center">执行时间</th>													             
		            </tr>
		        </thead>
		    </table>	
		    
		   
		
	</div>	
	
		   
</body>
</html>