package cn.qlk.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.qlk.test.bean.HeaderManger;
import cn.qlk.test.dao.HeaderMangerMapper;

@Service
public class HeaderMangerService {

	@Autowired
	private HeaderMangerMapper headerMangerMapper;
	private final static Logger  logger = LoggerFactory.getLogger(HeaderMangerService.class);
	
	/**
	 * 查询所有的头信息
	 * @return
	 */
	public List<HeaderManger>  getHeaders (){
		
		 List<HeaderManger> headers= null;
		
		try {
			headers = headerMangerMapper.getHeaders();
			logger.debug("查询请求头的数据成功"+headers); 
			return headers;
		} catch (Exception e) {

			e.printStackTrace();
			logger.debug("批量查询没有查询到数据"+headers); 
			return headers;
		}
		
		
	}
	
	/**
	 * 添加请求头
	 * @param headerManger
	 * @return
	 */
	public Integer insertHeader(HeaderManger headerManger){
		Integer insertHeader=0;
		
		try {
			insertHeader = headerMangerMapper.insertHeader(headerManger);
			logger.debug("插入请求头数据成功，成功数量："+insertHeader);
			return insertHeader;
		} catch (Exception e) {	
			logger.debug("插入请求头数据失败,原因"+e);
			e.printStackTrace();
			return insertHeader;
		}
		

	}
	/**
	 * 修改请求头信息
	 * @param headerManger
	 * @return
	 */
	public Integer updateHeader(HeaderManger headerManger){
		Integer updateHeader=0;
		
		try {
			updateHeader = headerMangerMapper.updateHeader(headerManger);
			logger.debug("更新请求头成功，数量："+updateHeader);
			logger.debug("更新后的数据"+headerManger);
			return updateHeader;
		} catch (Exception e) {
			logger.debug("更新请求头失败,原因："+e);
			e.printStackTrace();
			return updateHeader;
		}
	}
	
	/**
	 * 删除请求数据
	 * @param id
	 * @return
	 */
	public Integer delHeader(int id){
		Integer deleteHeader=0;
		try {
			deleteHeader = headerMangerMapper.deleteHeader(id);
			logger.debug("删除请求头数据成功，删除的ID为："+id);
			return deleteHeader;
		} catch (Exception e) {
			logger.debug("删除请求头数据失败，原因"+e);
			e.printStackTrace();
			return deleteHeader;
		}
		
	}
	
	public List<HeaderManger> selectNameHeader(HeaderManger headerManger){
		List<HeaderManger> selectNameHeaders =null;
		try {
			selectNameHeaders = headerMangerMapper.selectNameHeaders(headerManger);
			logger.debug("按照请求头的名称为："+headerManger.getHeaderName()+"查询到的数据"+selectNameHeaders);
			return selectNameHeaders;
		} catch (Exception e) {
			logger.debug("按照请求头的名称为："+headerManger.getHeaderName()+"查询失败，原因："+e);
			e.printStackTrace();
			return selectNameHeaders;
		}
	}
}
