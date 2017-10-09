function searchInterface_sku(){
	var interfaceName=$("#interfaceName_sku").val();
	
	$.get("case/searchInterface.action?interfaceName="+interfaceName+"&region=SKU",
			function(data){
		$("#caseListDlgTab_sku").datagrid("loadData",data);//加载本地数据
	}
	);"json"
	
	
}



function cutmuchCaseList_sku(){
	
	var testLocationIp = $("#testLocationIp_sku").combo("getValue");//获取测试环境地址
	var fronId=$("#caseListDlgTab_sku").datagrid("getSelections");//获取被选中的测试用例
	//var header=$("#headerIp_sku").combo("getValue");
	
	
	if(testLocationIp ==""){
		
		$.messager.alert('提示','请选择测试地址','warning'); 
	}else if (fronId ==""){
		$.messager.alert('提示','请选择测试用例','warning'); 
		
	}/*else if(header ==""){
		$.messager.alert('提示','请选择请求头','warning'); 
	}*/else {
		
		 var caseId = new Array();
	       for(var i=0; i<fronId.length; i++){  
	    	   caseId.push(fronId[i].caseId);
	       } 
		
	      /*var jsonStr = JSON.stringify(fronId);
			alert(jsonStr);*/
			/*alert(testLocationIp);
			alert(caseId);*/
		
		//异步提交
		$.ajax({
			   type: "POST",
			   url: "runMuchCase.action",
			   data: {"caseId":caseId,"testLocationIp":testLocationIp},
			   dataType:'json',
			   traditional:true,
			   //async: false, //同步请求，默认情况下是异步（true）
			   beforeSend: function(){
				   $.messager.progress({
					   text:'数据执行中......'
						   }); 

			   },
			   success: function(msg){
				   if(msg.status == "ok"){
					   $.messager.progress("close");
					   //alert("测试用例执行完成：通过"+msg.pass+"个,失败"+msg.fail+"个");
					   $.messager.alert('提示','执行成功','info'); 
				   }   
			   }
			});
		
		
	}
  
}





//删除用例
function deleteCaseList_sku(){
	
	var row = $("#caseListDlgTab_sku").datagrid("getSelected");
	
	if(row !=null && row !=""){
		$.get(
				"case/deleteCase.action?caseId="+row.caseId,
				function(data){
					if(data.status =="ok"){
						
						//alert("删除成功");
						$.messager.alert('提示','删除成功','info'); 
						$("#caseListDlgTab_sku").datagrid("load","");
					}
					
				}
				
		);"json"
		
	}else{
		
		$.messager.alert('提示','请选择要删除的数据','warning');
	}
	
	
	
}


//修改接口用例
function editCaseList_sku(){
	var row = $("#caseListDlgTab_sku").datagrid("getSelected");
	//alert(JSON.stringify(row));
	if(row !=null){
		$("#editcasePageId").dialog("setTitle","修改用例");
		$("#editcasePageFromId").form("load",row);
		
		if($(":radio:checked").val() == 1){ //如果是否的时候，隐藏依赖的输入框
			
			$("#dependId_edit").css('display','block'); 
			alert($(":radio:checked").val());
		}else{
			
			$("#dependId_edit").css('display','none'); 
		}
		$("#editcasePageId").dialog("open").dialog("vcenter");
		
	}else{
		
		//alert("请选择要修改的数据");
		$.messager.alert('提示','请选择要修改的数据','warning'); 
	}
		
}


function clearInterface_sku(){
	
	$("#interfaceName_sku").val("");
}





//删除执行的结果
function deleteCaseListResult_sku(){
	
	$.get(
			"case/deleteCaseRunResult.action?region=SKU",
			function(result){                   //获取返回值
				var status = result.status;
				if(status=="ok"){	
					//alert("删除成功");
					$.messager.alert('提示','删除成功','info'); 
					$("#runCaseListDlgTab_sku").datagrid('load');//刷新页面
				}
			
			},"json"
	
	);
	
	
}


/**
 * 按照接口名称和执行的状态查询执行的结果
 */
function searchRunCaseResultInterface_sku(){

	var text_name = $("#selectNameId_sku").combobox("getValue");
	var text_value=$("#inputText_sku").val();
	//异步提交
	$.ajax({
		   type: "POST",
		   url: "case/searchRunCaseResult.action",
		   data: {"textName":text_name,"textValue":text_value,region:"SKU"}, 
		   success: function(msg){
			   
			   if(msg.length ==0){
				   
				   //alert("没有查询到数据");
					$.messager.alert('提示','没有查询到数据','error'); 
			   }else{
				   
				   $("#runCaseListDlgTab_sku").datagrid("loadData",msg); 
			   }
			   
		   }
		});
	
	
}






