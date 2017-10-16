
	/*function cutCaseList(){
		
		var testLocationIp = $("#testLocationIp").combo("getValue");//获取测试环境地址
		var fronId=$("#caseListDlgTab").datagrid("getSelected");//获取被选中的测试用例
		fronId.address = testLocationIp; //把测试环境的添加到请求参数中
		
		//var jsonStr = JSON.stringify(row);
		//alert(jsonStr);
		var fronId = JSON.stringify(fronId);
		alert(fronId);

		//异步提交
		$.ajax({
			   type: "POST",
			   url: "runCase.action",
			   data: fronId,
			   success: function(msg){
				   //if(msg.status =="ok"){}
				   $("#caseListDlgTab").datagrid('load',"");
			   }
			});
	}*/
	
//批量执行测试用例
	function cutmuchCaseList(){
	
		var testLocationIp = $("#testLocationIp").combo("getValue");//获取测试环境地址
		var fronId=$("#caseListDlgTab").datagrid("getSelections");//获取被选中的测试用例
		var header=$("#headerIp_OFC").combo("getValue");//
		if(testLocationIp ==""){
			
			//alert("请选择测试地址");
			$.messager.alert('提示','请选择测试地址','warning'); 

		}else if (fronId ==""){
			//alert("请选择测试用例");
			$.messager.alert('提示','请选择测试用例','warning'); 

			
		}else {
			
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
				   data: {"caseId":caseId,"testLocationIp":testLocationIp,"header":header},
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
						   //alert("执行完成：通过"+msg.pass+"个,失败"+msg.fail+"个");
						   $.messager.alert('提示','执行成功','info'); 
					   }   
				   }
				});
			
			
		}
	  
}


