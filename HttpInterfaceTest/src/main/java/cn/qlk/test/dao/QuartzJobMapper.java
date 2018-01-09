package cn.qlk.test.dao;

import java.util.List;

import cn.qlk.test.bean.ScheduleJob;

public interface QuartzJobMapper {
	
	public  List<ScheduleJob> getJobs();
	
	public ScheduleJob get(int id);
	
	
	public ScheduleJob getJob(String JobName);
	
	
	public int upadeJob(ScheduleJob job);
	
	public int updateStatus(int jobStatus);
	
}
