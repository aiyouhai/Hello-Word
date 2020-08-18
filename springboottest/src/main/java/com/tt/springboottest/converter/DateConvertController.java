package com.tt.springboottest.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/hello")
public class DateConvertController {
	private static final Logger logger = LoggerFactory.getLogger(DateConvertController.class);

	/**
	 * 
	 * @param order 订单信息
	 * @return 请求方式为application/x-www-form-urlencoded
	 */
	@ResponseBody
	@RequestMapping(value = "test", method = { RequestMethod.POST })
	public Object checkInventoryForm(@RequestParam Order order) {
		if (order == null) {
			throw new RuntimeException("the hotelOrder is null");
		}
		return JSONObject.toJSON(order);
	}

}
