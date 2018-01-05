package com.topspace.core.framework.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.topspace.core.framework.misc.SystemConstant;
import com.topspace.core.framework.utils.SpringBeanUtil;
import com.topspace.core.utils.StringUtil;



public class ApplicationStart extends ContextLoaderListener {

    private List<ApplicationInterface> interfaces = new ArrayList<ApplicationInterface>();

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // 1.设置系统绝对路径
        String path = event.getServletContext().getRealPath("/");
        SystemConstant.setRealPath(path);

        // 2.设置上下文。
        String ctxPath = event.getServletContext().getContextPath();
        SystemConstant.setContextPath(ctxPath);

        // 3.初始化系统常量.

        super.contextInitialized(event);
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
        SpringBeanUtil.setApplicationContext(ctx);

        // 装载ApplicationInterace的实例到List中。
        String beans = event.getServletContext().getInitParameter("ApplicationInterfaceInst");
        loadApplicationInterfaces(beans);
        // 处理业务初始化操作。
        for(ApplicationInterface inter : interfaces){
            inter.start();
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        // 处理业务操作。
        for(ApplicationInterface inter : interfaces){
            inter.shutdown();
        }
        super.contextDestroyed(event);
    }

    private void loadApplicationInterfaces(String beanNames) {
        String[] arrayNames = StringUtil.split(beanNames, ",");
        for(String beanName : arrayNames){

            ApplicationInterface inter = (ApplicationInterface) SpringBeanUtil.getBean(beanName);
            interfaces.add(inter);
        }
    }
    

}
