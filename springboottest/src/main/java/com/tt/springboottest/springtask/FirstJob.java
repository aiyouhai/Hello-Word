package com.tt.springboottest.springtask;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.tt.springboottest.file.FileService;

@Component
@EnableScheduling
@DisallowConcurrentExecution // 保证上一次任务执行完毕再执行下一任务
public class FirstJob implements Job {
	@Autowired
	private FileService fileService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		this.myJobBusinessMethod();

	}

	public void myJobBusinessMethod() {
		System.out.println(fileService);
		System.out.println("开始执行了");
	}

}
