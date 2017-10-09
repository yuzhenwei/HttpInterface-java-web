$(function(){
	
		$('#treeId').tree({	
		    onClick: function(node){
		    	//加载接口测试用例页面
		    	if(node.id =="testCaseInterfaceId"){
		    		//获取分页的title
			    	   //var tab = $('#centerTabs').tabs('getTab','接口用例');
		    			
			    	   if(!$('#centerTabs').tabs('exists','OFC—用例')){		
				    	   $('#centerTabs').tabs('add',{
							    title:'OFC—用例',     
							    closable:true,
							    href:"case/caseManger.action?region=OFC", 
							});				    	   
			    		   
			    	   }else{
			    		   $('#centerTabs').tabs('select','OFC—用例'); //页面跳转到接口用例页面
			    		   var tab = $('#centerTabs').tabs('getTab','OFC—用例');//选择当前页面
			    		   tab.panel('refresh', 'case/caseManger.action?region=OFC');//刷新页面信息
			    	   }
			    	    	   
			    	   
		    	}
		    	//加载环境维护的页面
		    	if(node.id =="testLocationId"){
		    		if(!$('#centerTabs').tabs('exists','环境维护')){
		    			$('#centerTabs').tabs('add',{    
						    title:'环境维护',     
						    closable:true,
						    href:"location/location.action" 
						});
		    			
		    		}else{
			    		  
		    			$('#centerTabs').tabs('select','环境维护'); 
		    			var tab1 = $('#centerTabs').tabs('getSelected');
			    		tab1.panel('refresh', 'location/location.action');

			    	   }
		    	} 
		    	
		    	//加载用例执行页面
		    	if(node.id =="runCaseInterfaceId"){
		    		//var tab = $('#centerTabs').tabs('getTab','执行用例');
		    		if(!$('#centerTabs').tabs('exists','OFC—报告')){
		    			$('#centerTabs').tabs('add',{    
						    title:'OFC—报告',     
						    closable:true,
						    href:"case/caseResult.action?region=OFC" 
						});
		    			
		    		}else{
		    			$('#centerTabs').tabs('select','OFC—报告'); 
		    			var tab = $('#centerTabs').tabs('getTab','OFC—报告');
			    		tab.panel('refresh', 'case/caseResult.action?region=OFC');

			    	   }
		    		
		    		
		    		
		    	}
		    	
		    	if(node.id =="headerInterfaceId"){
		    		
		    		if(!$('#centerTabs').tabs('exists','请求头管理')){
		    			$('#centerTabs').tabs('add',{    
						    title:'请求头管理',     
						    closable:true,
						    href:"header/header.action" 
						});
		    			
		    		}else{
		    			$('#centerTabs').tabs('select','请求头管理'); 
		    			var tab = $('#centerTabs').tabs('getTab','请求头管理');
			    		tab.panel('refresh', 'header/header.action');

			    	   }
		    		
		    		
		    		
		    	}
		    	
		    	
				/*if(node.id =="odcHeader"){
						    		
		    		if(!$('#centerTabs').tabs('exists','请求头_ODC')){
		    			$('#centerTabs').tabs('add',{    
						    title:'请求头_ODC',     
						    closable:true,
						    href:"header/header.action" 
						});
		    			
		    		}else{
		    			$('#centerTabs').tabs('select','请求头_ODC'); 
		    			var tab = $('#centerTabs').tabs('getTab','请求头_ODC');
			    		tab.panel('refresh', 'header/header.action');

			    	   }		    		
				}*/
				
				
		    	if(node.id =="odcTestCase"){
		    		//获取分页的title
			    	   //var tab = $('#centerTabs').tabs('getTab','接口用例');
			    	   if(!$('#centerTabs').tabs('exists','ODC—用例')){		
				    	   $('#centerTabs').tabs('add',{
							    title:'ODC—用例',     
							    closable:true,
							    href:"case/odcCase.action?region=ODC", 
							});				    	   
			    		   
			    	   }else{
			    		   $('#centerTabs').tabs('select','ODC—用例'); //页面跳转到接口用例页面
			    		   var tab = $('#centerTabs').tabs('getTab','ODC—用例');//选择当前页面
			    		   tab.panel('refresh', 'case/odcCase.action?region=ODC');//刷新页面信息
			    	   }
			    	    	   
			    	   
		    	}				
				
		    	if(node.id =="odcRunCase"){
		    		//var tab = $('#centerTabs').tabs('getTab','执行用例');
		    		if(!$('#centerTabs').tabs('exists','ODC—报告')){
		    			$('#centerTabs').tabs('add',{    
						    title:'ODC—报告',     
						    closable:true,
						    href:"case/odcCaseResult.action" 
						});
		    			
		    		}else{
		    			$('#centerTabs').tabs('select','ODC—报告'); 
		    			var tab = $('#centerTabs').tabs('getTab','ODC—报告');
			    		tab.panel('refresh', 'case/odcCaseResult.action');

			    	   }
		    		
		    		
		    		
		    	}
				
				
		    	
		    	if(node.id =="skuTestCase"){
		    		//获取分页的title
			    	   //var tab = $('#centerTabs').tabs('getTab','接口用例');
			    	   if(!$('#centerTabs').tabs('exists','基础数据—用例')){		
				    	   $('#centerTabs').tabs('add',{
							    title:'基础数据—用例',     
							    closable:true,
							    href:"case/caseManger.action?region=SKU", 
							});				    	   
			    		   
			    	   }else{
			    		   $('#centerTabs').tabs('select','基础数据—用例'); //页面跳转到接口用例页面
			    		   var tab = $('#centerTabs').tabs('getTab','基础数据—用例');//选择当前页面
			    		   tab.panel('refresh', 'case/caseManger.action?region=SKU');//刷新页面信息
			    	   }
			    	    	   
			    	   
		    	}				
				
		    	if(node.id =="skuRunCase"){
		    		//var tab = $('#centerTabs').tabs('getTab','执行用例');
		    		if(!$('#centerTabs').tabs('exists','基础数据—报告')){
		    			$('#centerTabs').tabs('add',{    
						    title:'基础数据—报告',     
						    closable:true,
						    href:"case/caseResult.action?region=SKU" 
						});
		    			
		    		}else{
		    			$('#centerTabs').tabs('select','基础数据—报告'); 
		    			var tab = $('#centerTabs').tabs('getTab','基础数据—报告');
			    		tab.panel('refresh', 'case/caseResult.action?region=SKU');

			    	   }
		    		
		    		
		    		
		    	}
				
				
		    	if(node.id =="doctorTestCase"){
		    		//var tab = $('#centerTabs').tabs('getTab','执行用例');
		    		if(!$('#centerTabs').tabs('exists','医生—用例')){
		    			$('#centerTabs').tabs('add',{    
						    title:'医生—用例',     
						    closable:true,
						    href:"case/caseManger.action?region=Doctor" 
						});
		    			
		    		}else{
		    			$('#centerTabs').tabs('select','医生—用例'); 
		    			var tab = $('#centerTabs').tabs('getTab','医生—用例');
			    		tab.panel('refresh', 'case/caseManger.action?region=Doctor');

			    	   }
		    		
		    		
		    		
		    	}
		    	
		    	
		    	if(node.id =="doctorRunCase"){
		    		//var tab = $('#centerTabs').tabs('getTab','执行用例');
		    		if(!$('#centerTabs').tabs('exists','医生—报告')){
		    			$('#centerTabs').tabs('add',{    
						    title:'医生—报告',     
						    closable:true,
						    href:"case/caseResult.action?region=Doctor" 
						});
		    			
		    		}else{
		    			$('#centerTabs').tabs('select','医生—报告'); 
		    			var tab = $('#centerTabs').tabs('getTab','医生—报告');
			    		tab.panel('refresh', 'case/caseResult.action?region=Doctor');

			    	   }
		    		
		    		
		    		
		    	}
		    	
		    	if(node.id =="patientTestCase"){
		    		//var tab = $('#centerTabs').tabs('getTab','执行用例');
		    		if(!$('#centerTabs').tabs('exists','患者—用例')){
		    			$('#centerTabs').tabs('add',{    
						    title:'患者—用例',     
						    closable:true,
						    href:"case/caseManger.action?region=patient" 
						});
		    			
		    		}else{
		    			$('#centerTabs').tabs('select','患者—用例'); 
		    			var tab = $('#centerTabs').tabs('getTab','患者—用例');
			    		tab.panel('refresh', 'case/caseManger.action?region=patient');

			    	   }
		    		
		    		
		    		
		    	}
		    	
		    	
		    	if(node.id =="patientRunCase"){
		    		//var tab = $('#centerTabs').tabs('getTab','执行用例');
		    		if(!$('#centerTabs').tabs('exists','患者—报告')){
		    			$('#centerTabs').tabs('add',{    
						    title:'患者—报告',     
						    closable:true,
						    href:"case/caseResult.action?region=patient" 
						});
		    			
		    		}else{
		    			$('#centerTabs').tabs('select','患者—报告'); 
		    			var tab = $('#centerTabs').tabs('getTab','患者—报告');
			    		tab.panel('refresh', 'case/caseResult.action?region=patient');

			    	   }
		    		
		    		
		    		
		    	}

		    }
		});		

		
	});



	


