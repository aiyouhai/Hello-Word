package com.tt.springboottest.file;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {
	String pdfFinancingCredit(HttpServletResponse response, HttpServletRequest request, String filepath,
			String showValue) throws IOException;
}
