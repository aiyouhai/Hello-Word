package com.tt.springboottest.springtask;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.tt.springboottest.util.common.HtmlToPdfUtil;

@Component
@EnableScheduling
public class FinancialCreditTask {
	public void task() {
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("长城汽车");
		arrayList.add("苹果公司");
		arrayList.add("吉利汽车");
		arrayList.add("华为公司");
		for (String companyName : arrayList) {

			if (companyName == null || "".equals(companyName)) {
				continue;
			}

			HtmlToPdfUtil.financialHtmlToPdf(companyName);
		}

	}
}