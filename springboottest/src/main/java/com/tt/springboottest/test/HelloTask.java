package com.tt.springboottest.test;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloTask {
	public static void main(String[] args) throws SchedulerException {
		StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		// 通过schedulerFactory获取一个调度器
		Scheduler scheduler = stdSchedulerFactory.getScheduler();

		// 创建jobDetail实例，绑定Job实现类
		// 指明job的名称，所在组的名称，以及绑定job类
		JobDetail job = JobBuilder.newJob(TestJob.class).withIdentity("myJob1", "jobGroup1").usingJobData("key1", "1")
				.build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(4)).startNow().build();

		scheduler.scheduleJob(job, trigger);

		// 启动调度器
		scheduler.start();
	}

}
