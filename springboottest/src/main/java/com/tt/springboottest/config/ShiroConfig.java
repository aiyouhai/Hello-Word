package com.tt.springboottest.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tt.springboottest.util.BDSessionListener;
import com.tt.springboottest.util.RedisManager;
import com.tt.springboottest.util.RedisSessionDAO;

@Configuration
public class ShiroConfig {
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.password}")
	private String password;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.timeout}")
	private int timeout;
	/*
	 * @Value("${spring.cache.type}") private String cacheType;
	 */

	@Value("${server.session-timeout}")
	private int tomcatTimeout;

	/**
	 * 通过shiroFilter 拦截请求的url
	 * 
	 * @param securityManager
	 * @return ShiroFilter
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/index/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index/index");

		// 未授权界面;
		// shiroFilterFactoryBean.setUnauthorizedUrl("/index/login");
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/index/login", "anon");
		filterChainDefinitionMap.put("/image/getimage", "anon");
		filterChainDefinitionMap.put("/hello/*", "anon");
		filterChainDefinitionMap.put("/cat/*", "anon");
		filterChainDefinitionMap.put("/financial/**", "anon");
		filterChainDefinitionMap.put("/sysuser/**", "anon");
		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("index/logout", "logout");
		// <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		// <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/**", "anon");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 密码凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
	 * 
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5"); // 散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(2); // 散列的次数，比如散列两次，相当于
		return hashedCredentialsMatcher;
	}

	// 将自己的验证方式加入容器
	@Bean
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}

	// 将SecurityManager交给spring
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		securityManager.setSessionManager(sessionManager()); // 设置sessionManager
		// securityManager.setRememberMeManager(rememberMeManager()); // 配置记住我
		// securityManager.setCacheManager(redisCacheManager());// 配置缓存
		return securityManager;
	}

	/**
	 * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * 配置会话ID生成器
	 * 
	 * @return
	 */
	@Bean
	public JavaUuidSessionIdGenerator sessionIdGenerator() {
		return new JavaUuidSessionIdGenerator();
	}

	/**
	 * 用于单点登录 配置shiro redisManager
	 * 
	 * @return
	 */
	@Bean
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost(host);
		redisManager.setPort(port);
		redisManager.setExpire(1800);// 配置缓存过期时间
		redisManager.setTimeout(1800);
		redisManager.setPassword(password);
		return redisManager;
	}

	/**
	 * RedisSessionDAO shiro sessionDao层的实现 通过redis 使用的是shiro-redis开源插件
	 * 自定义的sessiondao实现session的crud
	 */

	@Bean
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		redisSessionDAO.setRedisManager(redisManager());
		redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
		// Session ID生成器
		return redisSessionDAO;
	}

	/**
	 * SessionDAO的作用是为Session提供CRUD并进行持久化的一个shiro组件 MemorySessionDAO 直接在内存中进行会话维护
	 * EnterpriseCacheSessionDAO
	 * 提供了缓存功能的会话维护，默认情况下使用MapCache实现，内部使用ConcurrentHashMap保存缓存的会话。
	 * 
	 * 默认的sessiondao实现session的crud
	 */
	@Bean
	public SessionDAO sessionDAO() {
		return redisSessionDAO();
	}

	/**
	 * shiro session的管理
	 */
	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setGlobalSessionTimeout(tomcatTimeout * 10000);
		sessionManager.setSessionDAO(sessionDAO());
		sessionManager.setSessionIdCookie(rememberMeCookie()); // 设置JSESSIONID
		sessionManager.setDeleteInvalidSessions(true); // 删除无效session
		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
		listeners.add(new BDSessionListener());
		sessionManager.setSessionListeners(listeners);
		return sessionManager;
	}

	/**
	 * shiro缓存管理器; 需要添加到securityManager中
	 * 
	 * 使用shiro-redis默认的rediscachemanager
	 */

	/*
	 * @Bean public RedisCacheManager redisCacheManager() { RedisCacheManager
	 * redisCacheManager = new RedisCacheManager();
	 * redisCacheManager.setRedisManager(redisManager()); // redis中针对不同用户缓存
	 * redisCacheManager.setPrincipalIdFieldName("username"); // 用户权限信息缓存时间
	 * redisCacheManager.setExpire(200000); return redisCacheManager; }
	 */

	/**
	 * 自定义rediscachemanager
	 * 
	 * @return
	 */
	/*
	 * @Bean public RedisCacheManager redisCacheManager() { RedisCacheManager
	 * redisCacheManager = new RedisCacheManager();
	 * redisCacheManager.setRedisManager(redisManager()); return redisCacheManager;
	 * }
	 */

	/**
	 * 配置Shiro生命周期处理器
	 * 
	 * @return
	 */
	/*
	 * @Bean(name = "lifecycleBeanPostProcessor") public LifecycleBeanPostProcessor
	 * lifecycleBeanPostProcessor() { return new LifecycleBeanPostProcessor(); }
	 */

	/**
	 * 配置保存sessionId的cookie 注意：这里的cookie 不是上面的记住我 cookie 记住我需要一个cookie session管理
	 * 也需要自己的cookie 默认为: JSESSIONID 问题: 与SERVLET容器名冲突,重新定义为sid
	 * 
	 * @return
	 */
	@Bean
	public SimpleCookie rememberMeCookie() {
		SimpleCookie cookie = new SimpleCookie("SHAREJSESSIONID"); // cookie的name,对应的默认是
		cookie.setHttpOnly(true);
		cookie.setPath("/"); // path为 / 用于多个系统共享JSESSIONID
		return cookie;
	}

	/**
	 * cookie管理对象;记住我功能,rememberMe管理器
	 * 
	 * @return
	 */
	/*
	 * @Bean public CookieRememberMeManager rememberMeManager() {
	 * CookieRememberMeManager cookieRememberMeManager = new
	 * CookieRememberMeManager();
	 * cookieRememberMeManager.setCookie(rememberMeCookie()); // rememberMe
	 * cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
	 * cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="
	 * )); return cookieRememberMeManager; }
	 */
	/*
	 *
	 * @Bean(name = "simpleMappingExceptionResolver") public
	 * SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
	 * SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
	 * Properties mappings = new Properties();
	 * mappings.setProperty("DatabaseException", "databaseError"); // 数据库异常处理
	 * mappings.setProperty("UnauthorizedException", "403");
	 * r.setExceptionMappings(mappings); // None by default
	 * r.setDefaultErrorView("error"); // No default r.setExceptionAttribute("ex");
	 * // Default is "exception" // r.setWarnLogCategory("example.MvcLogger"); // No
	 * default return r; }
	 */
}
