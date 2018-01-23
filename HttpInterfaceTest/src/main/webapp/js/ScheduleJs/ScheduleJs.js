
	function allStart(){
		
		$.get("Quartz/startAll.action",
				function(data){
			
		}
		);"json"
		
		$("#quartz_page").datagrid('load');
	}
	
	function stopSchedule(index){
		var row = $('#quartz_page').datagrid('getData').rows[index];
		//alert(row.triggerName+"---"+row.triggerGroupName);
		$.get("Quartz/stop.action?triggerName="+row.triggerName+"&triggerGroupName="+row.triggerGroupName+"&jobName="+row.jobName,
				function(data){
			
		}
		);"json"
		
		$("#quartz_page").datagrid('load');
	}
	
	function restartSchedule(index){
		var row = $('#quartz_page').datagrid('getData').rows[index];
		$.get("Quartz/restart.action?jobName="+row.jobName+"&jobGroup="+row.jobGroup,
				function(data){
			
		}
		);"json"
		
		$("#quartz_page").datagrid('load');
	}
	
	function formatOper(value,row,index){ 

		   var sacn  = '<a href="javascript:void(0)"  onClick="restartSchedule('+index+')">恢复</a>&nbsp;&nbsp;&nbsp;';
		   var debug = '<a href="javascript:void(0)"  onClick="stopSchedule('+index+')">停止</a>'; 
		   return sacn + debug;  
		}
		
	function forStats(value,row,index){
		
		if(value==0){
			return "<a style='color:red'>暂停中</a>";
		}else if(value==1){
			
			return "<a style='color:green'>运行中</a>";
		}else{
			
			return "已禁用";
		}
		
		
	}