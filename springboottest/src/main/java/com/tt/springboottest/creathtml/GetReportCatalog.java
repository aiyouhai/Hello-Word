package com.tt.springboottest.creathtml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetReportCatalog {
	public static HashMap<String, Object> getPublicCtreadCatalog() {
		HashMap<String, Object> CatalogMap = new HashMap<String, Object>();
		List<Map<String, Object>> muluList = new ArrayList<Map<String, Object>>();
		// 报告概述
		Map<String, Object> parentMap = new HashMap<String, Object>();
		parentMap.put("name", "一、报告概述");
		muluList.add(parentMap);
		// 基本信息
		Map<String, Object> parentMap1 = new HashMap<String, Object>();
		List<Map<String, String>> subList1 = new ArrayList<Map<String, String>>();
		Map<String, String> subMap1 = new HashMap<String, String>();
		subMap1.put("name", "（一）工商信息");
		subList1.add(subMap1);
		Map<String, String> subMap2 = new HashMap<String, String>();
		subMap2.put("name", "（二）主要人员");
		subList1.add(subMap2);
		Map<String, String> subMap3 = new HashMap<String, String>();
		subMap3.put("name", "（三）变更备案信息");
		subList1.add(subMap3);

		Map<String, String> subMap4 = new HashMap<String, String>();
		subMap4.put("name", "（四）企业财报");
		subList1.add(subMap4);
		Map<String, String> subMap5 = new HashMap<String, String>();
		subMap5.put("name", "（五）企业年报");
		subList1.add(subMap5);

		parentMap1.put("name", "二、基本信息");
		parentMap1.put("children", subList1);
		muluList.add(parentMap1);

		// 资质证书
		Map<String, Object> parentMap51 = new HashMap<String, Object>();
		List<Map<String, String>> subList51 = new ArrayList<Map<String, String>>();
		Map<String, String> subMap52 = new HashMap<String, String>();
		subMap52.put("name", "（一）商标注册信息");
		subList51.add(subMap52);
		Map<String, String> subMap53 = new HashMap<String, String>();
		subMap53.put("name", "（二）证书信息");
		subList51.add(subMap53);

		parentMap51.put("name", "三、资质证书");
		parentMap51.put("children", subList51);
		muluList.add(parentMap51);

		// 经营风险
		Map<String, Object> parentMap21 = new HashMap<String, Object>();
		List<Map<String, String>> subList21 = new ArrayList<Map<String, String>>();
		Map<String, String> subMap21 = new HashMap<String, String>();
		subMap21.put("name", "（一）股权出质登记信息");
		subList21.add(subMap21);
		Map<String, String> subMap22 = new HashMap<String, String>();
		subMap22.put("name", "（二）动产抵押登记信息");
		subList21.add(subMap22);
		Map<String, String> subMap23 = new HashMap<String, String>();
		subMap23.put("name", "（三）动产抵押被担保主债权");
		subList21.add(subMap23);
		Map<String, String> subMap24 = new HashMap<String, String>();
		subMap24.put("name", "（四）股权冻结信息");
		subList21.add(subMap24);
		Map<String, String> subMap25 = new HashMap<String, String>();
		subMap25.put("name", "（五）欠税余额信息");
		subList21.add(subMap25);
		Map<String, String> subMap26 = new HashMap<String, String>();
		subMap26.put("name", "（六）电力欠费信息");
		subList21.add(subMap26);

		parentMap21.put("name", "四、经营风险");
		parentMap21.put("children", subList21);
		muluList.add(parentMap21);
		// 行政处罚
		Map<String, Object> parentMap31 = new HashMap<String, Object>();
		List<Map<String, String>> subList31 = new ArrayList<Map<String, String>>();
		Map<String, String> subMap31 = new HashMap<String, String>();
		subMap31.put("name", "（一）行政处罚信息");
		subList31.add(subMap31);
		Map<String, String> subMap32 = new HashMap<String, String>();
		subMap32.put("name", "（二）环境行政处罚");
		subList31.add(subMap32);
		parentMap31.put("name", "五、行政处罚信息");
		parentMap31.put("children", subList31);
		muluList.add(parentMap31);
		// 列入经营异常信息
		Map<String, Object> parentMap41 = new HashMap<String, Object>();
		parentMap41.put("name", "六、列入经营异常信息");
		muluList.add(parentMap41);
		// 列入严重违法失信名单黑名单信息
		Map<String, Object> parentMap42 = new HashMap<String, Object>();
		parentMap42.put("name", "七、列入严重违法失信名单黑名单信息");
		muluList.add(parentMap42);
		CatalogMap.put("muluList", muluList);
		return CatalogMap;
	}

	public static HashMap<String, Object> getFinancingCtreadCatalog() {
		HashMap<String, Object> CatalogMap = new HashMap<String, Object>();
		List<Map<String, Object>> muluList = new ArrayList<Map<String, Object>>();
		Map<String, Object> parentMap = new HashMap<String, Object>();
		// 报告概述
		parentMap.put("name", "一、报告概述");
		muluList.add(parentMap);
		// 融资信用基础数据
		Map<String, Object> parentMap1 = new HashMap<String, Object>();
		List<Map<String, String>> subList1 = new ArrayList<Map<String, String>>();
		Map<String, String> subMap1 = new HashMap<String, String>();
		subMap1.put("name", "（一）基础势能");
		subList1.add(subMap1);
		Map<String, String> subMap2 = new HashMap<String, String>();
		subMap2.put("name", "（二）资产信用");
		subList1.add(subMap2);
		Map<String, String> subMap3 = new HashMap<String, String>();
		subMap3.put("name", "（三）财务信用");
		subList1.add(subMap3);
		Map<String, String> subMap4 = new HashMap<String, String>();
		subMap4.put("name", "（四）创新发展");
		subList1.add(subMap4);
		Map<String, String> subMap5 = new HashMap<String, String>();
		subMap5.put("name", "（五）公共信用");
		subList1.add(subMap5);
		parentMap1.put("name", "二、融资信用基础数据");
		parentMap1.put("children", subList1);
		muluList.add(parentMap1);
		// 附注
		Map<String, Object> parentMap41 = new HashMap<String, Object>();
		parentMap41.put("name", "三、附注");
		muluList.add(parentMap41);
		CatalogMap.put("muluList", muluList);
		return CatalogMap;
	}
}
