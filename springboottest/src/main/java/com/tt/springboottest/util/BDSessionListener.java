package com.tt.springboottest.util;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * 
 * @author admin SessionListener shiro的session监听器
 */
public class BDSessionListener implements SessionListener {

	private final AtomicInteger sessionCount = new AtomicInteger(0);

	// 回话创建时触发
	@Override
	public void onStart(Session session) {
		sessionCount.incrementAndGet();
		System.out.println("会话创建：" + session.getId());
	}

	// 回话停止或过期时触发
	@Override
	public void onStop(Session session) {
		sessionCount.decrementAndGet();
		System.out.println("会话停止：" + session.getId());
	}

	// 回话过期时触发
	@Override
	public void onExpiration(Session session) {
		sessionCount.decrementAndGet();
		System.out.println("会话创建：" + session.getId());
	}

	public int getSessionCount() {
		return sessionCount.get();
	}

}
