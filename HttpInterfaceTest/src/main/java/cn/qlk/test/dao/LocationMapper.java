package cn.qlk.test.dao;

import java.util.List;

import cn.qlk.test.bean.Location;

public interface LocationMapper {
	
	
	/**
	 * ������Ե�ַ����Ϣ
	 * @param location
	 * @throws Exception
	 */
	public int insert(Location location) throws Exception;
	
	/**
	 * 
	 * @param location
	 * @return ���Ե�ַ��Ϣ��List���
	 * @throws Exception
	 */
	public List<Location> searchLocation(Location location ) throws Exception;
	
	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteLocation(int id) throws Exception;
	
	/**
	 * 修改测试地址
	 * @param location
	 * @return
	 * @throws Exception
	 */
	public int updateLocation(Location location) throws Exception;
	
	
}
