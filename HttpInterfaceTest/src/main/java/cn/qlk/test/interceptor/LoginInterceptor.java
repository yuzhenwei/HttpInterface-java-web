package cn.qlk.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	// 在执行handler之前来执行
	// 用于用户的认证校验
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 获取请求链接的url
		String requestURI = request.getRequestURI();
		//获取请的session
		HttpSession session = request.getSession();
		String attribute = (String) session.getAttribute("user");

		if (requestURI.indexOf("login.action") > 0 || requestURI.indexOf("loginOn.action") > 0 ||
				requestURI.indexOf("loginOut.action")>0) {

			return true;
		}
		
		if (attribute != null) {

			return true;
		} else {

			response.sendRedirect(request.getContextPath() + "/login.action");
			return false;
		}

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	// 值执行handler之前来执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception arg3) throws Exception {
		// TODO Auto-generated method stub

	}

}
