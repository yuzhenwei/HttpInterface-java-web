package cn.qlk.test.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.qlk.test.bean.ScheduleJob;
import cn.qlk.test.dao.QuartzJobMapper;

@Service
public class QuartzService {
	private static final Logger logger = LoggerFactory.getLogger(QuartzService.class);

	@Autowired
	private QuartzJobMapper jobMapper;
	
	
	
	public List<ScheduleJob> getJobs(){
		
		return jobMapper.getJobs();
	}
	   
	/***
	 * 更改定时任务的信息
	 * @param job
	 */
	public void updateJob(ScheduleJob job){
		
		int upadeJob = jobMapper.upadeJob(job);
		if(upadeJob!=0){
			logger.debug("更改job数据成功");
			
		}else{
			
			
			logger.debug("更改job数据失败");
		}
		
	}
	/**
	 * 获取一条定时任务
	 * @param JobName
	 * @return
	 */
	public ScheduleJob getJob(String JobName){
		
		return jobMapper.getJob(JobName);
	}

	public int  updateStatus(int  jobStatus ){
		
		return jobMapper.updateStatus(jobStatus);
	}
	
	}  
	
	

