<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

	<div id="importExcel" class="easyui-dialog" modal=true closed=true  style="width:500px;height:300px" >

		<form id="uploadExcel"  method="post" enctype="multipart/form-data">
		<br>
         <table align="center" style="margin-top:30px;margin-left: 50px;">
                    <tr>
                        <td>请选择文件:&nbsp;&nbsp;</td>
                        <td>
                        <input type="file" name="excel" id="excel" />
                        </td>
                    </tr>
                </table>
            </form>
            <div style="text-align: center; padding: 5px 0;">  
            <a id = "booten" href="javascript:void(0)" class="easyui-linkbutton"  
                onclick="uploadExcel()" style="width: 80px" id="tt">导入</a>  
        </div> 
    </div>
     
</body>

</html>