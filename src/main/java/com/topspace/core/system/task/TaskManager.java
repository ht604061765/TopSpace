/**
 * @author Hunter
 * TopSpaceMaven
 * 2018-1-2 上午10:18:49
 * TODO //
 */
package com.topspace.core.system.task;


import java.util.List;

import javax.annotation.Resource;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topspace.core.framework.controller.BaseController;
import com.topspace.core.framework.utils.QueryParam;
import com.topspace.core.framework.utils.SpringBeanUtil;
import com.topspace.core.system.task.bo.TaskBo;
import com.topspace.core.system.task.service.TaskService;
import com.topspace.customer.login.service.LoginService;
import com.topspace.test.controlle.testController;
import com.topspace.test.service.testService;

public class TaskManager{
	
	private static final Logger LOG = LoggerFactory.getLogger(TaskManager.class);
	
	static SchedulerFactory sf = new StdSchedulerFactory();
	static Scheduler sched;
	private static String TaskGroup = "TOPSPACE";
	
	static {
		try {
			sched = sf.getScheduler();
		} catch (SchedulerException e) {
			LOG.error("======[定时任务]创建Scheduler实例异常:" + e.getMessage());
		}
	}
	
	public synchronized static void shutdown() throws Exception {
		sched.shutdown();
	}
	
	public synchronized static void startJob() throws Exception {
		sched.clear();
		
		List<TaskBo> ls = getTaskDef();
		for (int i = 0; i < ls.size(); i++) {
			TaskBo task = (TaskBo) ls.get(i);
			int isopen = task.getIsOpen();
			if (isopen == 1) {
				Class jobcls = Class.forName(task.getImp()); 	//找到任务class
			JobDetail job = JobBuilder							//把任务class转换成job
						.newJob(jobcls)
						.withIdentity(task.getCode(), TaskGroup)
						.build(); 								
			
			CronTrigger trigger = TriggerBuilder				//定义触发规则
					.newTrigger()
					.withIdentity(task.getCode() + "_Trigger",TaskGroup)
					.withSchedule(CronScheduleBuilder.cronSchedule(task.getRule()))
					.build();
			
			sched.scheduleJob(job, trigger); 					//把规则和任务转换成一个调度
			}
		}
		sched.start();
	}
	
	public static List<TaskBo> getTaskDef()  {
		TaskService ts = (TaskService) SpringBeanUtil
				.getBean("TaskService");
		
		return ts.findByList(TaskBo.class, QueryParam.build());
	}

}


