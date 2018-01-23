package cn.qlk.test.service;





import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.qlk.test.bean.CaseManger;
import cn.qlk.test.dao.CaseMangerMapper;
import cn.qlk.test.dao.RunCaseMangerMapper;
import cn.qlk.test.until.ClientHttp;
import cn.qlk.test.until.ConvertUntil;
import cn.qlk.test.until.ExpectResultUntil;
import cn.qlk.test.until.JsonUntil;


@Service
public class RunCaseMangeService {
	
	private static final Logger logger = LoggerFactory.getLogger(RunCaseMangeService.class);
	@Autowired
	private RunCaseMangerMapper runCaseMangerMapper;
	
	@Autowired
	private CaseMangerMapper caseMapper;
	
	/**
	 * 执行单个用例测试
	 */
	/*
	public void runCaseOne(CaseManger caseManger,Location location){
		
		*//**
		 * 1.获取测试地址
		 * 2、获取接口地址
		 * 3、获取请求方式
		 * 4、获取请求参数
		 * 5、拼接接口地址
		 * 6、发送接口请求
		 * 7、获取请求结果
		 * 8、校验实际结果与预期结果
		 *//*
		
		String address = location.getAddress();
		
		String interfaceAdress = caseManger.getInterfaceAdress();
		//3、获取请求方式
		String interfaceType = caseManger.getInterfaceType();
		//4、获取请求参数
		String interfaceParameter = caseManger.getInterfaceParameter();
		String expectResult = caseManger.getExpectResult();
		//5、拼接接口地址
		String url=address+interfaceAdress;
		//6、发送接口请求
		
		HttpRequsetUntil httpRequsetUntil = new HttpRequsetUntil();
		//* 7、获取请求结果，并统计接口的耗时
		long starttime = System.currentTimeMillis();
		String sendRequest = httpRequsetUntil.sendRequest(url, interfaceParameter, interfaceType);
		long endtime = System.currentTimeMillis();
		
		float runTime = (float)(endtime-starttime)/1000;
		
		//8、校验实际结果与预期结果
		JsonUntil jsonUntil = new JsonUntil(ExpectResultUntil.getExpectKey(expectResult),ExpectResultUntil.getExpectValues(expectResult));
		//ExpectResultUntil expectResultUntil = new ExpectResultUntil();
		//获取返回的验证字段的值
		String pString=jsonUntil.getParamValue(sendRequest);
		
		String authResult=ExpectResultUntil.getExpectKey(expectResult)+"="+pString;
		
		caseManger.setAuthResult(authResult);
		if(authResult.equals(expectResult)){
			caseManger.setAuthStatus("PASS");
			caseManger.setRunTime(runTime+"s");
			try {
				
				runCaseMangerMapper.updateRunCase(caseManger);
				logger.debug("更新成功");
			} catch (Exception e) {
				logger.debug("更新失败");
				e.printStackTrace();
			}
			
		}else{
			caseManger.setAuthStatus("FAIL"+"原因：实际结果与预期结果不匹配：预期结果："+expectResult+"实际结果："+authResult);
			try {
				runCaseMangerMapper.updateRunCase(caseManger);
				logger.debug("更新成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.debug("更新失败");
				e.printStackTrace();
			}
		}
		
		logger.debug("查询成功");
	}*/
	
	/**
	 * 批量执行测试用例
	 * @param id
	 * @param testLocationIp
	 * @return 
	 */
	public void runCaseBacth(int id, String testLocationIp) {
		/**
		 * 2、获取接口地址
		 * 3、获取请求方式
		 * 4、获取请求参数
		 * 5、拼接接口地址
		 * 6、发送接口请求
		 * 7、获取请求结果
		 * 8、校验实际结果与预期结果
		 */
		CaseManger caseManger = selectCaseById(id);
		//获取界都地址
		String interfaceAdress = caseManger.getInterfaceAdress();
		//3、获取请求方式
		String interfaceType = caseManger.getInterfaceType();
		//4、获取请求头
		String header =caseManger.getHeader();
		
		String dependPramater = null ;//依赖字段
		
		String interfaceParameter = null;
		//判断是否有接口依赖
		if(caseManger.getDependStatus() != 0 && caseManger.getDepend() !=null){
			
			dependPramater = getDependPramater(caseManger.getDepend(), testLocationIp);
		}
		//4、获取请求参数
		if(!caseManger.getParameterType().equals("json")){
			if(dependPramater!= null){
				interfaceParameter = caseManger.getInterfaceParameter() +"&"+dependPramater ;
		
				
			}else{
				interfaceParameter = caseManger.getInterfaceParameter();
				
			}
		}else{
			
			interfaceParameter = caseManger.getInterfaceParameter();
			
		}
		
				
				
		//获取预期结果
		String expectResult = caseManger.getExpectResult();
		String parameterType = caseManger.getParameterType();
		//5、拼接接口地址
		String url=testLocationIp+interfaceAdress;
		
		/*这块代码注释，以后使用httpclient请求
		 *
		6、发送接口请求
		HttpRequsetUntil httpRequsetUntil = new HttpRequsetUntil();
		7、获取请求结果，并统计接口的耗时		
		String sendRequest = httpRequsetUntil.sendRequest(url, interfaceParameter, interfaceType);	
		System.out.println("请求结果：---"+sendRequest);		
		*/
		
		
		//包装入参转换成list集合
		//List<BasicNameValuePair> param = ExpectResultUntil.getParam(interfaceParameter);
		
		ClientHttp clientHttp = new ClientHttp();
		
		long starttime = System.currentTimeMillis();
		String sendRequest = clientHttp.sendRequest(url, interfaceParameter, header,interfaceType,parameterType);
		logger.debug("接口返回的数据："+sendRequest);
		long endtime = System.currentTimeMillis();
		String key=ExpectResultUntil.getExpectKey(expectResult);
		String val=ExpectResultUntil.getExpectValues(expectResult);
		
		float runTime = (float)(endtime-starttime)/1000;
		//8、校验实际结果与预期结果
		JsonUntil jsonUntil = new JsonUntil(key,val);
				//ExpectResultUntil expectResultUntil = new ExpectResultUntil();
				//获取返回的验证字段的值
		
		
		
		if(sendRequest == null){
			caseManger.setAuthStatus("FAIL");
			caseManger.setReason("<a style='color:red'>请求接口失败,请检查域名,地址,参数等格式是否正确</a>");
			
			try {
				runCaseMangerMapper.updateRunCase(caseManger);
				logger.debug("更新成功");
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.debug("更新失败");
				e.printStackTrace();
			}
						
		}
		
		
		
		
		String pString=jsonUntil.getParamValue(sendRequest);
			
		String authResult=pString.replaceAll("null","");
		
		caseManger.setAuthResult(authResult);
		
		if(authResult.contains(expectResult)){
			
			caseManger.setAuthStatus("PASS");
			caseManger.setReason(null);
			caseManger.setRunTime(runTime+"s");
			try {
				logger.debug("验证通过的接口的信息为："+caseManger.toString());
				runCaseMangerMapper.updateRunCase(caseManger);
				logger.debug("更新成功");
			} catch (Exception e) {
				logger.debug("更新失败");
				e.printStackTrace();
			}
			
		}else{
				caseManger.setAuthStatus("FAIL");
				caseManger.setReason("<a style='color:red'> 实际结果与预期结果不匹配：<br>预期结果："+expectResult+"<br>"+"实际结果："+authResult+"</a>");
				try {
					runCaseMangerMapper.updateRunCase(caseManger);
					logger.debug("更新成功");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.debug("更新失败");
					e.printStackTrace();
				}
			}
			
			logger.debug("查询成功");				
		
		
	}
	
	/**
	 * 根据用例的Id查询测试用例
	 * @param caseId
	 * @return
	 */
	public CaseManger selectCaseById(int caseId){
		
		CaseManger selectCaseById =null;
		try {
			selectCaseById = caseMapper.selectCaseById(caseId);
		} catch (Exception e) {
			logger.debug("根据用例的Id查询测试用例失败");
			e.printStackTrace();
		}
		return selectCaseById;
	}
	
	/**
	 * 查询测试用例通过的数量
	 * @return
	 */
	public Integer selectPassCase(){
		Integer selectPassCase = null;
		try {
			selectPassCase =runCaseMangerMapper.selectPassCase();
			logger.debug("查询到测试通过的用例数为："+selectPassCase);
			return selectPassCase;
		} catch (Exception e) {
			logger.debug("查询到测试通过的用例数时系统提示错误："+e);
			e.printStackTrace();
		}
		
		return selectPassCase;
	}
	
	/**
	 * 查询测试用例执行失败的数量
	 * @return
	 */
	public Integer searchFailCase(){
		Integer searchFailCase =null;
			try {
				searchFailCase = runCaseMangerMapper.searchFailCase();
				logger.debug("查询到测试失败的用例数为："+searchFailCase);
				return searchFailCase;
			} catch (Exception e) {
				logger.debug("查询到测试通过的用例数时系统提示错误："+e);
				e.printStackTrace();
			}
			return searchFailCase;
	}

	
/*	
	*//**
	 * ODC接口请求
	 * @param id
	 * @param testLocationIp
	 *//*
	
	public void runCaseBacth_ODC(int id, String testLocationIp,String header,String Type) {
		*//**
		 * 2、获取接口地址
		 * 3、获取请求方式
		 * 4、获取请求参数
		 * 5、拼接接口地址
		 * 6、发送接口请求
		 * 7、获取请求结果
		 * 8、校验实际结果与预期结果
		 *//*
		CaseManger caseManger = selectCaseById(id);
		//获取测试地址
		String interfaceAdress = caseManger.getInterfaceAdress();
		//3、获取请求方式
		String interfaceType = caseManger.getInterfaceType();
		//4、获取请求参数
		String interfaceParameter = caseManger.getInterfaceParameter();
		//获取预期结果
		String expectResult = caseManger.getExpectResult();
		//5、拼接接口地址
		String url=testLocationIp+interfaceAdress;
	
		
		//包装入参转换成list集合
		//List<BasicNameValuePair> param = ExpectResultUntil.getParam(interfaceParameter);
		ClientHttp clientHttp = new ClientHttp();
		
		long starttime = System.currentTimeMillis();
		String sendRequest = clientHttp.sendRequest(url, interfaceParameter, header,interfaceType,Type);
		logger.debug("接口返回的数据："+sendRequest);
		long endtime = System.currentTimeMillis();
		String key=ExpectResultUntil.getExpectKey(expectResult);
		String val=ExpectResultUntil.getExpectValues(expectResult);
		
		float runTime = (float)(endtime-starttime)/1000;
		//8、校验实际结果与预期结果
		JsonUntil jsonUntil = new JsonUntil(key,val);
				//ExpectResultUntil expectResultUntil = new ExpectResultUntil();
				//获取返回的验证字段的值
				String pString=jsonUntil.getParamValue(sendRequest);
				
				String authResult=pString.replaceAll("null","");
				
				caseManger.setAuthResult(authResult);
				
				if(authResult.contains(expectResult)){
					caseManger.setAuthStatus("PASS");
					caseManger.setRunTime(runTime+"s");
					try {
						logger.debug("验证通过的接口的信息为："+caseManger.toString());
						runCaseMangerMapper.updateRunCase(caseManger);
						logger.debug("更新成功");
						return;
					} catch (Exception e) {
						logger.debug("更新失败");
						e.printStackTrace();
					}
					
				}else{
					caseManger.setAuthStatus("FAIL");
					caseManger.setReason("实际结果与预期结果不匹配：<br>预期结果："+expectResult+"<br>"+"实际结果："+authResult);
					try {
						runCaseMangerMapper.updateRunCase(caseManger);
						logger.debug("更新成功");
						return;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						logger.debug("更新失败");
						e.printStackTrace();
					}
				}
				
				logger.debug("查询成功");
				
		
		
	}*/
	
	/**
	 * 获取依赖接口的字段，返回依赖的key和value
	 * @param depend
	 * @param testLocationIp
	 * @param header
	 * @return
	 */
	public  String  getDependPramater(String depend,String testLocationIp){
		
		String paramValue = null;
		//获取依赖的字段
		Map<String, String> dependId = ConvertUntil.getDependId(depend);
		
		Set<String> keySet = dependId.keySet();
		
		//获取key
		for (String keys : keySet) {
			
			String vals = dependId.get(keys);//获取值
			Integer key = Integer.valueOf(keys);//字符串转换成
			
			
			CaseManger caseManger = selectCaseById(key);//获取依赖的接口信息
			
			//获取测试地址
			String interfaceAdress = caseManger.getInterfaceAdress();
			//3、获取请求方式
			String interfaceType = caseManger.getInterfaceType();
			//4、获取请求参数
			String interfaceParameter = null;
			//获取参数类型
			String parameterType = caseManger.getParameterType();
			String header = caseManger.getHeader();
			//拼接测试地址
			String url=testLocationIp+interfaceAdress;
			
			if(caseManger.getDependStatus() !=0 && caseManger.getDepend() != null){
				
				String dependPramater = getDependPramater(caseManger.getDepend(),testLocationIp);
				
				interfaceParameter = interfaceParameter+"&"+dependPramater;
			}else{
				
				interfaceParameter=caseManger.getInterfaceParameter();
			}
			ClientHttp clientHttp = new ClientHttp();
			
			String sendRequest = clientHttp.sendRequest(url, interfaceParameter, header,interfaceType,parameterType);
			logger.debug("接口返回的数据："+sendRequest);
			
			//获取依赖接口的每个key
			String[] split = vals.split("\\,");
			
			for (String s : split) {
				
				JsonUntil jsonUntil = new JsonUntil(s);
				
				paramValue= jsonUntil.getParamValue(sendRequest)+paramValue;//获取参数值
				
			}
			
			
		}
		
		
		return paramValue.replaceAll(";", "&").replaceAll("null", "");
	}

	
	public void runCaseBacthHeader(int id, String testLocationIp,String header) {
		/**
		 * 2、获取接口地址
		 * 3、获取请求方式
		 * 4、获取请求参数
		 * 5、拼接接口地址
		 * 6、发送接口请求
		 * 7、获取请求结果
		 * 8、校验实际结果与预期结果
		 */
		CaseManger caseManger = selectCaseById(id);
		//获取界都地址
		String interfaceAdress = caseManger.getInterfaceAdress();
		//3、获取请求方式
		String interfaceType = caseManger.getInterfaceType();
		
		String dependPramater = null ;//依赖字段
		
		String interfaceParameter =null;
		//判断是否有接口依赖
		if(caseManger.getDependStatus() != 0 && caseManger.getDepend() !=null){
			
			dependPramater = getDependPramaterHeader(caseManger.getDepend(), testLocationIp, header);
		}
		//4、获取请求参数
		if(!caseManger.getParameterType().equals("json")){
			if(dependPramater!= null){
				interfaceParameter = caseManger.getInterfaceParameter() +"&"+dependPramater ;	
				
			}else{
				interfaceParameter = caseManger.getInterfaceParameter();
				
			}
		}else{
			
			interfaceParameter = caseManger.getInterfaceParameter();
		}
		
				
				
		//获取预期结果
		String expectResult = caseManger.getExpectResult();
		String parameterType = caseManger.getParameterType();
		//5、拼接接口地址
		String url=testLocationIp+interfaceAdress;
		ClientHttp clientHttp = new ClientHttp();
		
		long starttime = System.currentTimeMillis();
		String sendRequest = clientHttp.sendRequest(url, interfaceParameter, header,interfaceType,parameterType);
		logger.debug("接口返回的数据："+sendRequest);
		long endtime = System.currentTimeMillis();
		String key=ExpectResultUntil.getExpectKey(expectResult);
		String val=ExpectResultUntil.getExpectValues(expectResult);
		
		float runTime = (float)(endtime-starttime)/1000;
		//8、校验实际结果与预期结果
		JsonUntil jsonUntil = new JsonUntil(key,val);
				//ExpectResultUntil expectResultUntil = new ExpectResultUntil();
				//获取返回的验证字段的值
		
		
		
		if(sendRequest == null){
			caseManger.setAuthStatus("FAIL");
			caseManger.setReason("请求接口失败,请检查域名,地址,参数等格式是否正确");
			
			try {
				runCaseMangerMapper.updateRunCase(caseManger);
				logger.debug("更新成功");
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.debug("更新失败");
				e.printStackTrace();
			}
						
		}
		
		
		
		
		String pString=jsonUntil.getParamValue(sendRequest);
			
		String authResult=pString.replaceAll("null","");
		
		caseManger.setAuthResult(authResult);
		
		if(authResult.contains(expectResult)){
			
			caseManger.setAuthStatus("PASS");
			caseManger.setReason(null);
			caseManger.setRunTime(runTime+"s");
			try {
				logger.debug("验证通过的接口的信息为："+caseManger.toString());
				runCaseMangerMapper.updateRunCase(caseManger);
				logger.debug("更新成功");
			} catch (Exception e) {
				logger.debug("更新失败");
				e.printStackTrace();
			}
			
		}else{
				caseManger.setAuthStatus("FAIL");
				caseManger.setReason("实际结果与预期结果不匹配：<br>预期结果："+expectResult+"<br>"+"实际结果："+authResult);
				try {
					runCaseMangerMapper.updateRunCase(caseManger);
					logger.debug("更新成功");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.debug("更新失败");
					e.printStackTrace();
				}
			}
			
			logger.debug("查询成功");				
		
		
	}
	
	
public  String  getDependPramaterHeader(String depend,String testLocationIp,String header){
		
		String paramValue = null;
		//获取依赖的字段
		Map<String, String> dependId = ConvertUntil.getDependId(depend);
		
		Set<String> keySet = dependId.keySet();
		
		//获取key
		for (String keys : keySet) {
			
			String vals = dependId.get(keys);//获取值
			Integer key = Integer.valueOf(keys);//字符串转换成
			
			
			CaseManger caseManger = selectCaseById(key);//获取依赖的接口信息
			
			//获取测试地址
			String interfaceAdress = caseManger.getInterfaceAdress();
			//3、获取请求方式
			String interfaceType = caseManger.getInterfaceType();
			//4、获取请求参数
			String interfaceParameter = null;
			//获取参数类型
			String parameterType = caseManger.getParameterType();
			//拼接测试地址
			String url=testLocationIp+interfaceAdress;
			
			if(caseManger.getDependStatus() !=0 && caseManger.getDepend() != null){
				
				String dependPramater = getDependPramater(caseManger.getDepend(),testLocationIp);
				
				interfaceParameter = interfaceParameter+"&"+dependPramater;
			}else{
				
				interfaceParameter=caseManger.getInterfaceParameter();
			}
			ClientHttp clientHttp = new ClientHttp();
			
			String sendRequest = clientHttp.sendRequest(url, interfaceParameter, header,interfaceType,parameterType);
			logger.debug("接口返回的数据："+sendRequest);
			
			//获取依赖接口的每个key
			String[] split = vals.split("\\,");
			
			for (String s : split) {
				
				JsonUntil jsonUntil = new JsonUntil(s);
				
				paramValue= jsonUntil.getParamValue(sendRequest)+paramValue;//获取参数值
				
			}
			
			
		}
		
		
		return paramValue.replaceAll(";", "&").replaceAll("null", "");
	}

}
