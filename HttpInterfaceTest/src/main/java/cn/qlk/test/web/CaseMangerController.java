package cn.qlk.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.qlk.test.bean.CaseManger;
import cn.qlk.test.service.CaseMangerService;

@Controller
@RequestMapping("/case")
public class CaseMangerController {

	@Autowired
	private CaseMangerService CaseMangerService;
	/**
	 * 
	 * @return返回测试管理页面
	 */
	@RequestMapping("/caseManger")
	public ModelAndView caseManger(HttpSession session, String region){

		/*String attribute = (String) session.getAttribute("pN");
		if(attribute!=null){
			session.removeAttribute("pN");
		}
		session.setAttribute("pN", region);*/
		ModelAndView andView = new ModelAndView();
		
		if(region.equals("OFC")){
			
			andView.setViewName("caseManger/caseManger");
		}else if (region.equals("SKU")) {
			
			andView.setViewName("sku/skuCase");
		}else if (region.equals("Doctor")) {
			andView.setViewName("doctor/doctorPage");
		}else if (region.equals("patient")) {
			andView.setViewName("patient/patientPage");
		}
		
			
		return andView;
	}
	
	
	
	@RequestMapping("/odcCase")
	public ModelAndView odcCase(HttpSession session, String region){

		String attribute = (String) session.getAttribute("pN");
		if(attribute!=null){
			session.removeAttribute("pN");
		}
		session.setAttribute("pN", region);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("odcPage/odcCase");	
		return andView;
	}
	
	
	/**
	 * 
	 * @return 执行结果页面
	 */
	@RequestMapping("/caseResult")
	public ModelAndView caseResult(String region){
		
		
		
		ModelAndView andView = new ModelAndView();

		if(region.equals("OFC")){
			
			andView.setViewName("caseResult/caseResult");
		}else if (region.equals("SKU")) {
			
			andView.setViewName("sku/skuCaseResult");
			
		}else if (region.equals("Doctor")) {
			andView.setViewName("doctor/doctorCaseResult");
			
		}else if (region.equals("patient")) {
			
		andView.setViewName("patient/patientCaseResult");
	}
					
		return andView;
	}
	
	/**
	 * 
	 * @return ODC的执行页面
	 */
	@RequestMapping("/odcCaseResult")
	public ModelAndView odcCaseResult(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("odcPage/odcCaseResult");	
		return andView;
	}
	
	/**
	 * 添加测试用例
	 * @param casemanger
	 * @return
	 */
	@RequestMapping("/addCase")
	public @ResponseBody Map<String,String> addCase( CaseManger casemanger){	
		Map<String, String> map= new HashMap<String, String>();
			CaseMangerService.addCase(casemanger);
			map.put("status", "ok");
			return map;
		
	}
	@RequestMapping("/updateCase")
	@ResponseBody
	public Map<String,String> updateCase(CaseManger casemanger){
		Map<String, String> map= new HashMap<String, String>();
		Integer updateCase = CaseMangerService.updateCase(casemanger);
		if(updateCase!=0){
			map.put("status", "ok");
			return map;
		}
		map.put("status", "fail");
		return map;
		
	}
	
	/**
	 *批量查询测试用例
	 * @return ����list���
	 */
	@RequestMapping("/selectCase")
	@ResponseBody
	public Map<String, Object> selectCase( int page, int rows,String region){
		
		/*List<CaseManger> selectCase = CaseMangerService.selectCase();
		
		//System.out.println(selectCase);
		
		
		return selectCase;*/
		
		System.out.println(page+"和"+ rows);
		Map<String, Object> map= new HashMap<String, Object>();
		//开始行数的
		int start = (page-1)* rows;
		//结束的行数
		int end = page * rows;
		
		List<CaseManger> selectCaseByPage = CaseMangerService.selectCaseByPage(start, end,region);
		
		int total =CaseMangerService.selectCase(region).size();
		
		
		map.put("total", total);
		map.put("rows", selectCaseByPage);
		return map;
		
		
	
		
	}
	
	/**
	 * 
	 * @param caseId
	 * @return
	 * 删除单条测试用例
	 */
	@RequestMapping("/deleteCase")
	@ResponseBody
	public Map<String,String> deleteCase(int caseId){
		
		Map<String, String> map = new HashMap<String, String>();
		CaseMangerService.deleteCase(caseId);
		map.put("status", "ok");
		return map;
		
	}
	
	/**
	 * 
	 * @param caseManger
	 * @return
	 * //根据接口名称查询测试用例
	 */
	@RequestMapping("/searchInterface")
	@ResponseBody
	public List<CaseManger> searchInterface(CaseManger caseManger){
		
		List<CaseManger> searchInterface = CaseMangerService.searchInterface(caseManger);
		return searchInterface;
		
	}
	
	/**
	 * @return
	 * 删除测试用例的结果集
	 */
	@RequestMapping("/deleteCaseRunResult")
	@ResponseBody
	public Map<String,String> deleteCaseRunResult(CaseManger caseManger){
		
		Map<String, String> map = new HashMap<String, String>();
		try {
			CaseMangerService.deleteCaseRunResult(caseManger);
			map.put("status", "ok");
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		return map;
		
	}
	
	/**
	 * 执行测试报告页面，只显示已执行的测试用例	 
	 * @param textName 
	 * @param textValue
	 * @return List<CaseManger>
	 */
	@RequestMapping("/searchRunCaseResult")
	@ResponseBody
	public List<CaseManger> searchRunCaseResult(String textName,String textValue,CaseManger caseManger){
		
		
		List<CaseManger> searchRunCaseResult = CaseMangerService.searchRunCaseResult(textName,textValue,caseManger);
		
		return searchRunCaseResult;
	}
	
	
}
