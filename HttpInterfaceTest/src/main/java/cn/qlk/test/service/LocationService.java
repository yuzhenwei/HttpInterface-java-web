package cn.qlk.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qlk.test.bean.Location;
import cn.qlk.test.dao.LocationMapper;


@Service
public class LocationService {
	private static final Logger logger = LoggerFactory.getLogger(LocationService.class);

	@Autowired
	private LocationMapper  locationMapper;
	
	public void insert (Location location){
		
		try {
			if(location.getLocationName()!=null && location.getAddress()!=null){
				
				location.setAddress(location.getAddress().replaceAll(" ", ""));
				
				int insert = locationMapper.insert(location);
				if(insert!=0){
					logger.debug("插入环境地址成功");
			
					
				}
				
			}
		
		} catch (Exception e) {
			logger.debug("插入环境地址失败");
			e.printStackTrace();
		}
	}
	
	//��ѯ���Ի������
	public List<Location> searchLocation(Location location){
		
		List<Location> searchLocation = null;	
		try {
			searchLocation= locationMapper.searchLocation(location);
			if(searchLocation !=null){
				
				logger.debug("批量查询测试地址成功");
				return searchLocation;
				
			}
		} catch (Exception e) {
			
			logger.debug("批量查询测试地址失败");
			e.printStackTrace();
		}
		
		return searchLocation;
	}
	
	public void deleteLocation(int id){
		try {
			int deleteLocation = locationMapper.deleteLocation(id);
			
			if(deleteLocation !=0){
				logger.debug("删除测试地址成功");

			}
		} catch (Exception e) {
			logger.debug("删除测试地址失败");
			e.printStackTrace();
		}
	}
	 

	public Integer updateLocation(Location location){
		Integer updateLocation = null;
		try {
			if(location.getAddress()!=null){
				
				location.setAddress(location.getAddress().replaceAll(" ", ""));
			}
			
			updateLocation = locationMapper.updateLocation(location);
			logger.debug("更新测试地址成功：更新后的数据名称为："+location.getLocationName()+"地址为："+location.getAddress());
			return updateLocation;
		} catch (Exception e) {
			logger.debug("更新测试地址失败，原因："+e);
			e.printStackTrace();
		}
		return updateLocation;
	}
	
}
