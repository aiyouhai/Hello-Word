package com.tt.springboottest.ui.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tt.springboottest.creathtml.CreatHtml;
import com.tt.springboottest.test.HtmlToPdf;
import com.tt.springboottest.test.ResourceBundleUtil;
import com.tt.springboottest.ui.service.downloadservice.DownLoadService;

@Controller
@RequestMapping("/financial")
public class DownLoadController {
	@Autowired
	private DownLoadService downLoadService;

	/*
	 * 公共信用报告下载
	 **/
	@RequestMapping("/publicCreditPdf/fromFileDownload")
	@ResponseBody
	public String publicCreditPdfFromFile(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("companyName") String companyName) {
		// 文件保存路径
		String fileSavePath = "";
		JSONObject result = new JSONObject();
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			fileSavePath = ResourceBundleUtil.getString("default", "winAllPublicPdfSavePath") + companyName + ".pdf";
		} else {
			fileSavePath = ResourceBundleUtil.getString("default", "linuxAllPublicPdfSavePath") + companyName + ".pdf";
		}
		if (StringUtils.isEmpty(companyName)) {

			result.put("code", "204");
			result.put("msg", "公司名称不能为空");
			return result.toString();
		} else {
			// 浏览器下载后的文件名称showValue,从url中截取到源文件名称以及，以及文件类型，如board.docx;
			String showValue = "公共信用报告";
			try {
				String pdfFinancingCredit = downLoadService.pdfFinancingCredit(response, request, fileSavePath,
						showValue);
				if (!StringUtils.isEmpty(pdfFinancingCredit)) {
					result.put("code", "202");
					result.put("msg", "公共信用报告不存在");
					return result.toString();
				}
			} catch (IOException e) {
				result.put("code", "202");
				result.put("msg", "下载失败");
				return result.toString();
			}
		}
		result.put("code", "200");
		result.put("msg", "下载成功");
		return result.toString();
	}

	/*
	 * 公共信用报告下载
	 **/
	@RequestMapping("/publicCreditPdf/download")
	@ResponseBody
	public String publicCreditPdf(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("companyName") String companyName) {
		// 文件保存路径
		String fileSavePath = "";
		// 静态模板路劲经
		String templateAndClassPath = "";
		// 转换成pdf的静态页面
		String urlPath = "";
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			templateAndClassPath = ResourceBundleUtil.getString("default", "publicCreditPDFTemplateAndClassPathWin");
			urlPath = templateAndClassPath + "\\" + "publicPdf.html";
		} else {
			templateAndClassPath = ResourceBundleUtil.getString("default", "publicCreditPDFTemplateAndClassPathLinux");
			urlPath = templateAndClassPath + "/" + "publicPdf.html";
		}

		JSONObject result = new JSONObject();
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			fileSavePath = ResourceBundleUtil.getString("default", "winPublicPdfSavePath");
		} else {
			fileSavePath = ResourceBundleUtil.getString("default", "linuxPublicPdfSavePath");
		}
		if (StringUtils.isEmpty(companyName)) {
			result.put("code", "204");
			result.put("msg", "公司名称不能为空");
			return result.toString();
		} else {
			// 创建pdf静态页面
			Boolean creatHtmlForFreemarker = CreatHtml.creatHtmlForFreemarker(templateAndClassPath);
			if (creatHtmlForFreemarker) {
				// html转换pdf
				boolean convert = HtmlToPdf.convert(urlPath, fileSavePath);
				if (convert) { // 浏览器下载后的文件名称showValue,从url中截取到源文件名称以及，以及文件类型，如board.docx;
					String showValue = "公共信用报告";
					try {
						String pdfFinancingCredit = downLoadService.pdfFinancingCredit(response, request, fileSavePath,
								showValue);
						if (!StringUtils.isEmpty(pdfFinancingCredit)) {
							result.put("code", "202");
							result.put("msg", "公共信用报告不存在");
							return result.toString();
						}
						deleteFile(fileSavePath);
					} catch (IOException e) {
						result.put("code", "202");
						result.put("msg", "下载失败");
						return result.toString();
					}
				} else {
					result.put("code", "202");
					result.put("msg", "下载失败");
					return result.toString();
				}
			} else {
				result.put("code", "202");
				result.put("msg", "接口异常");
				return result.toString();
			}
		}
		result.put("code", "200");
		result.put("msg", "下载成功");
		return result.toString();
	}

	public void deleteFile(String fileSavePath) {
		File file = new File(fileSavePath);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}
}
