package com.tt.springboottest.test.solr;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/hello", produces = { "application/json;charset=UTF-8" })
public class Solr_UserController {
	@Autowired
	private Solr_UserServers solr_UserService;

	@Autowired
	private SolrClient solrClient;

	// 批量增加
	@RequestMapping("/addUsers")
	@ResponseBody
	public String addUsers() throws IOException, SolrServerException {
		List<Solr_User> users = solr_UserService.addUser();
		try {
			solrClient.addBeans(users);
			solrClient.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("添加索引失败");
		}

		return JSON.toJSONString("添加索引成功");
	}

	// 批量增加
	@RequestMapping("/queryUsers")
	@ResponseBody
	public String queryUsers() throws IOException, SolrServerException {
		SolrQuery solrQuery = new SolrQuery();
		return null;

	}
}
