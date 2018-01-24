package cn.qlk.test.bean;

import java.io.Serializable;

public class ScheduleJob  implements Serializable{ 
	/**
	 * 定时任务
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	 /** 任务id */

	/**任务名称*/
    private String jobName;
      
    /** 任务分组 */
    private String jobGroup;
    
    /**触发器名*/
    private String triggerName;
    /**触发器组名*/
	private String triggerGroupName;
      
   

	/** 任务状态 0禁用 1启用 2暂停*/
    private int jobStatus;
      
    /** 任务运行时间表达式 */
    private String cronExpression;
      
    /** 任务描述 */
    private String desc;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public int getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(int jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	 public String getTriggerName() {
			return triggerName;
		}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	
	
	
	public String getTriggerGroupName() {
		return triggerGroupName;
	}

	public void setTriggerGroupName(String triggerGroupName) {
		this.triggerGroupName = triggerGroupName;
	}

	public ScheduleJob() {
        super();
    }
 
    public ScheduleJob(String jobId, String jobName, String jobGroup,
            int jobStatus, String cronExpression, String desc) {
        super();
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.jobStatus = jobStatus;
        this.cronExpression = cronExpression;
        this.desc = desc;
    }
}
