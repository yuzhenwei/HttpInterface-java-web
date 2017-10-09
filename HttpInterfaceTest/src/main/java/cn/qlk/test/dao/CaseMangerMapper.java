package cn.qlk.test.dao;

import java.util.List;

import cn.qlk.test.bean.CaseManger;

/**
 *@Title CaseMangerMapper.java 
 *@time 2017年6月8日 下午3:41:56 
 *@author daidaihua 
 *@version 1.0
 */
public interface CaseMangerMapper {
	
	
	/**
	 * 添加测试用例
	 * @param caseManger
	 * @return
	 * @throws Exception
	 */
	public int insertCase(CaseManger caseManger) throws Exception;
	
	
	/**
	 * 批量查询测试用例
	 * @return
	 * @throws Exception
	 */
	public List<CaseManger> selectCase(String region) throws Exception;
	
	
	/**
	 * 根据用例的序号删除测试用例
	 * @param caseId
	 * @return
	 * @throws Exception
	 */
	public int deleteCase(int caseId) throws Exception;
	
	
	
	
	/**
	 * 根据接口名称查询测试用例
	 * @param caseManger
	 * @return
	 * @throws Exception
	 */
	public List<CaseManger> searchInterface(CaseManger caseManger ) throws Exception;

	
	
	/**
	 * 修改测试用例
	 * @param casemanger
	 * @return
	 * @throws Exception
	 */
	public int updateCase(CaseManger casemanger) throws Exception;
	
	
	/**
	 * @param caseId
	 * @return 
	 * @throws Exception
	 * 单条查询 根据用例的Id查询测试用例
	 */
	public CaseManger selectCaseById(int caseId) throws Exception;
	
	/**
	 * 删除测试用例的结果集
	 * @throws Exception
	 */
	public void deleteCaseRunResult(CaseManger caseManger) throws Exception;
	
	/**
	 * 查询含有的执行状态的测试用例
	 * @return List<CaseManger>
	 * @throws Exception
	 */
	public List<CaseManger> searchRunCaseResult(CaseManger caseManger) throws Exception;
	
	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public List<CaseManger> selectCaseByPage(int start,int end,String pN) throws Exception;

}
