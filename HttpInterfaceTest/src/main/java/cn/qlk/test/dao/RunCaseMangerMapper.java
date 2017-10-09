package cn.qlk.test.dao;

import cn.qlk.test.bean.CaseManger;

public interface RunCaseMangerMapper {

	/**
	 * 更新用例的结果authResult,authStatus,runTime，reason
	 * @param caseManger
	 * @throws Exception
	 */
	public void updateRunCase(CaseManger caseManger) throws Exception;
	
	/**
	 * 统计测试通过的测试用例
	 * @return
	 * @throws Exception
	 */
	public Integer selectPassCase() throws Exception;
	
	
	/**
	 * 统计Fail的测试用例
	 * @return
	 * @throws Exception
	 */
	public Integer searchFailCase() throws Exception; 
}
