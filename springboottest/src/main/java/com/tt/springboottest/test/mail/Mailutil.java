package com.tt.springboottest.test.mail;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;

import com.sun.mail.util.MailSSLSocketFactory;

public class Mailutil {
	private static final String HOST = MailConfig.host;
	private static final Integer PORT = MailConfig.port;
	private static final String USERNAME = MailConfig.userName;
	private static final String PASSWORD = MailConfig.passWord;
	private static final String emailForm = MailConfig.emailForm;
	private static final String timeout = MailConfig.timeout;
	private static final String personal = MailConfig.personal;
	private static final String subject = MailConfig.subject;
	private static final String html = MailConfig.html;
	private static JavaMailSenderImpl mailSender = createMailSender();

	/**
	 * 邮件发送器
	 *
	 * @return 配置好的工具
	 * @throws GeneralSecurityException
	 */
	private static JavaMailSenderImpl createMailSender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(HOST);
		sender.setUsername(USERNAME);
		sender.setPassword(PASSWORD);
		sender.setDefaultEncoding("Utf-8");
		Properties p = new Properties();
		p.setProperty("mail.smtp.timeout", timeout);
		p.setProperty("mail.smtp.auth", "true");
		// QQ邮箱设置SSL加密
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			p.put("mail.smtp.ssl.enable", "true");
			p.put("mail.smtp.ssl.socketFactory", sf);
			sender.setJavaMailProperties(p);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sender;
	}

	/**
	 * 发送邮件
	 *
	 * @param to      接受人
	 * @param subject 主题
	 * @param html    发送内容
	 * @throws MessagingException           异常
	 * @throws UnsupportedEncodingException 异常
	 * @throws                              javax.mail.MessagingException
	 */
	public static void sendMail(String to, String html)
			throws MessagingException, UnsupportedEncodingException, javax.mail.MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// 设置utf-8或GBK编码，否则邮件会有乱码
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		messageHelper.setFrom(emailForm, personal);
		messageHelper.setTo(to);
		messageHelper.setSubject(subject);
		messageHelper.setText(html, true);
//	      messageHelper.addAttachment("", new File(""));//附件
		mailSender.send(mimeMessage);
	}
}
