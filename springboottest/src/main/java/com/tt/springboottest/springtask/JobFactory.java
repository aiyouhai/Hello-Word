package com.tt.springboottest.springtask;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/*
 * 解决在job定时任务中使用@autowair注入接口时为空的问题，
 * AutowireCapableBeanFactory为quartz的类；直接注入即可
 * */
@Component
public class JobFactory extends AdaptableJobFactory {
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;

	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object createJobInstance = super.createJobInstance(bundle);
		autowireCapableBeanFactory.autowireBean(createJobInstance);
		return createJobInstance;
	}

}
