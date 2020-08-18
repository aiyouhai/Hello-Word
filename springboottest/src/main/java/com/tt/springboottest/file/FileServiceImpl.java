package com.tt.springboottest.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String pdfFinancingCredit(HttpServletResponse response, HttpServletRequest request, String filepath,
			String showValue) throws IOException {
		ServletOutputStream outputStream = null;
		InputStream inStream = null;
		// JSONObject jsonObject = new JSONObject();
		try {
			// String url = "需要下载的文件路径";
			File fileurl = new File(filepath);
			if (!fileurl.exists()) {
				return "pdf不存在";
			}
			// 根据条件得到文件路径
			// 将文件读入文件流
			inStream = new FileInputStream(fileurl);
			// 获得浏览器代理信息
			final String userAgent = request.getHeader("USER-AGENT");
			// 判断浏览器代理并分别设置响应给浏览器的编码格式
			String finalFileName = null;
			if (StringUtils.contains(userAgent, "MSIE") || StringUtils.contains(userAgent, "Trident")) {// IE浏览器
				finalFileName = URLEncoder.encode(showValue, "UTF8");
			} else if (StringUtils.contains(userAgent, "Mozilla")) {// google,火狐浏览器
				finalFileName = new String(showValue.getBytes(), "ISO8859-1");
			} else {
				finalFileName = URLEncoder.encode(showValue, "UTF8");// 其他浏览器
			}
			// 设置HTTP响应头
			response.reset();// 重置 响应头
			response.setContentType("application/x-download");// 告知浏览器下载文件，而不是直接打开，浏览器默认为打开
			response.addHeader("Content-Disposition", "attachment;filename=" + finalFileName + ".pdf");// 下载文件的名称
			outputStream = response.getOutputStream();
			// 循环取出流中的数据
			byte[] b = new byte[1024];
			int len;
			while ((len = inStream.read(b)) > 0) {
				outputStream.write(b, 0, len);
			}
			outputStream.close();
			inStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (inStream != null) {
				inStream.close();
			}
		}
		return null;
	}

}
