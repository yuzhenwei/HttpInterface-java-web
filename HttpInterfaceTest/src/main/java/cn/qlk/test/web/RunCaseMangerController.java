package cn.qlk.test.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qlk.test.bean.CaseManger;
import cn.qlk.test.bean.Location;
import cn.qlk.test.service.RunCaseMangeService;

@Controller
public class RunCaseMangerController {
	
	private static final Logger logger = LoggerFactory.getLogger(RunCaseMangerController.class);

	@Autowired
	private RunCaseMangeService runCaseMangeService;
	/**
	 * 执行单个测试用例
	 * @param caseManger
	 * @param location
	 */	
	/*@RequestMapping("/runCase")
	@ResponseBody
	public Map<String, String> runCase (CaseManger caseManger,Location location,String header,String Type){
		HashMap<String, String> map = new HashMap<String,String>();
		try {
			runCaseMangeService.runCaseOne(caseManger, location,header,Type);
			map.put("status", "ok");
		} catch (Exception e) {
			
			logger.debug("失败");
		}
		
		return map;
	}*/
	
	/**
	 * 
	 * @param caseId
	 * @param testLocationIp
	 * 批量执行测试用例
	 */
	@RequestMapping("/runMuchCase")
	@ResponseBody
	public Map<String, String> runMuchCase(int[] caseId,String testLocationIp,String header){
		
		Integer id=null;
		//遍历选中的测试用例
		for(int i=0;i<caseId.length;i++){
			id =caseId[i];
			runCaseMangeService.runCaseBacth(id, testLocationIp,header);
			
		}
		
		
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("pass", runCaseMangeService.selectPassCase().toString());
		map.put("fail", runCaseMangeService.searchFailCase().toString());
		map.put("status", "ok");
		
		return map;
	}
	

}
