package com.tt.springboottest.ui.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/image")
public class YanZhenMaController {
	@RequestMapping("/getimage")
	public void getImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		JSONObject json = null;
		Random randrgb = new Random();
		// 设置一个比较浅的背景色
		Color c = new Color(randrgb.nextInt(10) + 235, randrgb.nextInt(10) + 235, randrgb.nextInt(10) + 235);
		g.setColor(c); // 为g设置背景色
		g.fillRect(0, 0, 68, 22); // 为g设置边框
		// 画验证码中的内容
		// ch 得到含有字母和数字的数组
		char[] ch = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789".toCharArray();

		// 随机获取数组中的4位
		Random r = new Random();
		int len = ch.length, index = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);// index是数组中随机位置的索引 从0开始
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			g.drawString(ch[index] + "", (i * 15) + 3, 18);// 画出这个随机字符
			sb.append(ch[index]); // 将随机字符添加在sb尾部
		}
		json = new JSONObject();
		json.put("verifyCode", sb.toString());
		json.put("createTime", System.currentTimeMillis());
		request.getSession().setAttribute("verifyCode", json);
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}
}
