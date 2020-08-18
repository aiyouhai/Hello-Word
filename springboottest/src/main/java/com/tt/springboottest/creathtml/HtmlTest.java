
package com.tt.springboottest.creathtml;

import java.io.File;

public class HtmlTest {
	public static void main(String[] args) {

		CreatHtml creatHtml = new CreatHtml();
		//// F:\pdf1\pdf\pdf
		String templateAndClassPath = "F:" + File.separator + "pdf1" + File.separator + "pdf" + File.separator + "pdf";
		Boolean creatHtmlForFreemarker = creatHtml.creatHtmlForFreemarker(templateAndClassPath);

	}
}
