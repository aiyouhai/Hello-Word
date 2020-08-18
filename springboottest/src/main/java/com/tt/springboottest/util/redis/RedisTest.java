package com.tt.springboottest.util.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
	private static final String REDIS_KEY = "REDSI_KEY";

	public static byte[] getByte(String str) {
		String byteString = REDIS_KEY + str;
		return byteString.getBytes();
	}

	public static void main(String[] args) {
		// 使用jedis对象连接redids

		Jedis jedis = new Jedis("127.0.0.1", 6379);

		// 使用JedisPoll获取jedis对象连接redis
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(30);// 最大闲置个数
		poolConfig.setMinIdle(10);// 最小闲置个数
		poolConfig.setMaxTotal(50);// 最大连接数

		JedisPool jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
		// 从连接池中获取jedis对象
		Jedis jedis1 = jedisPool.getResource();
		// 操作redis
		// 关闭资源
		jedis.close();
		jedisPool.close();

	}

}
