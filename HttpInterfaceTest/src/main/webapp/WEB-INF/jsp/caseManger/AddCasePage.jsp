<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<body>
	
	<div id="casePageId" class="easyui-dialog" modal=true closed=true  buttons="#casePageButton" style="width:500px;height:660px" >
		<form id="casePageFromId" style="padding:30px;">
		   	<label>接口名称</label>
		   	<input id="interfaceName" name="interfaceName"/><span class="red"> * </span><br><br><br>
		   	<label>接口地址</label>
		   	<input id="interfaceAdress" name="interfaceAdress"/><span class="red"> * </span><br><br><br>
		   	<label>归属平台</label>
		   		<select id="region" name="region" style="width:150px;">    
			    <option value="OFC">OFC</option>   
			    <option value="ODC">ODC</option>
			    <option value="SKU">基础数据平台</option>
			    <option value="Doctor">医生端</option>
			    <option value="patient">患者端</option>   
			</select><span class="red"> * </span> <br><br><br>
 			<label>请求方式</label>
		   		<select id="interfaceType" name="interfaceType" style="width:150px;">    
			    <option value="get">GET</option>   
			    <option value="post">POST</option> 
			</select><span class="red"> * </span> <br><br><br>
		   	<label>请求参数</label><br>
		   	<textarea style="width:420px;height:50px" id="interfaceParameter" name="interfaceParameter" onfocus="onshow_span()"/>
		   	<span id="spanid"></span>
		   	<br><br><br>
		   	<label>参数格式</label>
		   		<select id="parameterType" name="parameterType" style="width:150px;">    
			    <option value="json">JSON</option>   
			    <option value="arr">数组</option>
			    <option value="key">键值对</option>  
			</select><span class="red"> * </span> <br><br><br>
		   	<label>预期结果</label>
		   	<input id="expectResult" name="expectResult"/><span class="red"> * </span><br><br><br>
		   	<label>用例描述</label>
		   	<input id="interfaceDese" name="interfaceDese"/><br><br><br>
		   	<label>是否有依赖接口</label>
				<label><input   type="radio" name="dependStatus"  value="0" onclick="uncheck()"  />否 </label> 
				<label><input   type="radio" name="dependStatus"  value="1" onclick="check()" />是 </label> 			   
		   	<br><br><br>
			<div id="dependId" style="display:none;">
				<label>依赖关系</label>
			   	<input id="depend" name="depend" onfocus="onfocus_depend()"/><br>
				<span class="red" id="dependId_span"></span>
			</div>						
		</form> 
	
	
	</div>
	<div id="casePageButton">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="saveCase()">保存</a>  
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeCase()">取消</a>  
		
	</div>
	
</body>

</html>