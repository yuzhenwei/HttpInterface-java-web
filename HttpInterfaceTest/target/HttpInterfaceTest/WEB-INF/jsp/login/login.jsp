<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<base href="<%=basePath %>"> 
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript"  src="js/jquery.min.js"></script>
	<script type="text/javascript"  src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript"  src="js/easyui-lang-zh_CN.js"></script>


	<link rel="stylesheet" type="text/css" href="css/themes/icon.css"/>
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="css/custom/style.css">
	
	<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
	<META HTTP-EQUIV="expires" CONTENT="0">
	<title>测试平台管理</title>
</head>
<body onLoad="javascript:document.yourFormName.reset()">
	<div id="login" >  
        <h1>Login</h1> 
        <form method="post" action="loginOn.action">  
            <input type="text" required="required" autocomplete="off" placeholder="用户名" name="userName"/>  
            <input type="password" required="required" autocomplete="off" placeholder="密码" name="passWord"/>  
            <button class="but" type="submit">登录</button>  
        </form>  
    </div>  
</body>  

</body>
</html>