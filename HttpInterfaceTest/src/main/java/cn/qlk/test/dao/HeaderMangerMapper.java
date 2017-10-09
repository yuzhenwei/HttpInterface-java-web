package cn.qlk.test.dao;

import java.util.List;

import cn.qlk.test.bean.HeaderManger;

public interface HeaderMangerMapper {
	
	
	/**
	 * 查询所有的请求信息
	 * @return
	 * @throws Exception
	 */
	public List<HeaderManger> getHeaders() throws Exception;
	
	
	/**
	 * 根据请求头名称查询
	 * @return
	 * @throws Exception
	 */
	public List<HeaderManger> selectNameHeaders(HeaderManger headerManger) throws Exception;
	
	/**
	 * 插入请求头信息
	 * @param headerManger
	 * @return
	 * @throws Exception
	 */
	public Integer insertHeader(HeaderManger headerManger) throws Exception;
	
	/**
	 * 根据ID修改请求头的信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer updateHeader(HeaderManger headerManger) throws Exception;
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer deleteHeader(int id) throws Exception;
	
}
