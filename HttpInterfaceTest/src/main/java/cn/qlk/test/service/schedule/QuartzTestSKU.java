package cn.qlk.test.service.schedule;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qlk.test.bean.CaseManger;
import cn.qlk.test.service.CaseMangerService;
import cn.qlk.test.service.RunCaseMangeService;
import cn.qlk.test.until.SendMailUntil;

@Service
public class QuartzTestSKU implements Job{
	
	@Autowired
	private RunCaseMangeService runCaseMangerService;
	
	@Autowired
	private CaseMangerService caseMangerService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		//列出所有的基础数据平台的接口用例
	
		//"*****@qq.com", "标题", "内容", "smtp", "smtp.qq.com", "发送人名", "端口号", "用户名", "密码"
		
		final String subject = "自动发送邮件---接口测试报告";
		
		URL url = this.getClass().getClassLoader().getResource("/MailContent.jsp");
		File file = new File(url.getPath());	        
		String content = SendMailUntil.getContent(file);
		
		ResourceBundle resource = ResourceBundle.getBundle("mail");
		String to = resource.getString("to");
		String copyto = resource.getString("copyto");
		String smtp = resource.getString("smtp");
		String host = resource.getString("host");
		String sendName = resource.getString("sendName");
		String sendPort = resource.getString("sendPort");
		String userName = resource.getString("userName");
		String userPwd = resource.getString("userPwd");
		//执行测试用例
		List<CaseManger> selectCase = caseMangerService.selectCase("SKU");
		for (CaseManger caseManger : selectCase) {
			runCaseMangerService.runCaseBacth(caseManger.getCaseId(), "http://");		   		
		}
		SendMailUntil.send(to, copyto,subject, content, smtp, host,sendName,sendPort,userName,userPwd);
		
	
		
	}
	
	

}
