package cn.qlk.test.web;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.qlk.test.bean.CaseManger;
import cn.qlk.test.service.CaseMangerService;
import cn.qlk.test.until.ExportExcelUntil;
import cn.qlk.test.until.POIUntil;


@Controller
@RequestMapping("/LeadToExcel")
public class CaseMangerExcel {
	
	@Autowired
	private CaseMangerService CaseMangerService;

	@RequestMapping("/LeadInUser")
	@ResponseBody
	public Map<String, String> leadInExcel(HttpServletResponse response,@RequestParam(value="excel")CommonsMultipartFile excel) throws Exception{
		
		
		List<String[]> readExcel = POIUntil.readExcel(excel);
		
		CaseManger caseManger = new CaseManger();
		Map<String, String>  map = new HashMap<String, String>();
		for(int i = 0;i<readExcel.size();i++){
			String[] caseList = readExcel.get(i);
			caseManger.setInterfaceName(caseList[0]);
			caseManger.setInterfaceAdress(caseList[1]);
			caseManger.setRegion(caseList[2]);
			caseManger.setInterfaceType(caseList[3]);
			caseManger.setInterfaceParameter(caseList[4]);
			caseManger.setParameterType(caseList[5]);
			caseManger.setExpectResult(caseList[6]);//预期结果
			caseManger.setInterfaceDese(caseList[7]);//接口描述
			if(caseList[8].contains("是")){
				
				caseManger.setDependStatus(1);
				
			}else{
				
				caseManger.setDependStatus(0);
			}

			if(readExcel.size() == 9){
				
				caseManger.setDepend(caseList[9]);
				
			}else{
				caseManger.setDepend(null);
				
			}
			//依赖关系
			CaseMangerService.addCase(caseManger);
		}

		map.put("success", "ok");

		return map;
           
	}
	

	@RequestMapping(value="/outExcel")
	@ResponseBody
	public void outExcel(String region,String interfaceName,HttpServletResponse out) throws FileNotFoundException{
		String title="批量数据导出";
		Map<String, String> map = new HashMap<>();
		
		List<CaseManger> selectCase = CaseMangerService.selectCaseExcel(region,interfaceName);
		System.out.println(selectCase.toString());
		ExportExcelUntil.exportUserExcel(selectCase, out, title);
		
		
	}
	
}
