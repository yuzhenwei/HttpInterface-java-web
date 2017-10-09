package cn.qlk.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

	@RequestMapping("/firstPage")
	public ModelAndView firstPage(){
		
		ModelAndView andView = new ModelAndView();
		andView.setViewName("FirstPage/firstPage");
		return andView;
	}
	
	
}
