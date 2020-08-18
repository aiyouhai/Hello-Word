package com.tt.springboottest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = SpringBootTestApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {

	@Cacheable(value = "my-redis-cache1", keyGenerator = "keyGenerator")
	public String getRedisString(String param1, String param2) {
		return param1 + ":" + param2;
	}

	@Test
	public void get1() {
		String redisString = getRedisString("lili", "女");
		System.out.println(redisString);
	}

}
