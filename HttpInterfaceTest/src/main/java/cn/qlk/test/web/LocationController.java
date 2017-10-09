package cn.qlk.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.qlk.test.bean.Location;
import cn.qlk.test.service.LocationService;




@Controller
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	/**
	 * 
	 * @return 测试环境首页
	 */
	@RequestMapping("/location")
	public ModelAndView location() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("location/location");
		
		return modelAndView;
		
		
	}
	/**
	 *添加测试环境
	 * @param location
	 */
	@RequestMapping("/insertlocation")
	public @ResponseBody Map<String,String> insertLocation(Location location) {
		Map<String,	String> map = new HashMap<String, String>();
		locationService.insert(location);
		map.put("status", "ok");
		return map;
		
	}
	//查询测试环境信息
	@RequestMapping("/searchLocation")
	public @ResponseBody List<Location>  searchLocation(Location location){
		
		List<Location> searchLocation = locationService.searchLocation(location);
		
		return searchLocation;
		
	}
	
	//删除测试环境信息
	@RequestMapping("/deleteLocation")
	@ResponseBody
	public  Map<String,	String> deleteLocation(int id){
		Map<String,	String> map = new HashMap<String, String>();
		locationService.deleteLocation(id);
		map.put("status", "ok");
		return map;
	}
	
	
	@RequestMapping("/updateLocation")
	public @ResponseBody Map<String,String> updateLocation(Location location) {
		Map<String,	String> map = new HashMap<String, String>();
		Integer updateLocation =null;
		if(location.getId() !=0){
			updateLocation = locationService.updateLocation(location);
			
		}
		if(updateLocation !=null){
			
			map.put("status", "ok");
		}
		
		return map;
		
	}

}
