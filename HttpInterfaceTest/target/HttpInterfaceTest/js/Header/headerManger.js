/*
 * 点击添加按钮弹出添加页面*/
function add_Header(){
	
	$("#addHeader_page").dialog("setTitle","添加请求头");
	$("#addHeaderForm").form("clear");
	$("#addHeader_page").dialog("open").dialog("vcenter");
	
}

/**
 * 添加请求头信息
 */
function saveHeader(){
	var pass=true;
	$("#addHeaderForm").find("input").each(function(){ 
		if(this.value == '') { 
			text = $(this).prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	$("#addHeaderForm").find("textarea").each(function(){ 
		if(this.value == '') { 
			text = $(this).prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	if(pass == true){
		
		$.post(
				"header/insertHeader.action",//请求地址
				$("#addHeaderForm").serialize(),//请求参数
				function(data){                   //获取返回值
					if(data.status =="ok"){
						$("#addHeader_page").dialog("close");
						//alert("添加数据成功");
						$.messager.alert('提示','添加数据成功','info');
						$("#headerTag").datagrid('load',""
						);//刷新页面			
					}else{
						
						//alert("添加数据失败");
						$.messager.alert('提示','添加数据成功','error');
					}			
				}
				
		);"json"
		
	}

	
	
}

function colseHeader(){
	
	$("#addHeader_page").dialog("close");
}

//修改请求头信息

function updateHeader(){
	
	var row = $("#headerTag").datagrid("getSelected");
	//alert(JSON.stringify(row));
	if(row !=null){
		$("#editHeader_page").dialog("setTitle","修改请求头");
		$("#editHeaderForm").form("load",row);
		$("#editHeader_page").dialog("open").dialog("vcenter");
		
	}else{
		
		//alert("请选择要修改的数据");
		$.messager.alert('提示','请选择要修改的数据','warning');
	}
	
}

function editSaveHeader(){
	
	var pass=true;
	$("#editHeaderForm").find("input").each(function(){ 
		if(this.value == '') { 
			text = $(this).prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	$("#editHeaderForm").find("textarea").each(function(){ 
		if(this.value == '') { 
			text = $(this).prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	if(pass == true){
		
		$.post(
				"header/updateHeader.action",//请求地址
				$("#editHeaderForm").serialize(),//请求参数
				function(data){                   //获取返回值
					if(data.status =="ok"){
						$("#editHeader_page").dialog("close");
						//alert("修改数据成功");
						$.messager.alert('提示','修改数据成功','info');
						$("#headerTag").datagrid('load',""
						);//刷新页面			
					}else{
						
						//alert("修改数据失败");
						$.messager.alert('提示','修改数据失败','error');
					}			
				}
				
		);"json"
		
	}
	
	
}

function editcColseHeader(){
	
	$("#editHeader_page").dialog("close");
	
}

function delHeader(){
	
	var row = $("#headerTag").datagrid("getSelected");
	if(row !=null){
		$.get(
				"header/delHeader.action?id="+row.id,
				function(data){
					if(data.status =="ok"){
						
						//alert("删除成功");
						$.messager.alert('提示','删除成功','info');
						$("#headerTag").datagrid("load","");
					}
					
				}
				
		);"json"
		
	}else{
		
		//alert("请选择要删除的数据");
		$.messager.alert('提示','请选择要删除的数据','warning');
	}
	
	
}



function searchHeader(){
	
	var headerName=$("#headerName").val();
	
	$.get("header/selNameHeader.action?headerName="+headerName,
			function(data){			
					
				$("#headerTag").datagrid("loadData",data);//加载本地数据							
			}
	);"json"
}

function clearHeader(){
	$("#headerName").val("");
	
}

function header_onfocus(){
	
	$("#headerspan").html('格式：参数=值;参数=值...（如：key=2123;name=ewww...）').css("color","red");
}