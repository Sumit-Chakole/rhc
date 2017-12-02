package com.ts.rhc.framework;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware{
	
	private static ApplicationContext mAppContext;

	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		mAppContext= appContext;
	}
	
	public static Object getBean(String beanName){
		return mAppContext.getBean(beanName);
	}

}
