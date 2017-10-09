//查找测试环境数据
function searchLocation(){
	
	var locationName = $("#locationName").val();//获取查询框的内容
	
	$("#locationTag").datagrid('load',{
		locationName: locationName
	});

}
//清除查询输入框
function clearLocation(){
	
	$("#locationName").val("");
}

//添加测试环境数据信息
function addLocation(){
	
	$("#addLocation_page").dialog('setTitle',"添加测试地址");
	$("#addlocationForm").form("clear");
	$("#addLocation_page").dialog("open").diglog("vcenter");	
	
	
	
}

//保存添加的地址信息
function saveLocation(){
	var pass=true;
	
	$("#addlocationForm").find("input").each(function(){
		
		if(this.value == '' && this.name != "depend" && this.name != "interfaceDese") { 
			text = $(this).prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	if(pass ==true){
		$.post(
				"location/insertlocation.action",//请求地址
				$("#addlocationForm").serialize(),//请求参数
				function(data){                   //获取返回值
					var status = data.status;
					if(status=="ok"){
						
						$("#addLocation_page").dialog("close");
						//alert("添加成功");
						$.messager.alert('提示','添加测试地址成功','info');
						$("#locationTag").datagrid('load',""
						);//刷新页面
					}
				
				},"json"
				
		);
		
	}
	

}


//修改测试地址
function updateLocation(){
	
	var row = $("#locationTag").datagrid('getSelected');
	
	if(row !=null && row !=""){
		//打开修改的页面
		$("#editLocation_page").dialog('setTitle',"修改测试地址");
		//加载选择的数据
		$("#editlocationForm").form("load",row);
		$("#editLocation_page").dialog("open").diglog("vcenter");
	}else{
		
		$.messager.alert('提示','请选择要修改的数据','warning');
	}
	
	
	
}
//关闭按钮
function colseLocation(){
	$("#addLocation_page").dialog("close");
	
}

//删除数据
function delLocation(){
	
	var row = $("#locationTag").datagrid("getSelected");
	//alert(row.id);
	if(row != null && row !=''){
		$.get(
				"location/deleteLocation.action?id="+row.id,
				function(result){                   //获取返回值
					var status = result.status;
					if(status=="ok"){	
						$.messager.alert('提示','删除成功','info');
						$("#locationTag").datagrid("load","");//刷新页面
					}
				
				},"json"
		
		);
		
	}else{
		
		$.messager.alert('提示','请选择要删除的数据','warning');
	}

	
}


//保存修改页面
function editSaveLocation(){
	//alert(JSON.stringify($("#editcasePageFromId").serialize()));
	var pass=true;
	$("#editlocationForm").find("input").each(function(){
		
		if(this.value == '' && this.name != "depend" && this.name != "interfaceDese") { 
			text = $(this).prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	if(pass == true){
		$.post(
				"location/updateLocation.action",//请求地址
				$("#editlocationForm").serialize(),//请求参数		
				function(data){                   //获取返回值
					if(data.status =="ok"){
						$("#editLocation_page").dialog("close");
						alert("修成成功");
						$("#locationTag").datagrid('load',""
						);//刷新页面			
					}			
					}
				
		);"json"
		
		
	}
	
}

//取消修改页面的按钮
function editColseLocation(){
	$("#editLocation_page").dialog("close");
	
}
