package com.tt.springboottest.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {
	public TestJob() {
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(context.getJobDetail().getKey());
		System.out.println(context.getJobDetail().getJobDataMap().get("key1"));
		System.err.println("Hello!  HelloJob is executing.");
	}
}
