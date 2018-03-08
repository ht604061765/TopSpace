/**
 * @author Hunter
 * TopSpaceMaven
 * 2018-1-2 下午9:31:36
 * TODO //
 */
package com.topspace.customer.taskjob;

import java.io.Console;
import java.io.File;
import java.io.InputStream;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.topspace.core.utils.URLUtil;

public class refreshBackgroundJob implements Job{

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("【更新背景图】开始");
		// TODO Auto-generated method stub
		String url = "https://www.dujin.org/sys/bing/1920.php";
        String fileName = "Login_backGround.png";
        File file = new File("E:/03workspace/TopSpace/src/main/webapp/static_resources/images/", fileName);

        InputStream inputStream = URLUtil.getInputStreamByGet(url);
         URLUtil.saveData(inputStream, file);
        System.out.println("【更新背景图】完毕");
	}

}


