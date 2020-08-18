package com.tt.springboottest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class Redisconfig extends CachingConfigurerSupport {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.jedis.pool.max-idle}")
	private int maxIdle;

	@Value("${spring.redis.jedis.pool.max-wait}")
	private long maxWaitMillis;

	@Value("${spring.redis.jedis.pool.min-idle}")
	private int minIdle;

	@Value("${spring.redis.jedis.pool.max-active}")
	private long maxActiveMillis;
	@Value("${spring.redis.password}")
	private String password;
	/*
	 * @Value("${spring.redis.cluster.nodes}") private String nodes;
	 * 
	 * @Value("${spring.redis.cluster.command-timeout}") private int commandTimeout;
	 */

	@Bean
	public JedisPool jedisPool() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setMinIdle(minIdle);

		// 是否启用pool的jmx管理功能, 默认true
		jedisPoolConfig.setJmxEnabled(true);
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
		return jedisPool;
	}

	/*
	 * @Bean(name = "jedisCluster") public JedisCluster getJedisCluster() { String[]
	 * serverArray = nodes.split(","); Set<HostAndPort> nodes = new HashSet<>();
	 * 
	 * for (String ipPort : serverArray) { String[] ipPortPair = ipPort.split(":");
	 * nodes.add(new HostAndPort(ipPortPair[0].trim(),
	 * Integer.valueOf(ipPortPair[1].trim())));
	 * 
	 * }
	 * 
	 * return new JedisCluster(nodes, commandTimeout); }
	 */
}
