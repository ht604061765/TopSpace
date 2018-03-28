/**
 * @author Hunter
 * TopSpaceMaven
 * 2018-1-1 下午10:09:25
 * TODO //
 */
package com.topspace.core.system.task.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topspace.core.framework.controller.BaseController;
import com.topspace.core.system.task.bo.TaskBo;
import com.topspace.core.system.task.service.TaskService;
import com.topspace.core.utils.PKCreator;

@Controller
@RequestMapping("/Task.do")
public class TaskController extends BaseController{
	
	@Resource(name = "TaskService")
	TaskService taskService; 

	//现在需要手动插入定时任务数据  http://localhost:8090/Task.do?m=addTask
	@RequestMapping(params = "m=addTask")
	@ResponseBody
	public void addTask(){
		String id = PKCreator.getPrimaryKey();
		String code = "refreshBackgroundJob";
		String name = "刷新背景任务";
		String rule = "0 0/10 8-23 * * ?";
		String imp = "com.topspace.customer.taskjob.refreshBackgroundJob";
		int isOpen = 1;
		
		int b=0;
		TaskBo taskBo = new TaskBo();
		taskBo.setId(id);
		taskBo.setCode(code);
		taskBo.setName(name);
		taskBo.setRule(rule);
		taskBo.setImp(imp);
		taskBo.setIsOpen(isOpen);
		b = taskService.insert(taskBo);
		
		if(b>0)
			System.out.println("成功插入了" + b +"条定时任务！");
		else
			System.out.println("很不幸，定时器数据新增失败！");
	}
}


