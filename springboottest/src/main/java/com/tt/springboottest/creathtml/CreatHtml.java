package com.tt.springboottest.creathtml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class CreatHtml {

	public static Boolean creatHtmlForFreemarker(String templateAndClassPath) {
		GetDate getDate = new GetDate();
		// 创建freeMarker配置实例
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
		Writer out = null;
		try {
			// 获取模板路径
			configuration.setDirectoryForTemplateLoading(new File(templateAndClassPath));
			// GetData getData = new GetData();
			HashMap<String, Object> dataMap = null;
			// 加载模板文件
			Template template;
			File docFile;
			// F:\pdf1\pdf\pdf
			if (templateAndClassPath.indexOf("financingPdf") > 0) {
				template = configuration.getTemplate("financingPdf_new.html");
				if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
					docFile = new File(templateAndClassPath + "\\" + "financingPdf.html");
				} else {
					docFile = new File(templateAndClassPath + "/" + "financingPdf.html");
				}
				if (!docFile.exists()) {
					docFile.createNewFile();
				}
				// dataMap = getDate.getDataForFinancingCreadPDF();
			} else {
				template = configuration.getTemplate("pdf.html");
				if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
					docFile = new File(templateAndClassPath + "\\" + "publicPdf.html");
				} else {
					docFile = new File(templateAndClassPath + "/" + "publicPdf.html");
				}
				if (!docFile.exists()) {
					docFile.createNewFile();
				}
				dataMap = getDate.getDataForPublicCreadPDF();
			}
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
			// 输出文件
			template.process(dataMap, out);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (out != null) {
				try {
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;

	}
}
