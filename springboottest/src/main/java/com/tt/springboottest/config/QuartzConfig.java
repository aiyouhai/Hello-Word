package com.tt.springboottest.config;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.tt.springboottest.springtask.FinancialCreditTask;
import com.tt.springboottest.springtask.JobFactory;
import com.tt.springboottest.springtask.PublicCreditTask;

/***
 * Trigger触发器的创建有两种方式： 1：SimpleTrigger--设置简单的时间规则 2：CronTrigger--设置复杂的时间规则
 *
 */
@Configuration
@PropertySource(value = { "classpath:quartztime.properties" })
public class QuartzConfig {
	@Autowired
	private JobFactory jobFactory;
	@Value(value = "${timing-task.cron}")
	private String timeCron;

	@Bean(name = "firstJobDetail")
	public MethodInvokingJobDetailFactoryBean firstJobDetail(PublicCreditTask firstJob) {
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		// 是否并发执行
		jobDetail.setConcurrent(false);
		// 为需要执行的实体类对应的对象
		jobDetail.setTargetObject(firstJob);
		// 需要执行的方法
		jobDetail.setTargetMethod("task");

		return jobDetail;

	}

//配置触发器1
	@Bean(name = "firstTrigger")
	public CronTriggerFactoryBean firstTrigger(JobDetail firstJobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
		trigger.setJobDetail(firstJobDetail);
		// cron表达式
		trigger.setCronExpression(timeCron);
		return trigger;

	}

//配置定时任务2
	@Bean(name = "secondJobDetail")
	public MethodInvokingJobDetailFactoryBean secondJobDetail(FinancialCreditTask secondJob) {
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		// 是否并发执行
		jobDetail.setConcurrent(false);
		// 为需要执行的实体类对应的对象
		jobDetail.setTargetObject(secondJob);
		// 需要执行的方法
		jobDetail.setTargetMethod("task");
		return jobDetail;
	}

	// 配置触发器2
	@Bean(name = "secondTrigger")
	public CronTriggerFactoryBean secondTrigger(JobDetail secondJobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
		trigger.setJobDetail(secondJobDetail);
		// cron表达式
		trigger.setCronExpression(timeCron);
		return trigger;
	}

	// 配置Scheduler
	@Bean(name = "scheduler1")
	public SchedulerFactoryBean schedulerFactory(Trigger firstTrigger, Trigger secondTrigger) {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		// 会用自己的jobFactory解决在job定时任务中使用@autowair注入接口时为空的问题，
		bean.setJobFactory(jobFactory);
		// 延时启动，应用启动1秒后
		// bean.setStartupDelay(1);
		// 注册触发器
		bean.setTriggers(firstTrigger, secondTrigger);
		return bean;
	}
}
