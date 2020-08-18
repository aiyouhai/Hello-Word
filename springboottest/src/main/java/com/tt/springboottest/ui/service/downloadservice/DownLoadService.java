package com.tt.springboottest.ui.service.downloadservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DownLoadService {

	String pdfFinancingCredit(HttpServletResponse response, HttpServletRequest request, String filepath,
			String showValue) throws IOException;

}
