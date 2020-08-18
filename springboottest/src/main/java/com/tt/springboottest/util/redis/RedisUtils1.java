package com.tt.springboottest.util.redis;

import org.springframework.stereotype.Component;

@Component
public class RedisUtils1 {

	/*
	 * private static JedisCluster jedisCluster;
	 * 
	 * @Autowired public RedisUtils1(JedisCluster jedisCluster) {
	 * RedisUtils1.jedisCluster = jedisCluster; } // 静态初使化当前类 // public static
	 * RedisUtils1 redisUtils1;
	 * 
	 * // 注解@PostConstruct，这样方法就会在Bean初始化之后被Spring容器执行
	 * 
	 * @PostConstruct public void init() { redisUtils1 = this;
	 * redisUtils1.jedisCluster = this.jedisCluster; }
	 * 
	 * // private static Jedis jedis;
	 * 
	 * static { jedis = jedisCluster.getResource(); }
	 * 
	 * 
	 * public static String set(String key, String value) { // Jedis jedis =
	 * redisUtils1.jedisCluster.getResource(); String result = jedisCluster.set(key,
	 * value);
	 * 
	 * return result; }
	 * 
	 * public static String get(String key) { // Jedis jedis =
	 * redisUtils1.jedisCluster.getResource(); String result =
	 * jedisCluster.get(key);
	 * 
	 * return result; }
	 * 
	 * public static Boolean exists(String key) { // Jedis jedis = //
	 * redisUtils1.jedisCluster.getResource(); Boolean result =
	 * jedisCluster.exists(key);
	 * 
	 * return result; }
	 */
	/*
	 * public static Long expire(String key, int seconds) { // Jedis jedis =
	 * redisUtils1.jedisCluster.getResource(); Long result =
	 * redisUtils1.jedisCluster.expire(key, seconds);
	 * 
	 * return result; }
	 * 
	 * // 以秒为单位，返回给定 key 的剩余生存时间(TTL, time to live)。 public static Long ttl(String
	 * key)
	 * 
	 * { // Jedis jedis = redisUtils1.jedisCluster.getResource(); Long result =
	 * redisUtils1.jedisCluster.ttl(key);
	 * 
	 * return result; }
	 * 
	 * // 对数字的表面值加1 public static Long incr(String key) { // Jedis jedis =
	 * redisUtils1.jedisCluster.getResource(); Long result =
	 * redisUtils1.jedisCluster.incr(key);
	 * 
	 * return result; }
	 * 
	 * public static Long hset(String key, String field, String value) { // Jedis
	 * jedis = redisUtils1.jedisCluster.getResource(); Long result =
	 * redisUtils1.jedisCluster.hset(key, field, value);
	 * 
	 * return result; }
	 * 
	 * public static String hget(String key, String field) { // Jedis jedis =
	 * redisUtils1.jedisCluster.getResource(); String result =
	 * redisUtils1.jedisCluster.hget(key, field);
	 * 
	 * return result; }
	 * 
	 * public static Long hdel(String key, String... field) { // Jedis jedis =
	 * redisUtils1.jedisCluster.getResource(); Long result =
	 * redisUtils1.jedisCluster.hdel(key, field);
	 * 
	 * return result; }
	 * 
	 * public static Boolean hexists(String key, String field) { // Jedis jedis =
	 * redisUtils1.jedisCluster.getResource(); Boolean result =
	 * redisUtils1.jedisCluster.hexists(key, field);
	 * 
	 * return result; }
	 * 
	 * public static List<String> hvals(String key) { // Jedis jedis =
	 * redisUtils1.jedisCluster.getResource(); List<String> result =
	 * redisUtils1.jedisCluster.hvals(key);
	 * 
	 * return result; }
	 * 
	 * public static Long del(String key) { // Jedis jedis =
	 * redisUtils1.jedisCluster.getResource(); Long result =
	 * redisUtils1.jedisCluster.del(key);
	 * 
	 * return result; }
	 */

}
