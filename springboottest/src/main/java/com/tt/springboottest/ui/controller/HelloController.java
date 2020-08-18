package com.tt.springboottest.ui.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.tt.springboottest.des.DesUtils;
import com.tt.springboottest.rsa.RSAUtils;
import com.tt.springboottest.test.TestUtils;
import com.tt.springboottest.test.jwt.JWTUtils;
import com.tt.springboottest.test.jwt.User;
import com.tt.springboottest.ui.domain.SysUser;
import com.tt.springboottest.ui.service.sysuserservice.SysUserServiceImpl;
import com.tt.springboottest.ui.service.tokenservice.TokenService;
import com.tt.springboottest.util.HttpClientUtil;
import com.tt.springboottest.util.R;

import io.jsonwebtoken.Claims;

@Controller
@RequestMapping("/hello")
public class HelloController {
	private static final String REDIS_KEY = "TEST:SYSUSER:";
	private static String token = "1111";
	@Autowired
	private SysUserServiceImpl sysUserServiceImpl;
	@Autowired
	private TokenService tokenServiceImpl;

	@RequestMapping("/h")

	public String Hello(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Map<String, Object>> marketBaseInfo = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("label", "一社会信用代码");
		map1.put("value", "9151010032159783XA");
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("label", "法定代表");
		map2.put("value", "林靖力");
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("label", "注册资本");
		map3.put("value", "2000万元");
		HashMap<String, Object> map4 = new HashMap<String, Object>();
		map4.put("label", "市场主体类型");
		map4.put("value", "有限责任公司(自然人投资或控股");
		HashMap<String, Object> map5 = new HashMap<String, Object>();
		map5.put("label", "行业门类/所属行业");
		map5.put("value", "电子信息");
		HashMap<String, Object> map6 = new HashMap<String, Object>();
		map6.put("label", "核准日期");
		map6.put("value", "2015-01-12");
		HashMap<String, Object> map7 = new HashMap<String, Object>();
		map7.put("label", "经营(驻在)期限自");
		map7.put("value", "2015-01-12");
		HashMap<String, Object> map8 = new HashMap<String, Object>();
		map8.put("label", "登记机关");
		map8.put("value", "郑州市高新工商行政管理局");
		HashMap<String, Object> map9 = new HashMap<String, Object>();
		map9.put("label", "登记状态");
		map9.put("value", "存续");
		HashMap<String, Object> map10 = new HashMap<String, Object>();
		map10.put("label", "成立日期");
		map10.put("value", "2015-01-12");
		HashMap<String, Object> map11 = new HashMap<String, Object>();
		map11.put("label", "注册地址");
		map11.put("value", "中国(河南)自由贸易试验区郑州高新区天府大道北段1480号9号楼A座3楼");
		HashMap<String, Object> map12 = new HashMap<String, Object>();
		map12.put("label", "经营范围");
		map12.put("value", "开发、销售、租赁计算机软硬件并提供技术服务;网络技术开发;计算机系统集成。");
		marketBaseInfo.add(map1);
		marketBaseInfo.add(map2);
		marketBaseInfo.add(map3);
		marketBaseInfo.add(map4);
		marketBaseInfo.add(map5);
		marketBaseInfo.add(map6);
		marketBaseInfo.add(map7);
		marketBaseInfo.add(map8);
		marketBaseInfo.add(map9);
		marketBaseInfo.add(map10);
		marketBaseInfo.add(map11);
		marketBaseInfo.add(map12);

		List<Map<String, Object>> enterpriseAnualReport = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> enterpriseAnualReportmap = new HashMap<String, Object>();
		enterpriseAnualReportmap.put("ancheyear", "2018 年度报告");
		enterpriseAnualReportmap.put("anchedate", "2019-01-02");
		enterpriseAnualReportmap.put("uniscid", "9151010032159783XA");
		enterpriseAnualReportmap.put("entname", "郑州起步网络科技有限公司");
		enterpriseAnualReportmap.put("addr", "河南省郑州市高新区");
		enterpriseAnualReportmap.put("postalcode", "45000");
		enterpriseAnualReportmap.put("tel", "0371-123456");
		enterpriseAnualReportmap.put("busst_cn", "开业");

		enterpriseAnualReportmap.put("empnum", "企业不对外公示");
		enterpriseAnualReportmap.put("dispernum", "企业不对外公示");
		enterpriseAnualReportmap.put("disemplnum", "企业不对外公示");
		enterpriseAnualReportmap.put("colgranum", "企业不对外公示");
		enterpriseAnualReportmap.put("colemplnum", "企业不对外公示");
		enterpriseAnualReportmap.put("retsolnum", "企业不对外公示");
		enterpriseAnualReportmap.put("retemplnum", "企业不对外公示");
		enterpriseAnualReportmap.put("unenum", "企业不对外公示");
		enterpriseAnualReportmap.put("uneemplnum", "企业不对外公示");
		enterpriseAnualReportmap.put("dependententname", "企业不对外公示");

		enterpriseAnualReportmap.put("numparm", "企业不对外公示");
		ArrayList<Map<String, Object>> annualShareHolderList = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> annualShareHolderMap1 = new HashMap<String, Object>();
		annualShareHolderMap1.put("invname", "邓丽");
		annualShareHolderMap1.put("lisubconam", "57.4");
		annualShareHolderMap1.put("subcondate", "2018-07-06");
		annualShareHolderMap1.put("acconform_cn", "货币");
		annualShareHolderMap1.put("accondate", "2018-06-06");
		annualShareHolderMap1.put("liacconam", "57.4");
		HashMap<String, Object> annualShareHolderMap2 = new HashMap<String, Object>();
		annualShareHolderMap2.put("invname", "啰里啰嗦");
		annualShareHolderMap2.put("lisubconam", "57.4");
		annualShareHolderMap2.put("subcondate", "2018-07-06");
		annualShareHolderMap2.put("acconform_cn", "货币");
		annualShareHolderMap2.put("accondate", "2018-06-06");
		annualShareHolderMap2.put("liacconam", "57.4");
		annualShareHolderList.add(annualShareHolderMap1);
		annualShareHolderList.add(annualShareHolderMap2);
		enterpriseAnualReportmap.put("annualShareHolderList", annualShareHolderList);

		enterpriseAnualReportmap.put("assgro", "企业不对外公示");
		enterpriseAnualReportmap.put("totequ", "企业不对外公示");
		enterpriseAnualReportmap.put("vendinc", "企业不对外公示");

		enterpriseAnualReportmap.put("progro", "企业不对外公示");
		enterpriseAnualReportmap.put("maibusinc", "企业不对外公示");
		enterpriseAnualReportmap.put("netinc", "企业不对外公示");
		enterpriseAnualReportmap.put("ratgro", "企业不对外公示");
		enterpriseAnualReportmap.put("liagro", "企业不对外公示");
		enterpriseAnualReportmap.put("lastupdatetime", "企业不对外公示");

		HashMap<String, Object> enterpriseAnualReportmap1 = new HashMap<String, Object>();
		enterpriseAnualReportmap1.put("ancheyear", "2019年度报告");
		enterpriseAnualReportmap1.put("anchedate", "2020-01-02");
		enterpriseAnualReportmap1.put("uniscid", "9151010032159783XA");
		enterpriseAnualReportmap1.put("entname", "郑州起步网络科技有限公司");
		enterpriseAnualReportmap1.put("addr", "河南省郑州市高新区");
		enterpriseAnualReportmap1.put("postalcode", "45000");
		enterpriseAnualReportmap1.put("tel", "0371-123456");
		enterpriseAnualReportmap1.put("busst_cn", "开业");

		enterpriseAnualReportmap1.put("empnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("dispernum", "企业不对外公示");
		enterpriseAnualReportmap1.put("disemplnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("colgranum", "企业不对外公示");
		enterpriseAnualReportmap1.put("colemplnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("retsolnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("retemplnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("unenum", "企业不对外公示");
		enterpriseAnualReportmap1.put("uneemplnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("dependententname", "企业不对外公示");

		enterpriseAnualReportmap1.put("numparm", "企业不对外公示");

		ArrayList<Map<String, Object>> annualShareHolderList2 = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> annualShareHolderMap21 = new HashMap<String, Object>();
		annualShareHolderMap21.put("invname", "邓丽");
		annualShareHolderMap21.put("lisubconam", "57.4");
		annualShareHolderMap21.put("subcondate", "2018-07-06");
		annualShareHolderMap21.put("acconform_cn", "货币");
		annualShareHolderMap21.put("accondate", "2018-06-06");
		annualShareHolderMap21.put("liacconam", "57.4");
		HashMap<String, Object> annualShareHolderMap22 = new HashMap<String, Object>();
		annualShareHolderMap22.put("invname", "啰里啰嗦");
		annualShareHolderMap22.put("lisubconam", "57.4");
		annualShareHolderMap22.put("subcondate", "2018-07-06");
		annualShareHolderMap22.put("acconform_cn", "货币");
		annualShareHolderMap22.put("accondate", "2018-06-06");
		annualShareHolderMap22.put("liacconam", "57.4");
		annualShareHolderList2.add(annualShareHolderMap21);
		annualShareHolderList2.add(annualShareHolderMap22);
		enterpriseAnualReportmap1.put("annualShareHolderList", annualShareHolderList2);

		enterpriseAnualReportmap1.put("assgro", "企业不对外公示");
		enterpriseAnualReportmap1.put("totequ", "企业不对外公示");
		enterpriseAnualReportmap1.put("vendinc", "企业不对外公示");

		enterpriseAnualReportmap1.put("progro", "企业不对外公示");
		enterpriseAnualReportmap1.put("maibusinc", "企业不对外公示");
		enterpriseAnualReportmap1.put("netinc", "企业不对外公示");
		enterpriseAnualReportmap1.put("ratgro", "企业不对外公示");
		enterpriseAnualReportmap1.put("liagro", "企业不对外公示");
		enterpriseAnualReportmap1.put("lastupdatetime", "企业不对外公示");

		enterpriseAnualReport.add(enterpriseAnualReportmap);
		enterpriseAnualReport.add(enterpriseAnualReportmap1);

		List<Map<String, Object>> EnterpriseFinancialReport = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> EnterpriseFinancialReportmap1 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap1.put("label", "数据更新日期");
		EnterpriseFinancialReportmap1.put("value", "2020-03-31");
		HashMap<String, Object> EnterpriseFinancialReportmap2 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap2.put("label", "企业纳税识别号");
		EnterpriseFinancialReportmap2.put("value", "sdsdshd2232");

		HashMap<String, Object> EnterpriseFinancialReportmap3 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap3.put("label", "流动资产");
		EnterpriseFinancialReportmap3.put("value", "25325342.3");

		HashMap<String, Object> EnterpriseFinancialReportmap4 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap4.put("label", "非流动资产");
		EnterpriseFinancialReportmap4.put("value", "232632.34");

		HashMap<String, Object> EnterpriseFinancialReportmap6 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap6.put("label", "存货");
		EnterpriseFinancialReportmap6.put("value", "3423432");

		HashMap<String, Object> EnterpriseFinancialReportmap7 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap7.put("label", "流动负债");
		EnterpriseFinancialReportmap7.put("value", "343");

		HashMap<String, Object> EnterpriseFinancialReportmap8 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap8.put("label", "非流动负债");
		EnterpriseFinancialReportmap8.put("value", "0");

		HashMap<String, Object> EnterpriseFinancialReportmap9 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap9.put("label", "所有者权益（净资产）");
		EnterpriseFinancialReportmap9.put("value", "323");

		HashMap<String, Object> EnterpriseFinancialReportmap10 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap10.put("label", "利润总额");
		EnterpriseFinancialReportmap10.put("value", "2342342343");

		HashMap<String, Object> EnterpriseFinancialReportmap11 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap11.put("label", "销售收入(主营业务收入)");
		EnterpriseFinancialReportmap11.put("value", "3423432");

		HashMap<String, Object> EnterpriseFinancialReportmap12 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap12.put("label", "销售成本");
		EnterpriseFinancialReportmap12.put("value", "4534543");

		HashMap<String, Object> EnterpriseFinancialReportmap13 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap13.put("label", "研发费用");
		EnterpriseFinancialReportmap13.put("value", "10");

		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap13);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap12);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap11);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap10);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap9);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap8);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap7);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap6);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap4);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap3);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap2);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap1);

		model.addAttribute("EnterpriseFinancialReport", EnterpriseFinancialReport);

		model.addAttribute("enterpriseAnualReport", enterpriseAnualReport);
		model.addAttribute("marketBaseInfo", marketBaseInfo);

		return "hello";
	}

	/*
	 * 公共信用评价体系指标
	 */

	@GetMapping(value = "/c")
	@ResponseBody
	public String getPublicCreditSystemIndex(@RequestBody String companyName) {

		JSONObject jsonObject = new JSONObject();
		System.out.println("".equals(companyName));
		if ("".equals(companyName)) {

			jsonObject.put("code", "500");
			jsonObject.put("msg", "参数卫龙");
			return jsonObject.toString();
		}

		return JSONObject.toJSONString(companyName);

	}

	@GetMapping(value = "/redis")
	@ResponseBody
	@Cacheable(value = "my-redis-cache1", keyGenerator = "keyGenerator")
	public SysUser getRedisString(long id) {
		System.out.println("第一次");
		return sysUserServiceImpl.selectOneById(id);
	}

	/*
	 * @GetMapping(value = "/" + "")
	 * 
	 * @ResponseBody public SysUser getSysUserById(long id) {
	 * 
	 * // REDIS_KEY if (RedisUtils1.exists(REDIS_KEY + id)) { String string =
	 * RedisUtils1.get(REDIS_KEY + id); SysUser sysUser =
	 * JSONObject.parseObject(string, SysUser.class); return sysUser; } SysUser
	 * sysUser = sysUserServiceImpl.selectOneById(id); RedisUtils1.set(REDIS_KEY +
	 * id, JSONObject.toJSONString(sysUser)); return sysUser; }
	 * 
	 * @GetMapping(value = "/getSysUsers")
	 * 
	 * @ResponseBody public List<SysUser> getSysUsers() {
	 * 
	 * // REDIS_KEY if (RedisUtils1.exists(REDIS_KEY + "all2")) { String string =
	 * RedisUtils1.get(REDIS_KEY + "all2"); List<SysUser> parseObject =
	 * JSONObject.parseObject(string, List.class); return parseObject; }
	 * List<SysUser> selectAll = sysUserServiceImpl.selectAll();
	 * RedisUtils1.set(REDIS_KEY + "all2", JSONObject.toJSONString(selectAll));
	 * return selectAll; }
	 * 
	 * @GetMapping(value = "/addSysUser")
	 * 
	 * @ResponseBody
	 * 
	 * @Transactional public String addSysUser() {
	 * 
	 * SysUser sysUser2 = new SysUser(); sysUser2.setId(1002l);
	 * sysUser2.setUserName("lili"); // REDIS_KEY try { int addUser =
	 * sysUserServiceImpl.addUser(sysUser2); if (RedisUtils1.exists(REDIS_KEY +
	 * sysUser2.getId())) { // redisUtils1.del(REDIS_KEY + "all"); }
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); return "添加失败"; } return "添加成功"; }
	 */

	@GetMapping(value = "/selectUserByTiaoJian")
	@ResponseBody
	@Transactional
	public List<SysUser> selectUserByTiaoJian(@RequestBody SysUser user) {

		List<SysUser> sysUserList = sysUserServiceImpl.selectUserByTiaoJian(user);
		return sysUserList;
	}

	@RequestMapping(value = "/up")
	@ResponseBody
	public String up(@RequestParam Map<String, Object> params, MultipartFile uploadFile, HttpSession session)
			throws Exception {
		String desc = (String) params.get("desc");
		/* MultipartFile uploadFile = (MultipartFile) params.get("uploadFile") */;
		// 获取上传文件的名称
		String fileName = uploadFile.getOriginalFilename();
		// 解决文件重名问题
		String finalFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
		// 获取上传文件的路径
		String path = "G:" + File.separator + finalFileName;
		uploadFile.transferTo(new File(path));
		return "success";

	}

	@RequestMapping("/key")
	public String generate(HttpServletRequest request, HttpServletResponse response, Model model) {
		String publicKeyStr = "";
		try {
			Map<String, Object> initKey = RSAUtils.initKey();
			String privateKeyStr = RSAUtils.getPrivateKeyStr(initKey);
			publicKeyStr = RSAUtils.getPublicKeyStr(initKey);
			// 存入session
			HttpSession session = request.getSession();
			session.setAttribute("publicKey", publicKeyStr);
			session.setAttribute("privateKey", privateKeyStr);
			model.addAttribute("publicKeyStr", publicKeyStr);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("创建公私钥错误");
		}

		return "ras";
	}

	@RequestMapping(value = "/useKey")
	public String login(String uName, String pwd, HttpServletRequest request) {
		// 获取 session中的 privateKey
		String privateKey = (String) request.getSession().getAttribute("privateKey");

		try {
			byte[] decrypt = RSAUtils.decrypt(pwd.getBytes(), privateKey);
			String newPwd = new String(decrypt); // 解密后的密码
			System.out.println(newPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@ResponseBody
	@PostMapping(value = "/unicom/", produces = "application/text; charset=utf-8")
	public R list(String paramsJson, MultipartFile file, HttpServletRequest request) {
		try {
			/*
			 * if (paramsJson.isEmpty() || paramsJson.get("sign") == null || ((String)
			 * paramsJson.get("sign")).length() <= 0) { return R.error(1, "参数为空"); }
			 */
			if (paramsJson == null || paramsJson.equals("")) {
				return R.error(1, "参数为空");
			}
			// 字符串拆分数组

			String[] paramsArray = getParamsArray(paramsJson);
			// 拆分出签名
			String signature = paramsArray[paramsArray.length - 1];
			// 获取去掉签名的参数拼接
			String newParamsStr = getTogetherParams(paramsArray);
			String url = paramsArray[0];

		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return null;
	}

	// 获取去掉签名的参数拼接
	public String getTogetherParams(String[] paramsArray) throws Exception {
		// 拼接除掉签名的所有参数
		String newParamsStr = "";
		for (int i = 0; i < paramsArray.length - 1; i++) {
			newParamsStr += paramsArray[i];
		}
		return newParamsStr;
	}

//字符串拆分数组
	public String[] getParamsArray(String paramsJson) throws Exception {
		// 解密
		String password = "yzd-2020yzd-2020";
		String paramsStr = DesUtils.decrypt(password, paramsJson);

		// String paramsStr = DesUtils.decrypt((String) paramsJson.get("sign"));
		String[] paramsArray = paramsStr.split("`");
		return paramsArray;
	}

	@Autowired
	private TestUtils testUtils;

	@RequestMapping(value = "/test")
	@ResponseBody
	public String test(String token, HttpServletRequest request, HttpServletResponse response) {
		String header = request.getHeader("token");

		Enumeration<String> headerNames = request.getHeaderNames();
		System.out.println();
		System.out.println();
		// TestUtils testUtils = new TestUtils();
		// testUtils.test();
		return "成功";
	}

	@RequestMapping(value = "/token")
	@ResponseBody
	public String getToken(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String token = "";
		if (session != null && (String) session.getAttribute("token") != null
				&& !((String) session.getAttribute("token")).equals("")) {
			token = (String) session.getAttribute("token");
			System.out.println(token);
			System.out.println("调用接口");

		} else {
			System.out.println("请求接口获取token");
			token = "123456";
			session.setMaxInactiveInterval(5);
			session.setAttribute("token", token);
			System.out.println("调用接口");
		}
		return "ok";

	}

	@RequestMapping(value = "/jwt")
	@ResponseBody
	public String jwt(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User();
		user.setName("shizhenjie");
		user.setPwd("123");
		String token = JWTUtils.getToken(user);
		System.out.println(token);
		// response.addHeader("user_token", token);

		/*
		 * Cookie cookie = new Cookie("user_token", token); response.addCookie(cookie);
		 */
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(6);
		session.setAttribute("user_token", token);

		// 转发
		// return "forward:/WEB-INF/jsp/test.jsp";
		// 重定向"redirect:/templates/hello.html?token=hfjsahdjahsdjhsjdh"

		// response.sendRedirect(response.encodeRedirectURL("check"));
		return "成功";
	}

	@RequestMapping(value = "/check")
	@ResponseBody
	public String checkjwt(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		String attribute = (String) session.getAttribute("user_token");
		if (attribute == null || attribute.equals("")) {
			System.out.println("attribute为null");
			return "token失效";
		} else {
			Claims checkToken = JWTUtils.checkToken((String) attribute);
			System.out.println(checkToken);
			if (checkToken.get("name").equals("shizhenjie")) {
				return "登录成功";
			}

		}

		/*
		 * Cookie[] cookies = request.getCookies(); for (Cookie cookie : cookies) { if
		 * (cookie.getName().trim().equals("user_token")) {
		 * System.out.println(cookie.getName() + "---" + cookie.getValue()); Claims
		 * checkToken = JWTUtils.checkToken(cookie.getValue().trim());
		 * System.out.println(checkToken); if
		 * (checkToken.get("name").equals("shizhenjie")) { return "登录成功"; } } }
		 */

		return "登录失败";
	}

	@RequestMapping(value = "/testtoken")
	@ResponseBody
	public String getToken1(HttpServletRequest request, HttpServletResponse response) {

		boolean checkToken = tokenServiceImpl.checkToken(token);
		if (!checkToken) {
			token = tokenServiceImpl.getToken();
			System.out.println("重新获取token:" + token);
		} else {
			System.out.println("token:" + token);

		}
		return "";
	}

	@RequestMapping(value = "/http")
	@ResponseBody
	public String http(HttpServletRequest request, HttpServletResponse response) {
		String url = "http://localhost:8080/springtest/hello/2";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "lili");

		return getSendPost(url, map);
	}

	public String getSendPost(String url, HashMap<String, Object> map) {
		User user = new User();
		user.setName("shizhenjie");
		user.setPwd("123");
		String sendPostAndToken = "";
		sendPostAndToken = HttpClientUtil.sendPostAndToken(url, map, token);
		System.out.println(sendPostAndToken);
		if (sendPostAndToken.contains("403")) {
			token = JWTUtils.getToken(user);
			sendPostAndToken = HttpClientUtil.sendPostAndToken(url, map, token);
			System.out.println(sendPostAndToken);
		}
		return sendPostAndToken;
	}
}
