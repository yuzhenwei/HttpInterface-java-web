package cn.qlk.test.service.schedule;

import java.util.Date;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.qlk.test.bean.ScheduleJob;
import cn.qlk.test.dao.QuartzJobMapper;


@Service
public class ScheduleJobs {
	
	@Autowired
	private QuartzJobMapper jobMapper;
	
    
    /***
     * 创建定时任务的名称
     * @param jobName
     */
	public JobDetail addJob(String jobName,Class<? extends Job> className){
		
			ScheduleJob job = jobMapper.getJob(jobName);
	      //3.创建JobDetail
	      JobDetail jb = JobBuilder.newJob(className)
	              .withIdentity(jobName, job.getJobGroup()) //job 的name和group
	              .build();

	      return jb;

	      
	}
	/***
	 * 创建触发器
	 * @param jobName
	 * @return
	 */

	public Trigger addTrigger(String jobName){
		ScheduleJob job = jobMapper.getJob(jobName);
		  //任务运行的时间，SimpleSchedle类型触发器有效
	      long time=  System.currentTimeMillis() + 3*1000L; //3秒后启动任务
	      Date statTime = new Date(time);
			//4.创建Trigger
	        //使用SimpleScheduleBuilder或者CronScheduleBuilder
	      Trigger t = TriggerBuilder.newTrigger()
	                .withIdentity(job.getTriggerName(), job.getTriggerGroupName())
	                //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
	                .startAt(statTime)  //默认当前时间启动
	                .withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression())) //两秒执行一次
	                .build();
	      
	      return t;
	}
	
	
}
