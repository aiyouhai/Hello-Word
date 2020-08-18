package com.tt.springboottest.springtask;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SecondJob {
	public void task() {
		System.out.println(Thread.currentThread().getName() + "第二个任务");
	}
}
