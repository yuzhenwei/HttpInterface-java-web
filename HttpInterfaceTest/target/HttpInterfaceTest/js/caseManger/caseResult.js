
//删除执行的结果
function deleteCaseListResult(){
	
	$.get(
			"case/deleteCaseRunResult.action?region=OFC",
			function(result){                   //获取返回值
				var status = result.status;
				if(status=="ok"){	
					//alert("删除成功");
					$.messager.alert('提示','删除成功','info');
					$("#runCaseListDlgTab").datagrid('load');//刷新页面
				}
			
			},"json"
	
	);
	
	
}


/**
 * 按照接口名称和执行的状态查询执行的结果
 */
function searchRunCaseResultInterface(){

	var text_name = $("#selectNameId").combobox("getValue");
	var text_value=$("#inputText").val();
	//异步提交
	$.ajax({
		   type: "POST",
		   url: "case/searchRunCaseResult.action",
		   data: {"textName":text_name,"textValue":text_value,region:"OFC"}, 
		   success: function(msg){
			   
			   if(msg.length ==0){
				   
				   //alert("没有查询到数据");
				   $.messager.alert('提示','没有查询到数据','error');
			   }else{
				   
				   $("#runCaseListDlgTab").datagrid("loadData",msg); 
			   }
			   
		   }
		});
	
	
}


