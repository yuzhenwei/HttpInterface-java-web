package cn.qlk.test.web;

import java.util.Date;
import java.util.List;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.qlk.test.bean.ScheduleJob;
import cn.qlk.test.service.QuartzService;
import cn.qlk.test.service.schedule.QuartzTestSKU;
import cn.qlk.test.service.schedule.QuartzTestODC;
import cn.qlk.test.service.schedule.QuartzTestOFC;
import cn.qlk.test.service.schedule.ScheduleJobs;

@Controller
@RequestMapping("/Quartz")
public class QuartzController {
	
	private final static Logger  logger = LoggerFactory.getLogger(QuartzController.class);
	@Autowired
	private QuartzService quartzService;
	
	@Autowired
	private ScheduleJobs skuSchedule;
	
	@Autowired
	private SchedulerFactoryBean sf;

    private static final String SKU_SCHEDULE="SKU_SCHEDULE";
    private static final String ODC_SCHEDULE="ODC_SCHEDULE";
    private static final String OFC_SCHEDULE="OFC_SCHEDULE";
    
    
	@RequestMapping("/startAll")
	public void est() throws SchedulerException{
	  
	 
      //2.从工厂中获取调度器实例
      Scheduler scheduler = sf.getScheduler();
      	
      //5.注册任务和定时器
      scheduler.scheduleJob(skuSchedule.addJob(SKU_SCHEDULE,QuartzTestSKU.class), skuSchedule.addTrigger(SKU_SCHEDULE));
      scheduler.scheduleJob(skuSchedule.addJob(ODC_SCHEDULE,QuartzTestODC.class), skuSchedule.addTrigger(ODC_SCHEDULE));
      scheduler.scheduleJob(skuSchedule.addJob(OFC_SCHEDULE,QuartzTestOFC.class), skuSchedule.addTrigger(OFC_SCHEDULE));

      //6.启动 调度器
      scheduler.start();
      
     
		quartzService.updateStatus(1);
      logger.info("启动时间 ： " + new Date());
  }
	
	
	
	/**
	 * 停止定时任务
	 * @param triggerName
	 * @param triggerGroupName
	 * @throws SchedulerException
	 */
	@RequestMapping("/stop")
	public void StopQuartz(String triggerName, String triggerGroupName,String jobName) throws SchedulerException{      
	      //从工厂中获取调度器实例
	      Scheduler scheduler = sf.getScheduler();
		TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroupName);
		scheduler.pauseTrigger(triggerKey);
		//更改数据库的状态
		ScheduleJob job = quartzService.getJob(jobName);
		job.setJobStatus(0);//0已停止
		logger.debug("停止服务："+jobName+"....");
		quartzService.updateJob(job);
		logger.debug(jobName+"已停止成功");
	}
	
	
	/**
	 * 恢复指定的任务
	 * @throws SchedulerException
	 */
	@RequestMapping("/restart")
	public void RestartQuartz(String jobName,String jobGroup ) throws SchedulerException{
		 
	      JobKey jobKey = new JobKey(jobName, jobGroup);
	      //2.从工厂中获取调度器实例
	      Scheduler scheduler = sf.getScheduler();
		scheduler.resumeJob(jobKey);
		ScheduleJob job = quartzService.getJob(jobName);
		logger.debug("恢复服务中："+jobName+"...");
		job.setJobStatus(1);//0启动
		quartzService.updateJob(job);
		logger.debug(jobName+"已恢复成功");
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/ReturnPage")
	public ModelAndView ReturnPage(){
		
		ModelAndView andView = new ModelAndView();
		andView.setViewName("QuartzPage/quartzPage");	
		return andView;
		
	}
	

	/**
	 * 获取定时任务列表
	 * @return
	 */
	@RequestMapping(value="/JobsList")
	@ResponseBody
	public List<ScheduleJob> getJobs(){
		
		return quartzService.getJobs();
			
	}

}
