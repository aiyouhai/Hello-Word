package com.tt.springboottest.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/file")
public class FileController {
	@Autowired
	private FileService fileServiceImpl;

	@RequestMapping("/down")
	@ResponseBody
	public String fileDown(HttpServletResponse response, HttpServletRequest request) {
		String filepath = "G:" + File.separatorChar + "test" + File.separatorChar + "0.txt";
		String showValue = "信用报告";
		JSONObject result = new JSONObject();
		try {
			String pdfFinancingCredit = fileServiceImpl.pdfFinancingCredit(response, request, filepath, showValue);
			if (!StringUtils.isEmpty(pdfFinancingCredit)) {
				result.put("code", "202");
				result.put("msg", "pdf不存在");
				return result.toString();
			}
		} catch (IOException e) {
			result.put("code", "202");
			result.put("msg", "下载失败");
			return result.toString();
		}

		result.put("code", "200");
		result.put("msg", "下载成功");
		return result.toString();
	}
}
