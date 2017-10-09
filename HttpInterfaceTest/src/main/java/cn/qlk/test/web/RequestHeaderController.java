package cn.qlk.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.qlk.test.bean.HeaderManger;
import cn.qlk.test.service.HeaderMangerService;

@Controller
@RequestMapping("/header")
public class RequestHeaderController {
	
	
	@Autowired
	private HeaderMangerService headerMangerService;
	
	@RequestMapping("/header")
	public ModelAndView getHeader(){
		
		ModelAndView andView = new ModelAndView();
		
		andView.setViewName("headerPage/headerPage");
		
		return andView;
	}
	
	
	@RequestMapping("/getHeaders")
	@ResponseBody
	public List<HeaderManger> getHeaders(){
		
		List<HeaderManger> headers = headerMangerService.getHeaders();
		
		return headers;
		
	}
	
	@RequestMapping("/insertHeader")
	@ResponseBody
	public Map<String, String> insertHeader(HeaderManger headerManger){
		
		Integer insertHeader = headerMangerService.insertHeader(headerManger);
		Map<String , String> map = new HashMap<String , String>();
		if(insertHeader != 0){
			map.put("status", "ok");
			return map;
		}
		map.put("status", "no");
		return map;
	}

	@RequestMapping("/updateHeader")
	@ResponseBody
	public Map<String, String> updateHeader(HeaderManger headerManger){
		Integer updateHeader = headerMangerService.updateHeader(headerManger);
		Map<String , String> map = new HashMap<String , String>();
		if(updateHeader != 0){
			map.put("status", "ok");
			return map;
		}
		map.put("status", "no");
		return map;
		
		
	}
	
	@RequestMapping("/delHeader")
	@ResponseBody
	public Map<String, String> delHeader(int id){
		Integer delHeader = headerMangerService.delHeader(id);
		Map<String , String> map = new HashMap<String , String>();
		if(delHeader != 0){
			map.put("status", "ok");
			return map;
		}
		map.put("status", "no");
		return map;
		
		
	}
	
	@RequestMapping("/selNameHeader")
	@ResponseBody
	public List<HeaderManger> selectNameHeader(HeaderManger headerManger){
		List<HeaderManger> selectNameHeader = headerMangerService.selectNameHeader(headerManger);
        return selectNameHeader;	
	}
}
