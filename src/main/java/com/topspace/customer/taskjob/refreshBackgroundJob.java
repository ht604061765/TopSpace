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
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.topspace.core.framework.misc.SystemConstant;
import com.topspace.core.utils.HttpRequestUtil;
import com.topspace.core.utils.JsonUtils;
import com.topspace.core.utils.URLUtil;

public class refreshBackgroundJob implements Job{
	
	private final static String backGroundFile = SystemConstant.getRealPath() + "static_resources/images/Login_backGround.png";
	private final static String frontUrl = "http://cn.bing.com";

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("【更新背景图】开始");
		Map<String, Object> loadImageMsg = HttpRequestUtil.httpsRequest("http://cn.bing.com/HPImageArchive.aspx?idx=0&n=1&format=js", "POST", "");
		List<Map<String, Object>> imageList = (List<Map<String, Object>>) loadImageMsg.get("images");
		String backUrl = (String) imageList.get(0).get("url");

		String imageUrl = frontUrl + backUrl;
		
        File file = new File(backGroundFile);

        InputStream inputStream = URLUtil.getInputStreamByGet(imageUrl);
        URLUtil.saveData(inputStream, file);
        System.out.println("【更新背景图】完毕");
	}

}


