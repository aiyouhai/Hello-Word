package com.tt.springboottest.creathtml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class GetDate {
	// 获取公共信用报告数据
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getDataForPublicCreadPDF() {
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		// 公共信用报告-头部
		HashMap<String, String> headMap = new HashMap<String, String>();
		headMap.put("companyName", "成都索贝尔公司");
		headMap.put("unifiedSocialCreditCode", "82712382738dhs");
		headMap.put("unifiedUpdateDate", "2019-02-04");
		headMap.put("downlodeNum", "2");
		headMap.put("reportNum", "GGXYBG-20191229-0003");
		headMap.put("downlodeDate", "2019-12-29 10:04:09");
		headMap.put("type", null);
		dataMap.putAll(headMap);
		// 获取目录
		HashMap<String, Object> catalogMap = GetReportCatalog.getPublicCtreadCatalog();
		dataMap.putAll(catalogMap);
		// 报告概述

		// 企业资质-工商信息
		List<Map<String, Object>> marketBaseInfo = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("label", "一社会信用代码");
		map1.put("value", "9151010032159783XA");
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("label", "法定代表");
		map2.put("value", "林靖力");
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("label", "注册资本");
		map3.put("value", "2000万元");
		HashMap<String, Object> map4 = new HashMap<String, Object>();
		map4.put("label", "市场主体类型");
		map4.put("value", "有限责任公司(自然人投资或控股");
		HashMap<String, Object> map5 = new HashMap<String, Object>();
		map5.put("label", "行业门类/所属行业");
		map5.put("value", "电子信息");
		HashMap<String, Object> map6 = new HashMap<String, Object>();
		map6.put("label", "核准日期");
		map6.put("value", "2015-01-12");
		HashMap<String, Object> map7 = new HashMap<String, Object>();
		map7.put("label", "经营(驻在)期限自");
		map7.put("value", "2015-01-12");
		HashMap<String, Object> map8 = new HashMap<String, Object>();
		map8.put("label", "登记机关");
		map8.put("value", "郑州市高新工商行政管理局");
		HashMap<String, Object> map9 = new HashMap<String, Object>();
		map9.put("label", "登记状态");
		map9.put("value", "存续");
		HashMap<String, Object> map10 = new HashMap<String, Object>();
		map10.put("label", "成立日期");
		map10.put("value", "2015-01-12");
		HashMap<String, Object> map11 = new HashMap<String, Object>();
		map11.put("label", "注册地址");
		map11.put("value", "中国(河南)自由贸易试验区郑州高新区天府大道北段1480号9号楼A座3楼");
		HashMap<String, Object> map12 = new HashMap<String, Object>();
		map12.put("label", "经营范围");
		map12.put("value", "开发、销售、租赁计算机软硬件并提供技术服务;网络技术开发;计算机系统集成。");

		marketBaseInfo.add(map1);
		marketBaseInfo.add(map2);
		marketBaseInfo.add(map3);
		marketBaseInfo.add(map4);
		marketBaseInfo.add(map5);
		marketBaseInfo.add(map6);
		marketBaseInfo.add(map7);
		marketBaseInfo.add(map8);
		marketBaseInfo.add(map9);
		marketBaseInfo.add(map10);
		marketBaseInfo.add(map11);
		marketBaseInfo.add(map12);

		dataMap.put("marketBaseInfo", marketBaseInfo);
		// 企业资质-股东信息
		List<Map<String, Object>> shareholder = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> shareholdermap1 = new HashMap<String, Object>();
		shareholdermap1.put("name", "琳琳");
		shareholdermap1.put("shoudCapi", "1400");
		HashMap<String, Object> shareholdermap2 = new HashMap<String, Object>();
		shareholdermap2.put("name", "邓丽");
		shareholdermap2.put("shoudCapi", "1200");
		shareholder.add(shareholdermap1);
		shareholder.add(shareholdermap2);

		dataMap.put("shareholder", shareholder);
		// 企业资质-主要人员
		List<Map<String, Object>> entEmployees = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> entEmployeesmap1 = new HashMap<String, Object>();
		entEmployeesmap1.put("name", "林靖力");
		entEmployeesmap1.put("jobTitle", "执行董事兼总经理");
		HashMap<String, Object> entEmployeesmap2 = new HashMap<String, Object>();
		entEmployeesmap2.put("name", "朱海");
		entEmployeesmap2.put("jobTitle", "监事");

		entEmployees.add(entEmployeesmap1);
		entEmployees.add(entEmployeesmap2);

		dataMap.put("entEmployees", entEmployees);

		// 企业资质-变更记录
		List<Map<String, Object>> changeRecord = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> changeRecordmap = new HashMap<String, Object>();
		changeRecordmap.put("changeItem", "住所");
		changeRecordmap.put("changeDate", "2018-07-06");
		changeRecordmap.put("beforeContent", "中国（四川）自由贸易试验区成都高新区天府大道中段 1388 号 1 栋 10 层 1066号");
		changeRecordmap.put("afterContent", "中国（四川）自由贸易 试验区成都高新区天府 大道北段 1480 号 9 号 楼 A 座 3 楼");
		changeRecord.add(changeRecordmap);
		dataMap.put("changeRecord", changeRecord);
		// 公共信用评价体系指标

		// 经营状况-资质证书列表
		List<Map<String, Object>> certificates = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> certificatesmap = new HashMap<String, Object>();
		certificatesmap.put("type", "信息技术服务管理体系认证");
		certificatesmap.put("certificateFileNumber", "0122018ITSM072R0N");
		certificatesmap.put("certificateDate", "2018-07-31");
		certificatesmap.put("validityDateTo", "2021-07-30");
		certificates.add(certificatesmap);
		dataMap.put("certificates", certificates);
		// 经营状况-税务评级列表
		List<Map<String, Object>> taxEvaluationLevel = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> taxEvaluationLevelmap = new HashMap<String, Object>();
		taxEvaluationLevelmap.put("evaluationAnnual", "2017");
		taxEvaluationLevelmap.put("evaluationLevel", "A");
		taxEvaluationLevelmap.put("companyName", "成都乐超人科技");
		taxEvaluationLevelmap.put("creditNo", "9151010032159783XA");
		taxEvaluationLevel.add(taxEvaluationLevelmap);
		dataMap.put("taxEvaluationLevel", taxEvaluationLevel);

		// 经营风险-行政处罚列表
		List<Map<String, Object>> administrative = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> administrativemap = new HashMap<String, Object>();
		administrativemap.put("penaltyNumber", "高国税 罚 (2017) 983号");
		administrativemap.put("penaltyDesicionDepartment", "成都高新技术产业开发区国家税务局");
		administrativemap.put("penaltyDesicionDate", "2017-09-08");
		administrativemap.put("penaltyContent", "拟罚款2100.00元");
		administrative.add(administrativemap);
		dataMap.put("administrative", administrative);
		// 经营风险-经营异常列表
		List<Map<String, Object>> abnormalInfo = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> abnormalInfomap = new HashMap<String, Object>();
		abnormalInfomap.put("abnormalOperationReason", "未依照《企业信息公示暂行条例》第八条规定的期限公示年度报告");
		abnormalInfomap.put("abnormalOperationDate", "2016-04-01");
		abnormalInfomap.put("moveAbnormalOperationReason",
				"列入经营异常名录3年内且依照《经营异常名录管理办法》第六条规定被列入经营异常名录的企业，可以在补报未报年份的年度报告并公示后，申请移出");
		abnormalInfomap.put("moveDate", "2016-05-11");
		abnormalInfomap.put("decisionDepartmentOut", "高新工商局");
		abnormalInfomap.put("name", "北京万博天地网络技术股份有限公司成都分公司");
		abnormalInfomap.put("decisionDepartmentIn", "高新工商局");
		abnormalInfo.add(abnormalInfomap);
		dataMap.put("abnormalInfo", abnormalInfo);

		// 经营风险-动产抵押列表
		List<Map<String, Object>> chattelMortgage = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> chattelMortgagemap = new HashMap<String, Object>();
		chattelMortgagemap.put("registerNumber", "51012019000820");
		chattelMortgagemap.put("registerDate", "2019-02-2");
		chattelMortgagemap.put("status", null);
		chattelMortgagemap.put("registerDepartment", "四川省成都市高新区市场和质量监督管理");
		chattelMortgagemap.put("securedType", null);
		chattelMortgagemap.put("securedAmount", "721.7万人民币元");
		chattelMortgagemap.put("pefperform", null);
		chattelMortgagemap.put("pefperto", null);
		chattelMortgagemap.put("securedRange", null);

		chattelMortgage.add(chattelMortgagemap);
		dataMap.put("chattelMortgage", chattelMortgage);
		// 经营风险-股权出质信息列表
		List<Map<String, Object>> equityPledged = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> equityPledgedmap = new HashMap<String, Object>();
		equityPledgedmap.put("pledgor", "何泽");
		equityPledgedmap.put("pledgee", "成都工投融资租赁有限公司");
		equityPledgedmap.put("status", "无效");
		equityPledgedmap.put("pledgedRegisterDate", "2011-02-24");

		equityPledged.add(equityPledgedmap);
		dataMap.put("equityPledged", equityPledged);

		// 企业资质-企业年报

		List<Map<String, Object>> enterpriseAnualReport = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> enterpriseAnualReportmap = new HashMap<String, Object>();
		enterpriseAnualReportmap.put("ancheid", "1");
		enterpriseAnualReportmap.put("ancheyear", "2018 年度报告");
		enterpriseAnualReportmap.put("anchedate", "2019-01-02");
		enterpriseAnualReportmap.put("uniscid", "9151010032159783XA");
		enterpriseAnualReportmap.put("entname", "郑州起步网络科技有限公司");
		enterpriseAnualReportmap.put("addr", "河南省郑州市高新区");
		enterpriseAnualReportmap.put("postalcode", "45000");
		enterpriseAnualReportmap.put("tel", "0371-123456");
		enterpriseAnualReportmap.put("email", "123456@163.com");
		enterpriseAnualReportmap.put("busst_cn", "开业");

		enterpriseAnualReportmap.put("empnum", "企业不对外公示");
		enterpriseAnualReportmap.put("dispernum", "企业不对外公示");
		enterpriseAnualReportmap.put("disemplnum", "企业不对外公示");
		enterpriseAnualReportmap.put("colgranum", "企业不对外公示");
		enterpriseAnualReportmap.put("colemplnum", "企业不对外公示");
		enterpriseAnualReportmap.put("retsolnum", "企业不对外公示");
		enterpriseAnualReportmap.put("retemplnum", "企业不对外公示");
		enterpriseAnualReportmap.put("unenum", "企业不对外公示");
		enterpriseAnualReportmap.put("uneemplnum", "企业不对外公示");
		enterpriseAnualReportmap.put("dependententname", "企业不对外公示");

		enterpriseAnualReportmap.put("numparm", "企业不对外公示");

		enterpriseAnualReportmap.put("assgro", "企业不对外公示");
		enterpriseAnualReportmap.put("totequ", "企业不对外公示");
		enterpriseAnualReportmap.put("vendinc", "企业不对外公示");

		enterpriseAnualReportmap.put("progro", "企业不对外公示");
		enterpriseAnualReportmap.put("maibusinc", "企业不对外公示");
		enterpriseAnualReportmap.put("netinc", "企业不对外公示");
		enterpriseAnualReportmap.put("ratgro", "企业不对外公示");
		enterpriseAnualReportmap.put("liagro", "企业不对外公示");
		enterpriseAnualReportmap.put("lastupdatetime", "企业不对外公示");

		HashMap<String, Object> enterpriseAnualReportmap1 = new HashMap<String, Object>();
		enterpriseAnualReportmap1.put("ancheid", "2");
		enterpriseAnualReportmap1.put("ancheyear", "2019年度报告");
		enterpriseAnualReportmap1.put("anchedate", "2020-01-02");
		enterpriseAnualReportmap1.put("uniscid", "9151010032159783XA");
		enterpriseAnualReportmap1.put("entname", "郑州起步网络科技有限公司");
		enterpriseAnualReportmap1.put("addr", "河南省郑州市高新区");
		enterpriseAnualReportmap1.put("postalcode", "45000");
		enterpriseAnualReportmap1.put("tel", "0371-123456");
		enterpriseAnualReportmap1.put("email", "123456@163.com");
		enterpriseAnualReportmap1.put("busst_cn", "开业");

		enterpriseAnualReportmap1.put("empnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("dispernum", "企业不对外公示");
		enterpriseAnualReportmap1.put("disemplnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("colgranum", "企业不对外公示");
		enterpriseAnualReportmap1.put("colemplnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("retsolnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("retemplnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("unenum", "企业不对外公示");
		enterpriseAnualReportmap1.put("uneemplnum", "企业不对外公示");
		enterpriseAnualReportmap1.put("dependententname", "企业不对外公示");

		enterpriseAnualReportmap1.put("numparm", "企业不对外公示");

		enterpriseAnualReportmap1.put("assgro", "企业不对外公示");
		enterpriseAnualReportmap1.put("totequ", "企业不对外公示");
		enterpriseAnualReportmap1.put("vendinc", "企业不对外公示");

		enterpriseAnualReportmap1.put("progro", "企业不对外公示");
		enterpriseAnualReportmap1.put("maibusinc", "企业不对外公示");
		enterpriseAnualReportmap1.put("netinc", "企业不对外公示");
		enterpriseAnualReportmap1.put("ratgro", "企业不对外公示");
		enterpriseAnualReportmap1.put("liagro", "企业不对外公示");
		enterpriseAnualReportmap1.put("lastupdatetime", "企业不对外公示");
		enterpriseAnualReport.add(enterpriseAnualReportmap);
		enterpriseAnualReport.add(enterpriseAnualReportmap1);

		for (Map<String, Object> map : enterpriseAnualReport) {
			if (map.get("ancheid") == "1") {
				ArrayList<Map<String, Object>> annualShareHolderList2 = new ArrayList<Map<String, Object>>();
				HashMap<String, Object> annualShareHolderMap21 = new HashMap<String, Object>();

				annualShareHolderMap21.put("invname", "琳琳");
				annualShareHolderMap21.put("lisubconam", "57.4");
				annualShareHolderMap21.put("subcondate", "2018-07-06");
				annualShareHolderMap21.put("acconform_cn", "货币");
				annualShareHolderMap21.put("accondate", "2018-06-06");
				annualShareHolderMap21.put("liacconam", "57.4");
				HashMap<String, Object> annualShareHolderMap22 = new HashMap<String, Object>();
				annualShareHolderMap22.put("invname", "王五一");
				annualShareHolderMap22.put("lisubconam", "57.4");
				annualShareHolderMap22.put("subcondate", "2018-07-06");
				annualShareHolderMap22.put("acconform_cn", "货币");
				annualShareHolderMap22.put("accondate", "2018-06-06");
				annualShareHolderMap22.put("liacconam", "57.4");
				annualShareHolderList2.add(annualShareHolderMap21);
				annualShareHolderList2.add(annualShareHolderMap22);
				map.put("annualShareHolderList", annualShareHolderList2);

			} else if (map.get("ancheid") == "2") {

				ArrayList<Map<String, Object>> annualShareHolderList = new ArrayList<Map<String, Object>>();
				HashMap<String, Object> annualShareHolderMap1 = new HashMap<String, Object>();
				annualShareHolderMap1.put("invname", "邓丽");
				annualShareHolderMap1.put("lisubconam", "57.4");
				annualShareHolderMap1.put("subcondate", "2018-07-06");
				annualShareHolderMap1.put("acconform_cn", "货币");
				annualShareHolderMap1.put("accondate", "2018-06-06");
				annualShareHolderMap1.put("liacconam", "57.4");
				HashMap<String, Object> annualShareHolderMap2 = new HashMap<String, Object>();
				annualShareHolderMap2.put("invname", "啰里啰嗦");
				annualShareHolderMap2.put("lisubconam", "57.4");
				annualShareHolderMap2.put("subcondate", "2018-07-06");
				annualShareHolderMap2.put("acconform_cn", "货币");
				annualShareHolderMap2.put("accondate", "2018-06-06");
				annualShareHolderMap2.put("liacconam", "57.4");
				annualShareHolderList.add(annualShareHolderMap1);
				annualShareHolderList.add(annualShareHolderMap2);
				map.put("annualShareHolderList", annualShareHolderList);
			}
		}

		dataMap.put("enterpriseAnualReport", enterpriseAnualReport);

		// 商标注册信息
		List<Map<String, Object>> trademarkInfo = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> trademarkInfomap = new HashMap<String, Object>();
		trademarkInfomap.put("regNumber", "5332362");
		trademarkInfo.add(trademarkInfomap);
		dataMap.put("trademarkInfo", trademarkInfo);
		// 股权冻结
		List<Map<String, Object>> equityFreezeInfo = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> equityFreezeInfomap = new HashMap<String, Object>();
		equityFreezeInfomap.put("personSubjectedExecution", "河南省淅川县有色金属压延有限公司");
		equityFreezeInfomap.put("amount", "562");
		equityFreezeInfomap.put("noticeNo", "（2019）豫1325执1243号之六");
		equityFreezeInfomap.put("freezeDateFrom", "2020-03-23");

		equityFreezeInfomap.put("freezeDateTo", "2023-03-22");
		equityFreezeInfomap.put("STATUS", "冻结");
		equityFreezeInfomap.put("executionCourt", "南阳市内乡县人民法院");
		equityFreezeInfomap.put("freezeCurrency", "人民币元");
		equityFreezeInfo.add(equityFreezeInfomap);
		dataMap.put("equityFreezeInfo", equityFreezeInfo);
		// 欠税余额信息
		List<Map<String, Object>> overdueInfo = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> overdueInfomap = new HashMap<String, Object>();
		overdueInfomap.put("overdueAmount", "4157027.21");
		overdueInfomap.put("pubDate", "2017-11-16 00:00:00");

		overdueInfo.add(overdueInfomap);
		dataMap.put("overdueInfo", overdueInfo);
		// 电力欠费信息
		List<Map<String, Object>> powerArrearsInfo = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> powerArrearsInfomap = new HashMap<String, Object>();
		powerArrearsInfomap.put("arrearsDate", "2019-12-23");
		powerArrearsInfomap.put("arrearsDays", "12");
		powerArrearsInfomap.put("arrearsAmount", "3455");
		powerArrearsInfomap.put("znj", "2121");
		powerArrearsInfo.add(powerArrearsInfomap);
		dataMap.put("powerArrearsInfo", powerArrearsInfo);

		// 失信黑明单

		dataMap.put("blacklistDishonestyInfo", "发的发顺丰大是大非");

		// 重大税收违法
		List<Map<String, Object>> majorTaxInfo = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> majorTaxInfomap = new HashMap<String, Object>();
		majorTaxInfomap.put("mainIllegal",
				"经四川省成都高新技术产业开发区国家税务局稽查局检查，发现其在2015年01月01日至2016年06月30日期间，主要存在以下问题：一、非法取得增值税进项发票9份，金额531.11万元，税额90.29万元；二、其他涉税违法问题，涉及税款37.18万元");
		majorTaxInfomap.put("caseNature", "虚开增值税专用发票或者虚开用于骗取出口退税、抵扣税款的其他发票");

		majorTaxInfo.add(majorTaxInfomap);
		dataMap.put("majorTaxInfo", majorTaxInfo);

		/// 企业财报financial/enterpriseInfo/selectEnterpriseFinancialReport

		List<Map<String, Object>> EnterpriseFinancialReport = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> EnterpriseFinancialReportmap1 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap1.put("label", "数据更新日期");
		EnterpriseFinancialReportmap1.put("value", "2020-03-31");
		HashMap<String, Object> EnterpriseFinancialReportmap2 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap2.put("label", "企业纳税识别号");
		EnterpriseFinancialReportmap2.put("value", "sdsdshd2232");

		HashMap<String, Object> EnterpriseFinancialReportmap3 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap3.put("label", "流动资产");
		EnterpriseFinancialReportmap3.put("value", "-");

		HashMap<String, Object> EnterpriseFinancialReportmap4 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap4.put("label", "非流动资产");
		EnterpriseFinancialReportmap4.put("value", "232632.34");

		HashMap<String, Object> EnterpriseFinancialReportmap6 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap6.put("label", "存货");
		EnterpriseFinancialReportmap6.put("value", "3423432");

		HashMap<String, Object> EnterpriseFinancialReportmap7 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap7.put("label", "流动负债");
		EnterpriseFinancialReportmap7.put("value", "343");

		HashMap<String, Object> EnterpriseFinancialReportmap8 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap8.put("label", "非流动负债");
		EnterpriseFinancialReportmap8.put("value", "0");

		HashMap<String, Object> EnterpriseFinancialReportmap9 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap9.put("label", "所有者权益（净资产）");
		EnterpriseFinancialReportmap9.put("value", "323");

		HashMap<String, Object> EnterpriseFinancialReportmap10 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap10.put("label", "利润总额");
		EnterpriseFinancialReportmap10.put("value", "2342342343");

		HashMap<String, Object> EnterpriseFinancialReportmap11 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap11.put("label", "销售收入(主营业务收入)");
		EnterpriseFinancialReportmap11.put("value", "3423432");

		HashMap<String, Object> EnterpriseFinancialReportmap12 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap12.put("label", "销售成本");
		EnterpriseFinancialReportmap12.put("value", "4534543");

		HashMap<String, Object> EnterpriseFinancialReportmap13 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap13.put("label", "研发费用");
		EnterpriseFinancialReportmap13.put("value", "43434");
		HashMap<String, Object> EnterpriseFinancialReportmap14 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap14.put("label", "研发费用占比");
		EnterpriseFinancialReportmap14.put("value", "0.5");
		HashMap<String, Object> EnterpriseFinancialReportmap15 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap15.put("label", "近12个月主营业务收入合计");
		EnterpriseFinancialReportmap15.put("value", "19490559.48");
		HashMap<String, Object> EnterpriseFinancialReportmap16 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap16.put("label", "近12个月月均主营业务收入");
		EnterpriseFinancialReportmap16.put("value", "1624213.29");
		HashMap<String, Object> EnterpriseFinancialReportmap17 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap17.put("label", "近12个月的税金及附加合计");
		EnterpriseFinancialReportmap17.put("value", "19179.68");
		HashMap<String, Object> EnterpriseFinancialReportmap18 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap18.put("label", "近4个季度的净利润是否全部为正");
		EnterpriseFinancialReportmap18.put("value", null);
		HashMap<String, Object> EnterpriseFinancialReportmap19 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap19.put("label", "近2个季度的利润增长率");
		EnterpriseFinancialReportmap19.put("value", "0.0");
		HashMap<String, Object> EnterpriseFinancialReportmap20 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap20.put("label", "经营活动现金净流量");
		EnterpriseFinancialReportmap20.put("value", "0");
		HashMap<String, Object> EnterpriseFinancialReportmap21 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap21.put("label", "欠税查询期间相隔月份数");
		EnterpriseFinancialReportmap21.put("value", "0.0");
		HashMap<String, Object> EnterpriseFinancialReportmap22 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap22.put("label", "查询期间内欠税次数");
		EnterpriseFinancialReportmap22.put("value", "0");
		HashMap<String, Object> EnterpriseFinancialReportmap23 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap23.put("label", "查询期间内欠税总金额");
		EnterpriseFinancialReportmap23.put("value", "0.0");
		HashMap<String, Object> EnterpriseFinancialReportmap24 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap24.put("label", "查询期间内欠税税种数量");
		EnterpriseFinancialReportmap24.put("value", "0");
		HashMap<String, Object> EnterpriseFinancialReportmap25 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap25.put("label", "总资产报酬率");
		EnterpriseFinancialReportmap25.put("value", "0.0");
		HashMap<String, Object> EnterpriseFinancialReportmap26 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap26.put("label", "净资产收益率");
		EnterpriseFinancialReportmap26.put("value", "0");
		HashMap<String, Object> EnterpriseFinancialReportmap27 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap27.put("label", "利润率");
		EnterpriseFinancialReportmap27.put("value", "0.01");
		HashMap<String, Object> EnterpriseFinancialReportmap28 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap28.put("label", "毛利率");
		EnterpriseFinancialReportmap28.put("value", "0.92");
		HashMap<String, Object> EnterpriseFinancialReportmap29 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap29.put("label", "净利率");
		EnterpriseFinancialReportmap29.put("value", "0.0");
		HashMap<String, Object> EnterpriseFinancialReportmap30 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap30.put("label", "产权比率");
		EnterpriseFinancialReportmap30.put("value", "0.0");
		HashMap<String, Object> EnterpriseFinancialReportmap31 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap31.put("label", "流动比率");
		EnterpriseFinancialReportmap31.put("value", "0.0");
		HashMap<String, Object> EnterpriseFinancialReportmap32 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap32.put("label", "速动比率");
		EnterpriseFinancialReportmap32.put("value", "0.0");
		HashMap<String, Object> EnterpriseFinancialReportmap33 = new HashMap<String, Object>();
		EnterpriseFinancialReportmap33.put("label", "总资产周转率");
		EnterpriseFinancialReportmap33.put("value", "0.37");

		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap1);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap2);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap3);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap4);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap6);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap7);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap8);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap9);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap10);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap11);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap12);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap13);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap14);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap15);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap16);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap17);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap18);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap19);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap20);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap21);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap22);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap23);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap24);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap25);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap26);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap27);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap28);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap29);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap30);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap31);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap32);
		EnterpriseFinancialReport.add(EnterpriseFinancialReportmap33);
		dataMap.put("EnterpriseFinancialReport", EnterpriseFinancialReport);

		// 雷达图
		// 公共信用评价体系指标
		ArrayList leidaName = new ArrayList();
		leidaName.add("企业资质");
		leidaName.add("经营状况");
		leidaName.add("经营风险");
		leidaName.add("财务信用");
		leidaName.add("创新和发展能力");
		ArrayList leidaValue = new ArrayList();
		leidaValue.add("90.60");
		leidaValue.add("81.03");
		leidaValue.add("100.00");
		leidaValue.add("60.00");
		leidaValue.add("100.00");

		dataMap.put("leidaName", leidaName.toString());
		dataMap.put("leidaValue", leidaValue.toString());
		// 报告概述
		HashMap<String, Object> reportSummaryMap = new HashMap<String, Object>();
		reportSummaryMap.put("companyName", "成都索贝数码科技股份有限公司");
		reportSummaryMap.put("operateStatus", "存续(在营、开业、在册)");

		reportSummaryMap.put("creditRating", "3.5");
		reportSummaryMap.put("ranking", "28388");

		reportSummaryMap.put("rankingDescribe", "高于72.34%同行业企业");

		reportSummaryMap.put("totalScore", "75.01");

		reportSummaryMap.put("unifiedSocialCreditCode", "91510100709253064R");

		reportSummaryMap.put("operName", "姚平");

		reportSummaryMap.put("registeredCapital", "8000万元人民币");

		reportSummaryMap.put("enterpriseAddress", "四川省成都市高新区新园南二路2号");

		reportSummaryMap.put("foundingDate", "2003-06-09");
		reportSummaryMap.put("comprehensiveEvaluation",
				"该企业当前信用分值84.02分，信用等级5星，信用优良。该企业信用分整体排名1515，高于93.15%同行业企业（制造业）。");
		reportSummaryMap.put("companyTrade", "制造业");
		ArrayList<Map<String, String>> cognizance = new ArrayList<Map<String, String>>();

		HashMap<String, String> cognizanceMap1 = new HashMap<String, String>();
		cognizanceMap1.put("cognizance", "检验检疫报检企业备案表（自理）");

		HashMap<String, String> cognizanceMap2 = new HashMap<String, String>();
		cognizanceMap2.put("cognizance", "计算机信息系统集成企业资质一级");

		HashMap<String, String> cognizanceMap3 = new HashMap<String, String>();
		cognizanceMap3.put("cognizance", "高新技术企业认定");
		cognizance.add(cognizanceMap3);
		cognizance.add(cognizanceMap2);
		cognizance.add(cognizanceMap1);
		reportSummaryMap.put("cognizance", cognizance);
		dataMap.putAll(reportSummaryMap);

		// 资产负债
		HashMap<String, Object> assetLiabilityMap1 = new HashMap<String, Object>();
		assetLiabilityMap1.put("column0", "年度");
		assetLiabilityMap1.put("column1", "2019");
		assetLiabilityMap1.put("column11", "变化率 (%)");
		assetLiabilityMap1.put("column2", "2018");
		assetLiabilityMap1.put("column21", "变化率 (%)");
		assetLiabilityMap1.put("column3", "2017");

		HashMap<String, Object> assetLiabilityMap2 = new HashMap<String, Object>();
		assetLiabilityMap2.put("column0", "&nbsp&nbsp货币资金");
		assetLiabilityMap2.put("column1", "74433090.81");
		assetLiabilityMap2.put("column11", "-");
		assetLiabilityMap2.put("column2", "77611466.97");
		assetLiabilityMap2.put("column21", "199.39%");
		assetLiabilityMap2.put("column3", "25922829.86");
		assetLiabilityMap2.put("type", "0");
		HashMap<String, Object> assetLiabilityMap21 = new HashMap<String, Object>();
		assetLiabilityMap21.put("column0", "&nbsp&nbsp短期投资");
		assetLiabilityMap21.put("column1", "74433090.81");
		assetLiabilityMap21.put("column11", "-");
		assetLiabilityMap21.put("column2", "77611466.97");
		assetLiabilityMap21.put("column21", "0");
		assetLiabilityMap21.put("column3", "25922829.86");
		assetLiabilityMap21.put("type", "0");
		HashMap<String, Object> assetLiabilityMap22 = new HashMap<String, Object>();
		assetLiabilityMap22.put("column0", "&nbsp&nbsp应收票据");
		assetLiabilityMap22.put("column1", "74433090.81");
		assetLiabilityMap22.put("column11", "-");
		assetLiabilityMap22.put("column2", "77611466.97");
		assetLiabilityMap22.put("column21", "0");
		assetLiabilityMap22.put("column3", "25922829.86");
		assetLiabilityMap22.put("type", "0");
		HashMap<String, Object> assetLiabilityMap23 = new HashMap<String, Object>();
		assetLiabilityMap23.put("column0", "&nbsp&nbsp应收股利");
		assetLiabilityMap23.put("column1", "74433090.81");
		assetLiabilityMap23.put("column11", "-");
		assetLiabilityMap23.put("column2", "77611466.97");
		assetLiabilityMap23.put("column21", "0");
		assetLiabilityMap23.put("column3", "25922829.86");
		assetLiabilityMap23.put("type", "0");
		HashMap<String, Object> assetLiabilityMap3 = new HashMap<String, Object>();
		assetLiabilityMap3.put("column0", "流动资产合计");
		assetLiabilityMap3.put("column1", "10334962.87");
		assetLiabilityMap3.put("column11", "0");
		assetLiabilityMap3.put("column2", "6138889.52");
		assetLiabilityMap3.put("column21", "0.00%");
		assetLiabilityMap3.put("column3", "4806664.87");
		assetLiabilityMap3.put("type", "1");
		HashMap<String, Object> assetLiabilityMap4 = new HashMap<String, Object>();
		assetLiabilityMap4.put("column0", "  &nbsp&nbsp长期投资");
		assetLiabilityMap4.put("column1", "10334962.87");
		assetLiabilityMap4.put("column11", "0");
		assetLiabilityMap4.put("column2", "6138889.52");
		assetLiabilityMap4.put("column21", "27.72%");
		assetLiabilityMap4.put("column3", "4806664.87");
		assetLiabilityMap4.put("type", "0");
		HashMap<String, Object> assetLiabilityMap41 = new HashMap<String, Object>();
		assetLiabilityMap41.put("column0", "  &nbsp&nbsp长期债权投资");
		assetLiabilityMap41.put("column1", "10334962.87");
		assetLiabilityMap41.put("column11", "0");
		assetLiabilityMap41.put("column2", "6138889.52");
		assetLiabilityMap41.put("column21", "27.72%");
		assetLiabilityMap41.put("column3", "4806664.87");
		assetLiabilityMap41.put("type", "0");
		HashMap<String, Object> assetLiabilityMap42 = new HashMap<String, Object>();
		assetLiabilityMap42.put("column0", "  &nbsp&nbsp在建工程");
		assetLiabilityMap42.put("column1", "10334962.87");
		assetLiabilityMap42.put("column11", "-");
		assetLiabilityMap42.put("column2", "6138889.52");
		assetLiabilityMap42.put("column21", "0");
		assetLiabilityMap42.put("column3", "4806664.87");
		assetLiabilityMap42.put("type", "0");
		HashMap<String, Object> assetLiabilityMap43 = new HashMap<String, Object>();
		assetLiabilityMap43.put("column0", "&nbsp&nbsp固定资产清理");
		assetLiabilityMap43.put("column1", "10334962.87");
		assetLiabilityMap43.put("column11", "0.00%");
		assetLiabilityMap43.put("column2", "6138889.52");
		assetLiabilityMap43.put("column21", "0.00%");
		assetLiabilityMap43.put("column3", "4806664.87");
		assetLiabilityMap43.put("type", "0");
		HashMap<String, Object> assetLiabilityMap5 = new HashMap<String, Object>();
		assetLiabilityMap5.put("column0", "非流动资产合计");
		assetLiabilityMap5.put("column1", "10334962.87");
		assetLiabilityMap5.put("column11", "-");
		assetLiabilityMap5.put("column2", "6138889.52");
		assetLiabilityMap5.put("column21", "0");
		assetLiabilityMap5.put("column3", "4806664.87");
		assetLiabilityMap5.put("type", "1");
		HashMap<String, Object> assetLiabilityMap6 = new HashMap<String, Object>();
		assetLiabilityMap6.put("column0", "资产合计");
		assetLiabilityMap6.put("column1", "10334962.87");
		assetLiabilityMap6.put("column11", "0.00%");
		assetLiabilityMap6.put("column2", "6138889.52");
		assetLiabilityMap6.put("column21", "-");
		assetLiabilityMap6.put("column3", "4806664.87");
		assetLiabilityMap6.put("type", "1");
		ArrayList<Map<String, Object>> assetLiability = new ArrayList<Map<String, Object>>();
		assetLiability.add(assetLiabilityMap1);
		assetLiability.add(assetLiabilityMap2);
		assetLiability.add(assetLiabilityMap21);
		assetLiability.add(assetLiabilityMap22);
		assetLiability.add(assetLiabilityMap23);
		assetLiability.add(assetLiabilityMap3);
		assetLiability.add(assetLiabilityMap4);
		assetLiability.add(assetLiabilityMap41);
		assetLiability.add(assetLiabilityMap42);
		assetLiability.add(assetLiabilityMap43);

		assetLiability.add(assetLiabilityMap5);
		assetLiability.add(assetLiabilityMap6);

		dataMap.put("assetLiability", assetLiability);
		// 负债及股东权益
		HashMap<String, Object> shareholderEquityMap1 = new HashMap<String, Object>();
		shareholderEquityMap1.put("column0", "年度");
		shareholderEquityMap1.put("column1", "2019");
		shareholderEquityMap1.put("column11", "变化率 (%)");
		shareholderEquityMap1.put("column2", "2018");
		shareholderEquityMap1.put("column21", "变化率 (%)");
		shareholderEquityMap1.put("column3", "2017");

		HashMap<String, Object> shareholderEquityMap2 = new HashMap<String, Object>();
		shareholderEquityMap2.put("column0", "&nbsp&nbsp短期贷款");
		shareholderEquityMap2.put("column1", "74433090.81");
		shareholderEquityMap2.put("column11", "0");
		shareholderEquityMap2.put("column2", "77611466.97");
		shareholderEquityMap2.put("column21", "-");
		shareholderEquityMap2.put("column3", "25922829.86");
		shareholderEquityMap2.put("type", "0");
		HashMap<String, Object> shareholderEquityMap21 = new HashMap<String, Object>();
		shareholderEquityMap21.put("column0", "&nbsp&nbsp应付票据");
		shareholderEquityMap21.put("column1", "74433090.81");
		shareholderEquityMap21.put("column11", "-");
		shareholderEquityMap21.put("column2", "77611466.97");
		shareholderEquityMap21.put("column21", "0");
		shareholderEquityMap21.put("column3", "25922829.86");
		shareholderEquityMap21.put("type", "0");
		HashMap<String, Object> shareholderEquityMap22 = new HashMap<String, Object>();
		shareholderEquityMap22.put("column0", "&nbsp&nbsp应付账款");
		shareholderEquityMap22.put("column1", "74433090.81");
		shareholderEquityMap22.put("column11", "0.00%");
		shareholderEquityMap22.put("column2", "77611466.97");
		shareholderEquityMap22.put("column21", "0");
		shareholderEquityMap22.put("column3", "25922829.86");
		shareholderEquityMap22.put("type", "0");
		HashMap<String, Object> shareholderEquityMap23 = new HashMap<String, Object>();
		shareholderEquityMap23.put("column0", "&nbsp&nbsp应付税金");
		shareholderEquityMap23.put("column1", "74433090.81");
		shareholderEquityMap23.put("column11", "0.00%");
		shareholderEquityMap23.put("column2", "77611466.97");
		shareholderEquityMap23.put("column21", "0.00%");
		shareholderEquityMap23.put("column3", "25922829.86");
		shareholderEquityMap23.put("type", "0");
		HashMap<String, Object> shareholderEquityMap3 = new HashMap<String, Object>();
		shareholderEquityMap3.put("column0", "流动负债合计");
		shareholderEquityMap3.put("column1", "10334962.87");
		shareholderEquityMap3.put("column11", "0");
		shareholderEquityMap3.put("column2", "6138889.52");
		shareholderEquityMap3.put("column21", "27.72%");
		shareholderEquityMap3.put("column3", "4806664.87");
		shareholderEquityMap3.put("type", "1");
		HashMap<String, Object> shareholderEquityMap4 = new HashMap<String, Object>();
		shareholderEquityMap4.put("column0", "&nbsp&nbsp长期负债");
		shareholderEquityMap4.put("column1", "74433090.81");
		shareholderEquityMap4.put("column11", "-4.10%");
		shareholderEquityMap4.put("column2", "77611466.97");
		shareholderEquityMap4.put("column21", "0");
		shareholderEquityMap4.put("column3", "25922829.86");
		shareholderEquityMap4.put("type", "0");
		HashMap<String, Object> shareholderEquityMap41 = new HashMap<String, Object>();
		shareholderEquityMap41.put("column0", "&nbsp&nbsp长期负债");
		shareholderEquityMap41.put("column1", "74433090.81");
		shareholderEquityMap41.put("column11", "0");
		shareholderEquityMap41.put("column2", "77611466.97");
		shareholderEquityMap41.put("column21", "199.39%");
		shareholderEquityMap41.put("column3", "25922829.86");
		shareholderEquityMap41.put("type", "0");
		HashMap<String, Object> shareholderEquityMap42 = new HashMap<String, Object>();
		shareholderEquityMap42.put("column0", "&nbsp&nbsp递延税款贷项");
		shareholderEquityMap42.put("column1", "74433090.81");
		shareholderEquityMap42.put("column11", "-4.10%");
		shareholderEquityMap42.put("column2", "77611466.97");
		shareholderEquityMap42.put("column21", "199.39%");
		shareholderEquityMap42.put("column3", "25922829.86");
		shareholderEquityMap42.put("type", "0");
		HashMap<String, Object> shareholderEquityMap43 = new HashMap<String, Object>();
		shareholderEquityMap43.put("column0", "&nbsp&nbsp其他负债");
		shareholderEquityMap43.put("column1", "74433090.81");
		shareholderEquityMap43.put("column11", "-4.10%");
		shareholderEquityMap43.put("column2", "77611466.97");
		shareholderEquityMap43.put("column21", "0");
		shareholderEquityMap43.put("column3", "25922829.86");
		shareholderEquityMap43.put("type", "0");
		HashMap<String, Object> shareholderEquityMap5 = new HashMap<String, Object>();
		shareholderEquityMap5.put("column0", "非流动负债合计");
		shareholderEquityMap5.put("column1", "10334962.87");
		shareholderEquityMap5.put("column11", "0.00%");
		shareholderEquityMap5.put("column2", "6138889.52");
		shareholderEquityMap5.put("column21", "0");
		shareholderEquityMap5.put("column3", "4806664.87");
		shareholderEquityMap5.put("type", "1");
		HashMap<String, Object> shareholderEquityMap6 = new HashMap<String, Object>();
		shareholderEquityMap6.put("column0", "负债合计");
		shareholderEquityMap6.put("column1", "10334962.87");
		shareholderEquityMap6.put("column11", "-");
		shareholderEquityMap6.put("column2", "6138889.52");
		shareholderEquityMap6.put("column21", "-");
		shareholderEquityMap6.put("column3", "4806664.87");
		shareholderEquityMap6.put("type", "1");
		HashMap<String, Object> shareholderEquityMap7 = new HashMap<String, Object>();
		shareholderEquityMap7.put("column0", "&nbsp&nbsp实收资本");
		shareholderEquityMap7.put("column1", "74433090.81");
		shareholderEquityMap7.put("column11", "-4.10%");
		shareholderEquityMap7.put("column2", "77611466.97");
		shareholderEquityMap7.put("column21", "0");
		shareholderEquityMap7.put("column3", "25922829.86");
		shareholderEquityMap7.put("type", "0");
		HashMap<String, Object> shareholderEquityMap71 = new HashMap<String, Object>();
		shareholderEquityMap71.put("column0", "&nbsp&nbsp资本公积");
		shareholderEquityMap71.put("column1", "74433090.81");
		shareholderEquityMap71.put("column11", "0");
		shareholderEquityMap71.put("column2", "77611466.97");
		shareholderEquityMap71.put("column21", "199.39%");
		shareholderEquityMap71.put("column3", "25922829.86");
		shareholderEquityMap71.put("type", "0");
		HashMap<String, Object> shareholderEquityMap72 = new HashMap<String, Object>();
		shareholderEquityMap72.put("column0", "&nbsp&nbsp盈余公积");
		shareholderEquityMap72.put("column1", "74433090.81");
		shareholderEquityMap72.put("column11", "-4.10%");
		shareholderEquityMap72.put("column2", "77611466.97");
		shareholderEquityMap72.put("column21", "0");
		shareholderEquityMap72.put("column3", "25922829.86");
		shareholderEquityMap72.put("type", "0");
		HashMap<String, Object> shareholderEquityMap8 = new HashMap<String, Object>();
		shareholderEquityMap8.put("column0", "所有者权益合计");
		shareholderEquityMap8.put("column1", "10334962.87");
		shareholderEquityMap8.put("column11", "-");
		shareholderEquityMap8.put("column2", "6138889.52");
		shareholderEquityMap8.put("column21", "0.00%");
		shareholderEquityMap8.put("column3", "4806664.87");
		shareholderEquityMap8.put("type", "1");
		HashMap<String, Object> shareholderEquityMap9 = new HashMap<String, Object>();
		shareholderEquityMap9.put("column0", "负债及所有者权益合计");
		shareholderEquityMap9.put("column1", "10334962.87");
		shareholderEquityMap9.put("column11", "68.35%");
		shareholderEquityMap9.put("column2", "6138889.52");
		shareholderEquityMap9.put("column21", "27.72%");
		shareholderEquityMap9.put("column3", "4806664.87");
		shareholderEquityMap9.put("type", "1");
		ArrayList<Map<String, Object>> shareholderEquity = new ArrayList<Map<String, Object>>();
		shareholderEquity.add(shareholderEquityMap1);
		shareholderEquity.add(shareholderEquityMap2);
		shareholderEquity.add(shareholderEquityMap21);
		shareholderEquity.add(shareholderEquityMap22);
		shareholderEquity.add(shareholderEquityMap23);

		shareholderEquity.add(shareholderEquityMap3);
		shareholderEquity.add(shareholderEquityMap4);
		shareholderEquity.add(shareholderEquityMap41);
		shareholderEquity.add(shareholderEquityMap42);
		shareholderEquity.add(shareholderEquityMap43);

		shareholderEquity.add(shareholderEquityMap5);
		shareholderEquity.add(shareholderEquityMap6);
		shareholderEquity.add(shareholderEquityMap7);
		shareholderEquity.add(shareholderEquityMap71);
		shareholderEquity.add(shareholderEquityMap72);

		shareholderEquity.add(shareholderEquityMap8);
		shareholderEquity.add(shareholderEquityMap9);

		dataMap.put("shareholderEquity", shareholderEquity);

		// 损益
		HashMap<String, Object> enterpriseGainsAndLossesReportMap1 = new HashMap<String, Object>();

		enterpriseGainsAndLossesReportMap1.put("column0", "年度");
		enterpriseGainsAndLossesReportMap1.put("column1", "2019-12-23");
		enterpriseGainsAndLossesReportMap1.put("column2", "变化率 (%)");
		enterpriseGainsAndLossesReportMap1.put("column3", "2018-09-03");
		enterpriseGainsAndLossesReportMap1.put("column4", "变化率 (%)");
		enterpriseGainsAndLossesReportMap1.put("column5", "2017-11-23");
		enterpriseGainsAndLossesReportMap1.put("column6", "变化率 (%)");

		HashMap<String, Object> enterpriseGainsAndLossesReportMap2 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap2.put("column0", "主营业务收入");
		enterpriseGainsAndLossesReportMap2.put("column1", "74433090.81");
		enterpriseGainsAndLossesReportMap2.put("column2", "0");
		enterpriseGainsAndLossesReportMap2.put("column3", "77611466.97");
		enterpriseGainsAndLossesReportMap2.put("column4", "-");
		enterpriseGainsAndLossesReportMap2.put("column5", "25922829.86");
		enterpriseGainsAndLossesReportMap2.put("column6", "-");
		enterpriseGainsAndLossesReportMap2.put("type", "1");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap3 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap3.put("column0", "&nbsp&nbsp减:主营业务成本");
		enterpriseGainsAndLossesReportMap3.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap3.put("column2", "0.00%");
		enterpriseGainsAndLossesReportMap3.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap3.put("column4", "0");
		enterpriseGainsAndLossesReportMap3.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap3.put("column6", "0");
		enterpriseGainsAndLossesReportMap3.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap4 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap4.put("column0", "&nbsp&nbsp减:主营业务税金及附加");
		enterpriseGainsAndLossesReportMap4.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap4.put("column2", "0.00%");
		enterpriseGainsAndLossesReportMap4.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap4.put("column4", "-");
		enterpriseGainsAndLossesReportMap4.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap4.put("column6", "0.00%");
		enterpriseGainsAndLossesReportMap4.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap5 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap5.put("column0", "主营业务利润");
		enterpriseGainsAndLossesReportMap5.put("column1", "74433090.81");
		enterpriseGainsAndLossesReportMap5.put("column2", "-");
		enterpriseGainsAndLossesReportMap5.put("column3", "77611466.97");
		enterpriseGainsAndLossesReportMap5.put("column4", "0.00%");
		enterpriseGainsAndLossesReportMap5.put("column5", "25922829.86");
		enterpriseGainsAndLossesReportMap5.put("column6", "-");
		enterpriseGainsAndLossesReportMap5.put("type", "1");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap6 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap6.put("column0", "&nbsp&nbsp加:其他业务利润");
		enterpriseGainsAndLossesReportMap6.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap6.put("column2", "68.35%");
		enterpriseGainsAndLossesReportMap6.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap6.put("column4", "0");
		enterpriseGainsAndLossesReportMap6.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap6.put("column6", "27.72%");
		enterpriseGainsAndLossesReportMap6.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap7 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap7.put("column0", "&nbsp&nbsp减:营业费用");
		enterpriseGainsAndLossesReportMap7.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap7.put("column2", "68.35%");
		enterpriseGainsAndLossesReportMap7.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap7.put("column4", "27.72%");
		enterpriseGainsAndLossesReportMap7.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap7.put("column6", "0");
		enterpriseGainsAndLossesReportMap7.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap8 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap8.put("column0", "&nbsp&nbsp减:管理费用");
		enterpriseGainsAndLossesReportMap8.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap8.put("column2", "-");
		enterpriseGainsAndLossesReportMap8.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap8.put("column4", "0.00%");
		enterpriseGainsAndLossesReportMap8.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap8.put("column6", "0");
		enterpriseGainsAndLossesReportMap8.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap9 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap9.put("column0", "&nbsp&nbsp减:财务费用");
		enterpriseGainsAndLossesReportMap9.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap9.put("column2", "0");
		enterpriseGainsAndLossesReportMap9.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap9.put("column4", "0");
		enterpriseGainsAndLossesReportMap9.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap9.put("column6", "0");
		enterpriseGainsAndLossesReportMap9.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap10 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap10.put("column0", "营业利润");
		enterpriseGainsAndLossesReportMap10.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap10.put("column2", "68.35%");
		enterpriseGainsAndLossesReportMap10.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap10.put("column4", "27.72%");
		enterpriseGainsAndLossesReportMap10.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap10.put("column6", "27.72%");
		enterpriseGainsAndLossesReportMap10.put("type", "1");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap11 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap11.put("column0", "&nbsp&nbsp加:投资损益");
		enterpriseGainsAndLossesReportMap11.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap11.put("column2", "68.35%");
		enterpriseGainsAndLossesReportMap11.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap11.put("column4", "27.72%");
		enterpriseGainsAndLossesReportMap11.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap11.put("column6", "27.72%");
		enterpriseGainsAndLossesReportMap11.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap12 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap12.put("column0", "&nbsp&nbsp加:补贴收入");
		enterpriseGainsAndLossesReportMap12.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap12.put("column2", "-");
		enterpriseGainsAndLossesReportMap12.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap12.put("column4", "-");
		enterpriseGainsAndLossesReportMap12.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap12.put("column6", "-");
		enterpriseGainsAndLossesReportMap12.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap13 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap13.put("column0", "&nbsp&nbsp减:资产减值损失");
		enterpriseGainsAndLossesReportMap13.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap13.put("column2", "-");
		enterpriseGainsAndLossesReportMap13.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap13.put("column4", "-");
		enterpriseGainsAndLossesReportMap13.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap13.put("column6", "-");
		enterpriseGainsAndLossesReportMap13.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap14 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap14.put("column0", "&nbsp&nbsp加: 营业外收入");
		enterpriseGainsAndLossesReportMap14.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap14.put("column2", "68.35%");
		enterpriseGainsAndLossesReportMap14.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap14.put("column4", "27.72%");
		enterpriseGainsAndLossesReportMap14.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap14.put("column6", "27.72%");
		enterpriseGainsAndLossesReportMap14.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap15 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap15.put("column0", "&nbsp&nbsp减:营业外支出");
		enterpriseGainsAndLossesReportMap15.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap15.put("column2", "0");
		enterpriseGainsAndLossesReportMap15.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap15.put("column4", "0");
		enterpriseGainsAndLossesReportMap15.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap15.put("column6", "0");
		enterpriseGainsAndLossesReportMap15.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap16 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap16.put("column0", "利润总额");
		enterpriseGainsAndLossesReportMap16.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap16.put("column2", "68.35%");
		enterpriseGainsAndLossesReportMap16.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap16.put("column4", "27.72%");
		enterpriseGainsAndLossesReportMap16.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap16.put("column6", "27.72%");
		enterpriseGainsAndLossesReportMap16.put("type", "1");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap17 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap17.put("column0", "&nbsp&nbsp减:所得税");
		enterpriseGainsAndLossesReportMap17.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap17.put("column2", "68.35%");
		enterpriseGainsAndLossesReportMap17.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap17.put("column4", "27.72%");
		enterpriseGainsAndLossesReportMap17.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap17.put("column6", "27.72%");
		enterpriseGainsAndLossesReportMap17.put("type", "0");
		HashMap<String, Object> enterpriseGainsAndLossesReportMap18 = new HashMap<String, Object>();
		enterpriseGainsAndLossesReportMap18.put("column0", "净利润");
		enterpriseGainsAndLossesReportMap18.put("column1", "10334962.87");
		enterpriseGainsAndLossesReportMap18.put("column2", "68.35%");
		enterpriseGainsAndLossesReportMap18.put("column3", "6138889.52");
		enterpriseGainsAndLossesReportMap18.put("column4", "27.72%");
		enterpriseGainsAndLossesReportMap18.put("column5", "4806664.87");
		enterpriseGainsAndLossesReportMap18.put("column6", "27.72%");
		enterpriseGainsAndLossesReportMap18.put("type", "1");
		ArrayList<Map<String, Object>> enterpriseGainsAndLosses = new ArrayList<Map<String, Object>>();
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap1);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap2);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap3);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap4);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap5);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap6);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap7);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap8);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap9);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap10);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap11);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap12);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap13);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap14);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap15);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap16);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap17);
		enterpriseGainsAndLosses.add(enterpriseGainsAndLossesReportMap18);
		dataMap.put("enterpriseGainsAndLosses", enterpriseGainsAndLosses);

		// 公司雇员/financial/enterpriseInfo/selectEnterpriseEmployees
		HashMap<String, Object> EnterpriseEmployeesMap1 = new HashMap<String, Object>();
		EnterpriseEmployeesMap1.put("column0", "年度");
		EnterpriseEmployeesMap1.put("column1", "2019");
		EnterpriseEmployeesMap1.put("column2", "2018");
		EnterpriseEmployeesMap1.put("column3", "2017");

		HashMap<String, Object> EnterpriseEmployeesMap2 = new HashMap<String, Object>();
		EnterpriseEmployeesMap2.put("column0", "从业人员");
		EnterpriseEmployeesMap2.put("column1", "73");
		EnterpriseEmployeesMap2.put("column2", "-");
		EnterpriseEmployeesMap2.put("column3", "-");
		HashMap<String, Object> EnterpriseEmployeesMap3 = new HashMap<String, Object>();
		EnterpriseEmployeesMap3.put("column0", "党员（预备党员）人数");
		EnterpriseEmployeesMap3.put("column1", "56");
		EnterpriseEmployeesMap3.put("column2", "45");
		EnterpriseEmployeesMap3.put("column3", "-");
		HashMap<String, Object> EnterpriseEmployeesMap4 = new HashMap<String, Object>();
		EnterpriseEmployeesMap4.put("column0", "其中残疾人人数（经营者）");
		EnterpriseEmployeesMap4.put("column1", "56");
		EnterpriseEmployeesMap4.put("column2", "45");
		EnterpriseEmployeesMap4.put("column3", "-");
		HashMap<String, Object> EnterpriseEmployeesMap5 = new HashMap<String, Object>();
		EnterpriseEmployeesMap5.put("column0", "其中残疾人人数（雇员）");
		EnterpriseEmployeesMap5.put("column1", "34");
		EnterpriseEmployeesMap5.put("column2", "45");
		EnterpriseEmployeesMap5.put("column3", "-");
		HashMap<String, Object> EnterpriseEmployeesMap6 = new HashMap<String, Object>();
		EnterpriseEmployeesMap6.put("column0", "其中高校毕业生人数（经营者）");
		EnterpriseEmployeesMap6.put("column1", "-");
		EnterpriseEmployeesMap6.put("column2", "45");
		EnterpriseEmployeesMap6.put("column3", "-");
		ArrayList<Map<String, Object>> enterpriseEmployees = new ArrayList<Map<String, Object>>();
		enterpriseEmployees.add(EnterpriseEmployeesMap1);
		enterpriseEmployees.add(EnterpriseEmployeesMap2);
		enterpriseEmployees.add(EnterpriseEmployeesMap3);
		enterpriseEmployees.add(EnterpriseEmployeesMap4);
		enterpriseEmployees.add(EnterpriseEmployeesMap5);
		enterpriseEmployees.add(EnterpriseEmployeesMap6);
		dataMap.put("enterpriseEmployees", enterpriseEmployees);

		// 财务分析selectAnalysis
		HashMap<String, Object> AnalysisMap1 = new HashMap<String, Object>();
		AnalysisMap1.put("column0", "年份");
		AnalysisMap1.put("column1", "2019-02-04");
		AnalysisMap1.put("column2", "2018-04-23");
		AnalysisMap1.put("column3", "2017-06-11");
		HashMap<String, Object> AnalysisMap2 = new HashMap<String, Object>();
		AnalysisMap2.put("column0", "资产回报率 (%)");
		AnalysisMap2.put("column1", "9.2");
		AnalysisMap2.put("column2", "40.19");
		AnalysisMap2.put("column3", "20.34");
		HashMap<String, Object> AnalysisMap3 = new HashMap<String, Object>();
		AnalysisMap3.put("column0", "利润率 (%)");
		AnalysisMap3.put("column1", "9.2");
		AnalysisMap3.put("column2", "40.19");
		AnalysisMap3.put("column3", "20.34");
		HashMap<String, Object> AnalysisMap4 = new HashMap<String, Object>();
		AnalysisMap4.put("column0", "毛利率 (%)");
		AnalysisMap4.put("column1", "9.2");
		AnalysisMap4.put("column2", "40.19");
		AnalysisMap4.put("column3", "20.34");
		HashMap<String, Object> AnalysisMap5 = new HashMap<String, Object>();
		AnalysisMap5.put("column0", "存货周转期 (天)");
		AnalysisMap5.put("column1", "9");
		AnalysisMap5.put("column2", "40");
		AnalysisMap5.put("column3", "20");
		HashMap<String, Object> AnalysisMap6 = new HashMap<String, Object>();
		AnalysisMap6.put("column0", "应付帐款周转期 (天)");
		AnalysisMap6.put("column1", "22");
		AnalysisMap6.put("column2", "19");
		AnalysisMap6.put("column3", "34");
		HashMap<String, Object> AnalysisMap7 = new HashMap<String, Object>();
		AnalysisMap7.put("column0", "流动比率 (%)");
		AnalysisMap7.put("column1", "9.2");
		AnalysisMap7.put("column2", "40.19");
		AnalysisMap7.put("column3", "20.34");

		ArrayList<Map<String, Object>> analysis = new ArrayList<Map<String, Object>>();
		analysis.add(AnalysisMap1);
		analysis.add(AnalysisMap2);
		analysis.add(AnalysisMap3);
		analysis.add(AnalysisMap4);

		analysis.add(AnalysisMap5);
		analysis.add(AnalysisMap6);
		analysis.add(AnalysisMap7);

		dataMap.put("analysis", analysis);

		HashMap<String, Object> vaTinvoiceMap = new HashMap<String, Object>();

		/*
		 * vaTinvoiceMap.put("pQymc", "光山依诺贸易有限公司"); vaTinvoiceMap.put("pShxydm",
		 * "91320508MA1NUHFU0C"); vaTinvoiceMap.put("xse", "66373.9");
		 * vaTinvoiceMap.put("invoice", "2019");
		 */
		dataMap.put("vaTinvoice", vaTinvoiceMap);
		return dataMap;
	}

}
