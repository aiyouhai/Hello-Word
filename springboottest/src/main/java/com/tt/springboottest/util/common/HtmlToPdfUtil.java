package com.tt.springboottest.util.common;

import com.tt.springboottest.creathtml.CreatHtml;

public class HtmlToPdfUtil {
	public static boolean creditHtmlToPdf(String companyName) {
		String fileSavePath = ""; // 静态模板路经
		String templateAndClassPath = ""; // 转换成pdf的静态页面
		String urlPath = "";
		boolean convert = false;
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			templateAndClassPath = ResourceBundleUtil.getString("default", "publicCreditPDFTemplateAndClassPathWin");
			urlPath = templateAndClassPath + "\\" + "publicPdf.html";
		} else {
			templateAndClassPath = ResourceBundleUtil.getString("default", "publicCreditPDFTemplateAndClassPathLinux");
			urlPath = templateAndClassPath + "/" + "publicPdf.html";
		}
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			fileSavePath = ResourceBundleUtil.getString("default", "winAllPublicPdfSavePath") + companyName + ".pdf";
		} else {
			fileSavePath = ResourceBundleUtil.getString("default", "linuxAllPublicPdfSavePath") + companyName + ".pdf";
		} // 创建pdf静态页面
		Boolean creatHtmlForFreemarker = CreatHtml.creatHtmlForFreemarker(templateAndClassPath);
		if (creatHtmlForFreemarker) { // html转换pdf
			convert = HtmlToPdf.convert(urlPath, fileSavePath);
		}
		return convert;

	}

	public static boolean financialHtmlToPdf(String companyName) {
		// 文件保存地址
		String fileSavePath = "";
		// 静态页面地址
		String templateAndClassPath = "";
		// 转换成pdf的静态页面
		String urlPath = "";
		boolean convert = false;
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			templateAndClassPath = ResourceBundleUtil.getString("default", "finacingCreditPDFTemplateAndClassPathWin");
			urlPath = templateAndClassPath + "\\" + "financingPdf.html";
		} else {
			templateAndClassPath = ResourceBundleUtil.getString("default",
					"finacingCreditPDFTemplateAndClassPathLinux");
			urlPath = templateAndClassPath + "/" + "financingPdf.html";
		}
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			fileSavePath = ResourceBundleUtil.getString("default", "winAllFinacingPdfSavePath") + companyName + ".pdf";
			;
		} else {
			fileSavePath = ResourceBundleUtil.getString("default", "linuxAllFinacingPdfSavePath") + companyName
					+ ".pdf";

		}
		// Boolean creatHtmlForFreemarker =
		// CreatHtml.creatHtmlForFreemarker(templateAndClassPath);
		// html转换pdf
		convert = HtmlToPdf.convert(urlPath, fileSavePath);

		return convert;
	}

}
