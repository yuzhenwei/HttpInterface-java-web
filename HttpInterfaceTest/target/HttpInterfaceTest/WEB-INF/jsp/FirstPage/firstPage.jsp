<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath %>">
	<script type="text/javascript"  src="js/jquery.min.js"></script>
	<script type="text/javascript"  src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript"  src="js/easyui-lang-zh_CN.js"></script>	
	<script type="text/javascript" 	src="js/firstPage/firstPage.js"></script>
	<script type="text/javascript" src="js/caseManger/caseManger.js"></script>
	<script type="text/javascript" src="js/caseManger/caseExecute.js"></script>
	<script type="text/javascript"  src="js/location/location.js"></script>
	<script type="text/javascript" src="js/caseManger/caseResult.js"></script>
	<script type="text/javascript" src="js/Header/headerManger.js"></script>
	<script type="text/javascript" src="js/ODCManger/odcManger.js"></script>
	<script type="text/javascript" src="js/SkuManger/skuManger.js"></script>
	<script type="text/javascript" src="js/doctor/doctorManger.js"></script>
	<script type="text/javascript" src="js/patient/patientManger.js"></script>
	
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css"/>
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="css/custom/custom.css">
	<title>测试平台管理</title>
</head>
<body>

	<div id="firstPage" class="easyui-layout" fit=true>  
	 
		<!-- 头部信息 -->
	    <div data-options="region:'north',split:true" style="height:70px;background:#eaf2ff;text-align: center">	    	
	    	
    	 		<!-- <a class="size">测试平台</a> -->
	    	<span class="size">测试管理平台 </span>
	        <div style="position:absolute;bottom:0;right:0">
			            <a class="sizeti">用户名:${user}</a>
			    	<c:if test="${user!=null}">
			    		<a href="loginOut.action" style="padding:5px;">注销</a>
		    	 	</c:if>
	        </div>
	    </div>   
 		<!-- 导航栏 -->
	    <div data-options="region:'west',title:'导航栏',split:true" style="width:180px;background:#eaf2ff ">
	    		<!-- 导航栏的中间树 -->
	    		<ul  id="treeId" class="easyui-tree" lines=true > 
	    			<li>
	    				<span>接口平台管理 </span>
		    				<ul>
		    				
		    					<li>
		    						<span>测试环境管理</span>
				    						<ul> 
				    							<li id="testLocationId">
				    								<a><span>环境维护</span></a>
				    							</li>
				    							<li id="headerInterfaceId">
				    								<span>请求头管理</span>
				    							</li>
				    						</ul>
		    					</li>
		    				
		    					<li >
	    							<span>后端接口平台</span>
	    				
	    				
				    				<ul>

				    					<li state="closed">
				    						<span>基础数据平台</span>
				    						<ul>
				    							<li id="skuTestCase">
				    								<span>基础数据—用例</span>
				    							</li>
				    							<li id="skuRunCase">
				    								<span>基础数据—报告</span>
				    							</li>	    							
				    						</ul>
				    					</li>
				    					<li state="closed">
				    						<span>ODC端</span>
				    						<ul>
				    							<!-- <li id="odcHeader">
				    								<span>请求头_ODC</span>
				    							</li> -->
				    							<li id="odcTestCase">
				    								<span>ODC—用例</span>
				    							</li>
				    							<li id="odcRunCase">
				    								<span>ODC—报告</span>
				    							</li>	    							
				    						</ul>
				    					</li>
				    					
				    					 					
				    					<li state="closed">
				    						<span>OFC端</span>
				    						<ul>
				    							
				    							<li id="testCaseInterfaceId">
				    								<span>OFC—用例</span>
				    							</li>
				    							<li id="runCaseInterfaceId">
				    								<span>OFC—报告</span>
				    							</li>
				    							
				    						</ul>
				    					</li>	
				    				</ul> 
	    						</li>
	    			
	    			
				    			<li >
				    				<span>前端接口平台</span>
				    				<ul>
			    						<li state="closed">
				    						<span>医生端</span>
				    						<ul>
				    							<li id="doctorTestCase">
				    								<span>医生—用例</span>
				    							</li>
				    							<li id="doctorRunCase">
				    								<span>医生—报告</span>
				    							</li>
				    						</ul>
				    					</li>
				    					
				    					
				    					<li state="closed">
				    						<span>患者端</span>
				    						<ul>
				    							<li id="patientTestCase">
				    								<span>患者—用例</span>
				    							</li>
				    							<li id="patientRunCase">
				    								<span>患者—报告</span>
				    							</li>
				    						</ul>
				    					</li>
				    					
				    				</ul>
				    			</li>
	
		    				
		    				</ul>
	    				</li>
	    			
					</ul>
	    </div>
 		<!-- 中间部分 -->
	    <div id="centerPageId" data-options="region:'center'">
	    	<!-- 分页层 -->
	    	<div id="centerTabs" class="easyui-tabs" fit=true>
	    		<!-- 首页 -->
	    		<div title="首页"  class="firstPage" data-options="closable:true"  >   
			           
			    	<div class="author">
			    	
			    			<h2 align="center" style="font-size:30px;font-family: 宋体;">侠 客 行</h2>
			    	
			    			<div style="font-size:20px">						
								<a>赵客缦胡缨，吴钩霜雪明。银鞍照白马，飒沓如流星。</a><br>
								<a>十步杀一人，千里不留行。事了拂衣去，深藏身与名。</a><br>
								<a>闲过信陵饮，脱剑膝前横。将炙啖朱亥，持觞劝侯嬴。</a><br>
								<a>三杯吐然诺，五岳倒为轻。眼花耳热后，意气素霓生。</a><br>
								<a>救赵挥金槌，邯郸先震惊。千秋二壮士，煊赫大梁城。</a><br>
								<a>纵死侠骨香，不惭世上英。谁能书閤下，白首太玄经。</a><br>
							</div>
			    	</div>
			            
			    </div>
			    
	     	</div>
	    </div>   
	</div>
</body>
</html>