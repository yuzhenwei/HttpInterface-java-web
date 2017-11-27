
//打开添加页面
function addCaseList(){
	$("#casePageId").dialog("setTitle","添加用例");
	$("#casePageFromId").form("clear");
	$("#casePageId").dialog("open").dialog("vcenter");

	document.getElementsByName("dependStatus")[0].checked="checked"; //设置是否有依赖的否为选中 

	document.getElementsByName("headerStatus")[0].checked="checked";
		if($(":radio:checked").val() == 0){ //如果是否的时候，隐藏依赖的输入框
			
			$("#dependId").css('display','none'); 
			$("#headerId").css('display','none');
			
		}

}

//保存接口用例
function saveCase(){
	
	var pass=true;
	$("#casePageFromId").find("input").each(function(){
		
		if(this.value == '' && this.name != "depend" && this.name != "interfaceDese" && this.name !="header") { 
			text = $(this).prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	$("#casePageFromId").find("textarea").each(function(){ 
		if(this.value == '') { 
			text = $(this).prev().prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	if(pass == true){
		
		$.post(
				"case/addCase.action",//请求地址
				$("#casePageFromId").serialize(),//请求参数
				function(data){                   //获取返回值
					if(data.status =="ok"){
						$("#casePageId").dialog("close");
						//alert("添加成功");
						$.messager.alert('提示','添加成功','info'); 
						//刷新Demo页面	
						$("#caseListDlgTab").datagrid('load',""
						);
						//刷新odc页面
						$("#caseListDlgTab_odc").datagrid('load',""
						);
						//刷新sku页面	
						$("#caseListDlgTab_sku").datagrid('load',""
						);
						//刷新sku页面	
						$("#caseListDlgTab_doctor").datagrid('load',""
						);	
						$("#caseListDlgTab_patient").datagrid('load',""
						);
					}			
					}
				
		);"json"
		
	}
	
}

//关闭添加、修改页面
function closeCase(){
	
	$("#casePageId").dialog("close");
}


//删除用例
function deleteCaseList(){
	
	//var row = $("#caseListDlgTab").datagrid("getSelected");
	
	var fronId=$("#caseListDlgTab").datagrid("getSelections");
	 
    
    if(fronId !=null && fronId !=""){
   	 
   	 var caseId = new Array();
        for(var i=0; i<fronId.length; i++){  
     	   caseId.push(fronId[i].caseId);
        } 
        
        $.ajax({
 		   type: "POST",
 		   url: "case/deleteCase.action",
 		   data: {"caseId":caseId},
 		   dataType:'json',
 		   traditional:true,
 		   success: function(msg){
 			   if(msg.status == "ok"){
 				   //alert("测试用例执行完成：通过"+msg.pass+"个,失败"+msg.fail+"个");
 				   $.messager.alert('提示','删除成功','info'); 
 				   $("#caseListDlgTab").datagrid('reload');
 			   }   
 		   }
 		});
   	 
    }else{
   	 
   	 $.messager.alert('提示','请选择要删除的数据','warning');
   	 
    }
	
}

//按照接口名称查询页面
function searchInterface(){
	var interfaceName=$("#interfaceName").val();
	
	$.get("case/searchInterface.action?interfaceName="+interfaceName+"&region=OFC",
			function(data){
		$("#caseListDlgTab").datagrid("loadData",data);//加载本地数据
	}
	);"json"
	
	
}

//	清除查询数据
function clearInterface(){
	
	$("#interfaceName").val("");
	
}
//修改接口用例
function editCaseList(){
	var row = $("#caseListDlgTab").datagrid("getSelected");
	//alert(JSON.stringify(row));
	if(row !=null){
		$("#editcasePageId").dialog("setTitle","修改用例");
		$("#editcasePageFromId").form("load",row);
		
		if($("input[name='dependStatus']:radio:checked").val() == 1){ //如果是否的时候，隐藏依赖的输入框
			
			$("#dependId_edit").css('display','block'); 
			
			
		}else{
			
			$("#dependId_edit").css('display','none'); 
		}
		

		if($("input[name='headerStatus']:radio:checked").val() == 1){ //如果是否的时候，隐藏依赖的输入框
			
			$("#headerId_edit").css('display','block'); 
		
		}else{
			
			$("#headerId_edit").css('display','none'); 
		}
		
		$("#editcasePageId").dialog("open").dialog("vcenter");
		
	}else{
		
		//alert("请选择要修改的数据");
		$.messager.alert('提示','请选择要修改的数据','warning');
	}
		
}
//保存修改页面
function editsaveCase(){
	//alert(JSON.stringify($("#editcasePageFromId").serialize()));
	var pass=true;
	$("#editcasePageFromId").find("input").each(function(){
		
		if(this.value == '' && this.name != "depend" && this.name != "interfaceDese" && this.name !="header") { 
			text = $(this).prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	$("#editcasePageFromId").find("textarea").each(function(){ 
		if(this.value == '') { 
			text = $(this).prev().prev().text(); 
			$.messager.alert('提示',text+'是必填项','warning'); 
			this.focus(); 
			pass = false; 
			return false;//跳出each 
		}	
	});
	
	if(pass == true){
		$.post(
				"case/updateCase.action",//请求地址
				$("#editcasePageFromId").serialize(),//请求参数
				
				function(data){                   //获取返回值
					if(data.status =="ok"){
						$("#editcasePageId").dialog("close");
						//alert("修成成功");
						$.messager.alert('提示','修改成功','warning');
						$("#caseListDlgTab").datagrid('load',""
						);//刷新页面
						$("#caseListDlgTab_odc").datagrid('load',""
						);
						$("#caseListDlgTab_sku").datagrid('load',""
						);
						$("#caseListDlgTab_doctor").datagrid('load',""
						);
						$("#caseListDlgTab_patient").datagrid('load',""
						);
					}			
					}
				
		);"json"
		
	}
	
}

//取消修改页面的按钮
function editcloseCase(){
	$("#editcasePageId").dialog("close");
	
}

function check(){
	
	$("#dependId").css('display','block'); 

}

function uncheck(){
	
	$("#dependId").css('display','none'); 

}


function check_doctor(){
	
	$("#dependId_edit").css('display','block'); 

}

function uncheck_doctor(){
	
	$("#dependId_edit").css('display','none'); 

}


			
	function onshow_span(){
		$("#spanid").html('格式：参数=值&参数=值...（如：key=2123&name=ewww...）').css("color","red");
		
	}
	
	function onfocus_depend(){
		
		$("#dependId_span").html('格式：依赖接口序号=依赖的值，依赖的值...;（如：88=name,age,Id;22=name,...）');
	}
	
	
function batchOutCase_OFC(){
	
	var interfaceName=$("#interfaceName").val();		
	window.location.href="LeadToExcel/outExcel.action?interfaceName="+interfaceName+"&region=OFC";
}

	

function check_header(){
	
	$("#headerId").css('display','block'); 

}

function uncheck_header(){
	
	$("#headerId").css('display','none'); 

}
	
	

function check_header_edit(){
	
	$("#headerId_edit").css('display','block'); 

}

function uncheck_header_edit(){
	
	$("#headerId_edit").css('display','none'); 

}
	
	
	
	
	
	
	
	

