package cn.qlk.test.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qlk.test.bean.CaseManger;
import cn.qlk.test.dao.CaseMangerMapper;


@Service
public class CaseMangerService {
	
	
	@Autowired
	private CaseMangerMapper caseMangerMapper;

	
	private final static Logger  logger = LoggerFactory.getLogger(CaseMangerService.class);
	
	//添加测试用例
	public void addCase(CaseManger casemanger){
		
		try {
			if(casemanger.getHeaderStatus() ==0){
				casemanger.setHeader(null);
				
			}
			
			int insertCase = caseMangerMapper.insertCase(casemanger);
			if(insertCase !=0){
				
				logger.debug("添加测试用例成功");
			}
		} catch (Exception e) {
			logger.debug("添加测试用例失败");
			e.printStackTrace();
		}
		
	}
	
	//批量查询测试用例
	public List<CaseManger> selectCase(String region){
		List<CaseManger> selectCase =null;
		try {
			selectCase = caseMangerMapper.selectCase(region);
			return selectCase;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return selectCase;

		
	}
	
	//批量查询测试用例并导出
	/**
	 * 
	 * @param region
	 * @param interfaceName
	 * @return
	 */
	public List<CaseManger> selectCaseExcel(String region, String interfaceName){
		List<CaseManger> selectCaseExcel =null;
		CaseManger caseManger = new CaseManger();
		caseManger.setRegion(region);
		caseManger.setInterfaceName(interfaceName);
		try {
			
			selectCaseExcel = caseMangerMapper.searchInterface(caseManger);
			return selectCaseExcel;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return selectCaseExcel;

		
	}
	
	//删除测试用例
	public void deleteCase(int caseId){
		
		try {
			int deleteCase = caseMangerMapper.deleteCase(caseId);
			if(deleteCase !=0){
				logger.debug("删除测试用例成功");
			}
		} catch (Exception e) {
			logger.debug("删除测试用例失败");
			e.printStackTrace();
		}
	}

	//根据接口名称查询测试用例
	public List<CaseManger> searchInterface(CaseManger caseManger){
		List<CaseManger> searchInterface =null;
		try {
			searchInterface = caseMangerMapper.searchInterface(caseManger);
			logger.debug("根据接口名称查询成功");
			return searchInterface;
		} catch (Exception e) {
			logger.debug("根据接口名称查询失败");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchInterface;
		
	}

	//更新测试用例
	public Integer updateCase(CaseManger casemanger) {
		int updateCase = 0;
		try {
			
			if(casemanger.getHeaderStatus() ==0){
				casemanger.setHeader(null);
				
			}
			if(casemanger.getDependStatus()==0){
				
				casemanger.setDepend(null);
			}
			if(casemanger.getInterfaceParameter()!=null){
				
				casemanger.setInterfaceParameter(casemanger.getInterfaceParameter().replaceAll(" ", ""));
				
			}
			if(casemanger.getInterfaceAdress()!=null){
				casemanger.setInterfaceAdress(casemanger.getInterfaceAdress().replaceAll(" ", ""));
				
			}
			updateCase = caseMangerMapper.updateCase(casemanger);
			if(updateCase>0){
				return updateCase;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateCase;
	}
	
	/**
	 * 删除测试用例的结果集
	 */
	public void deleteCaseRunResult(CaseManger caseManger){
		
		try {
			caseMangerMapper.deleteCaseRunResult(caseManger);
			logger.debug("删除测试用例结果集成功");
		} catch (Exception e) {
			logger.debug("删除测试用例结果集失败");
			e.printStackTrace();
		}
	}	
	
	/**
	 * 查询含有结果的测试用例
	 * @return List<CaseManger>
	 */
	public List<CaseManger> searchRunCaseResult(String textName,String textValue,CaseManger caseManger){
		
		List<CaseManger> searchRunCaseResult =null;
		
		try {
			//判断是按照接口名称查询，还是按照执行结果查询
			if(textValue!=null){			
				if(textName.equals("interfaceName")){
					
					caseManger.setInterfaceName(textValue);
				}else{
					caseManger.setAuthStatus(textValue);			
				}
			}
				searchRunCaseResult = caseMangerMapper.searchRunCaseResult(caseManger);
				logger.debug("查询到含有测试结果集的用例为："+searchRunCaseResult.size()+"条");
				return searchRunCaseResult;
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("查询到含有测试结果集时系统报错错误内容：");
			e.printStackTrace();
		}
		
		return searchRunCaseResult;
	}
	
	
	public List<CaseManger> selectCaseByPage(int start,int end,String pN){
		List<CaseManger> selectCaseByPage =null;
		try {
			selectCaseByPage = caseMangerMapper.selectCaseByPage(start, end,pN);
			return selectCaseByPage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectCaseByPage;
		
	}
}
