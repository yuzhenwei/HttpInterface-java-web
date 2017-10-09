package cn.qlk.test.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.qlk.test.bean.User;
import cn.qlk.test.service.UserService;



@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(){
		
		ModelAndView andView = new ModelAndView();
		andView.setViewName("login/login");
		
		
		return andView;
	}
	
	
	@RequestMapping("/loginOn")
	public String loginOn(HttpSession session,String userName,String passWord){
		
	
		//session.setAttribute("user", userName);
		/*ModelAndView andView = new ModelAndView();
		andView.setViewName("FirstPage/firstPage");*/
		
		User user = userService.getUser(userName);
		String userAt = (String) session.getAttribute("user");
		String pwAt = (String) session.getAttribute("pw");
		
		if(user!=null){
			
			if(userAt !=null){
				if(userName.equals(userAt)){
					if(passWord.equals(pwAt)){
						
						return "redirect:/firstPage.action";
					}
				}
			}else if(user.getUserName().equals(userName) && user.getPassWord().equals(passWord)){
				
					session.setAttribute("user", userName);
					session.setAttribute("pw", passWord);
					
					return "redirect:/firstPage.action";
			
			}
			
		}
		
		return "redirect:/login.action";
		
		
	}
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		
		//*session.removeAttribute("user");
		
		session.invalidate();
		ModelAndView andView = new ModelAndView();
		andView.setViewName("login/login");
	
		return "redirect:login.action";
		
		/*return andView;*/
		
	}
	
}
