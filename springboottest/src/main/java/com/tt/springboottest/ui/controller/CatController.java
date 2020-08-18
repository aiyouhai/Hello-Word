package com.tt.springboottest.ui.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tt.springboottest.ui.domain.Cat;
import com.tt.springboottest.ui.domain.CatItem;
import com.tt.springboottest.ui.domain.Product;
import com.tt.springboottest.ui.domain.SysUser;

@Controller
@RequestMapping("/cat")
public class CatController {
	@Autowired
	private HelloController helloController;

	@RequestMapping("/createCat")
	@ResponseBody
	public String createCat(HttpServletResponse res, HttpServletRequest req) {
		req.getSession().setAttribute("cat", new Cat());

		return null;

	}

	@RequestMapping("/addCat")
	@ResponseBody
	public String addCat(HttpServletResponse res, HttpServletRequest req) {
		Cat cat = (Cat) req.getSession().getAttribute("cat");

		Product product = new Product();
		product.setName("手机");
		product.setpId("0001");
		product.setPrice(2377.8);
		int num = 3;
		CatItem catItem = new CatItem();
		catItem.setNum(num);
		catItem.setProduct(product);

		cat.addCat(catItem);
		cat.setToutlePrice(cat.toutlePrice());
		req.getSession().setAttribute("cat", cat);
		return JSONObject.toJSON(cat).toString();
	}

	@RequestMapping("/h")
	@ResponseBody
	public List<SysUser> hello(@RequestBody Map<String, Object> params) {

		SysUser user = JSONObject.parseObject(JSONObject.toJSONString(params), SysUser.class);
		List<SysUser> selectUserByTiaoJian = helloController.selectUserByTiaoJian(user);
		return selectUserByTiaoJian;
	}
}
