package cn.qlk.test.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/report")
public class TestReportController {
	
	@RequestMapping("/SKU")
	public ModelAndView ReportSKU(HttpSession session){
		
		session.setAttribute("user", "bjtest");
		ModelAndView andView = new ModelAndView();
		andView.setViewName("Report/report_html");
		
		
		return andView;
	}
	
	@RequestMapping("/ODC")
	public ModelAndView ReportODC(HttpSession session){
		
		session.setAttribute("user", "bjtest");
		ModelAndView andView = new ModelAndView();
		andView.setViewName("Report/report_ODC");
		
		
		return andView;
	}
	
	@RequestMapping("/OFC")
	public ModelAndView ReportOFC(HttpSession session){
		
		session.setAttribute("user", "bjtest");
		ModelAndView andView = new ModelAndView();
		andView.setViewName("Report/report_OFC");
		
		
		return andView;
	}
	

}
