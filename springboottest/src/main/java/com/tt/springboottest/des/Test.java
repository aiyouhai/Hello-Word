package com.tt.springboottest.des;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.springframework.util.DigestUtils;

public class Test {
	private static final String password = "yzd-2020yzd-2020";

	public static void main(String[] args) throws IOException, Exception {

		/*
		 * String m =
		 * DigestUtils.md5DigestAsHex("/legalPerson/cli/getCCBRsaData18538570979123456".
		 * getBytes()); String str1 =
		 * "/legalPerson/cli/getCCBRsaData`18538570979`123456`" + m; String encrypt =
		 * DesUtils.encrypt(str1); System.out.println(encrypt);
		 */

		// 直接将如上内容解密
		String str2 = "755DcQuFbm5GAJsAlsONhG6Hl8kvFJuagnIfhg4t30k";
		String decrypt2 = "";
		try {
			decrypt2 = DesUtils.decrypt(password, str2);
			// 18538570979,123456,6071bf3f2c31b7174ea9f4e0366a0e2f
			System.out.println(decrypt2);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String[] split = decrypt2.split("`");
		String oldSign = "";

		for (int i = 0; i < split.length; i++) {
			oldSign += split[i];
		}

		System.out.println("oldSign=" + oldSign);

		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("phone", split[0]);
		map.put("email", split[1]);

		Collection<Object> values = map.values();

		for (Object object : values) {
			System.out.println(object);
		}

		String sign = (String) map.get("sign");

		String md5DigestAsHex = DigestUtils.md5DigestAsHex(oldSign.getBytes());
		System.out.println("签名=" + md5DigestAsHex);
		if (md5DigestAsHex.equals(sign)) {
			System.out.println("验证签名通过");
			map.remove("sign");
		} else {
			System.out.println("验证签名失败");
		}

	}

}
