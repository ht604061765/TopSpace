/**
 * @author Hunter
 * TopSpaceMaven
 * 2018-1-2 下午3:38:54
 * TODO //
 */
package com.topspace.core.system.task;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskListener implements ServletContextListener{
	private static final Logger LOG = LoggerFactory.getLogger(TaskListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		try {
			TaskManager.startJob();
			LOG.info("[定时任务]定时任务启动成功！");
		} catch (Exception e) {
			LOG.error("[定时任务]定时任务启动失败！");
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		try {
			TaskManager.shutdown();
		} catch (Exception e) {
			LOG.error("[定时任务]定时任务销毁失败！",e);
		}
		LOG.info("[定时任务]定时任务销毁成功！");
		
	}

}


