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
		if (header !=null) {
			

			for(int i=0;i<caseId.length;i++){
				id =caseId[i];
				runCaseMangeService.runCaseBacthHeader(id, testLocationIp, header);
				
			}
			
		} else {
			
			for(int i=0;i<caseId.length;i++){
				id =caseId[i];
				runCaseMangeService.runCaseBacth(id, testLocationIp);
				
			}
			

		}
		
		
		
		
		
		
		
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("pass", runCaseMangeService.selectPassCase().toString());
		map.put("fail", runCaseMangeService.searchFailCase().toString());
		map.put("status", "ok");
		
		return map;
	}
	

}
