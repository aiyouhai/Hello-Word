package com.tt.springboottest.des;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DesUtils {

	public final static String DES = "DES";
	private static final String DES_KEY = "yzd-2020";
	/*
		*//**
			 * Description 根据键值进行加密
			 *
			 * @param data
			 * @param key  加密键byte数组
			 * @return
			 * @throws Exception
			 */
	/*
	 * public static String encrypt(String data) throws Exception { byte[] bt =
	 * encrypt(data.getBytes(), DES_KEY.getBytes()); String strs = new
	 * BASE64Encoder().encode(bt); String strs = new String(new
	 * Base64().encodeBase64(bt)); return strs; }
	 * 
	 *//**
		 * Description 根据键值进行解密
		 *
		 * @param data
		 * @param key  加密键byte数组
		 * @return
		 * @throws IOException
		 * @throws Exception
		 */
	/*
	 * public static String decrypt(String data) throws IOException, Exception { if
	 * (data == null) return null; // BASE64Decoder decoder = new BASE64Decoder();
	 * byte[] buf = new Base64().decodeBase64(data); byte[] bt = decrypt(buf,
	 * DES_KEY.getBytes()); return new String(bt); }
	 * 
	 *//**
		 * Description 根据键值进行加密
		 *
		 * @param data
		 * @param key  加密键byte数组
		 * @return
		 * @throws Exception
		 */
	/*
	 * private static byte[] encrypt(byte[] data, byte[] key) throws Exception { //
	 * 生成一个可信任的随机数源 SecureRandom sr = new SecureRandom();
	 * 
	 * // 从原始密钥数据创建DESKeySpec对象 DESKeySpec dks = new DESKeySpec(key); //
	 * 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象 SecretKeyFactory keyFactory =
	 * SecretKeyFactory.getInstance(DES); SecretKey securekey =
	 * keyFactory.generateSecret(dks); // Cipher对象实际完成加密操作 Cipher cipher =
	 * Cipher.getInstance(DES);
	 * 
	 * // 用密钥初始化Cipher对象 cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
	 * 
	 * return cipher.doFinal(data); }
	 * 
	 *//**
		 * Description 根据键值进行解密
		 *
		 * @param data
		 * @param key  加密键byte数组
		 * @return
		 * @throws Exception
		 *//*
			 * private static byte[] decrypt(byte[] data, byte[] key) throws Exception { //
			 * 生成一个可信任的随机数源 SecureRandom sr = new SecureRandom();
			 * 
			 * // 从原始密钥数据创建DESKeySpec对象 DESKeySpec dks = new DESKeySpec(key);
			 * 
			 * // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象 SecretKeyFactory keyFactory =
			 * SecretKeyFactory.getInstance(DES); SecretKey securekey =
			 * keyFactory.generateSecret(dks);
			 * 
			 * // Cipher对象实际完成解密操作 Cipher cipher = Cipher.getInstance(DES);
			 * 
			 * // 用密钥初始化Cipher对象 cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
			 * 
			 * return cipher.doFinal(data); }
			 */

	/**
	 * 偏移变量，固定占8位字节
	 */
	private final static String IV_PARAMETER = "12345678";
	/**
	 * 密钥算法
	 */
	private static final String ALGORITHM = "DES";
	/**
	 * 加密/解密算法-工作模式-填充模式
	 */
	private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";
	/**
	 * 默认编码
	 */
	private static final String CHARSET = "utf-8";

	/**
	 * 生成key
	 *
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static Key generateKey(String password) throws Exception {
		DESKeySpec dks = new DESKeySpec(password.getBytes(CHARSET));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		return keyFactory.generateSecret(dks);
	}

	/**
	 * DES加密字符串
	 *
	 * @param password 加密密码，长度不能够小于8位
	 * @param data     待加密字符串
	 * @return 加密后内容
	 */
	public static String encrypt(String password, String data) {
		if (password == null || password.length() < 8) {
			throw new RuntimeException("加密失败，key不能小于8位");
		}
		if (data == null)
			return null;
		try {
			Key secretKey = generateKey(password);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
			byte[] bytes = cipher.doFinal(data.getBytes(CHARSET));

			// JDK1.8及以上可直接使用Base64，JDK1.7及以下可以使用BASE64Encoder
			// Android平台可以使用android.util.Base64
			return new String(Base64.getEncoder().encode(bytes));

		} catch (Exception e) {
			e.printStackTrace();
			return data;
		}
	}

	/**
	 * DES解密字符串
	 *
	 * @param password 解密密码，长度不能够小于8位
	 * @param data     待解密字符串
	 * @return 解密后内容
	 */
	public static String decrypt(String password, String data) {
		if (password == null || password.length() < 8) {
			throw new RuntimeException("加密失败，key不能小于8位");
		}
		if (data == null)
			return null;
		try {
			Key secretKey = generateKey(password);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
			return new String(cipher.doFinal(Base64.getDecoder().decode(data.getBytes(CHARSET))), CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
			return data;
		}
	}

	/**
	 * DES加密文件
	 *
	 * @param srcFile  待加密的文件
	 * @param destFile 加密后存放的文件路径
	 * @return 加密后的文件路径
	 */
	/*
	 * public static String encryptFile(String password, String srcFile, String
	 * destFile) {
	 * 
	 * if (password == null || password.length() < 8) { throw new
	 * RuntimeException("加密失败，key不能小于8位"); } try { IvParameterSpec iv = new
	 * IvParameterSpec(IV_PARAMETER.getBytes(CHARSET)); Cipher cipher =
	 * Cipher.getInstance(CIPHER_ALGORITHM); cipher.init(Cipher.ENCRYPT_MODE,
	 * generateKey(key), iv); InputStream is = new FileInputStream(srcFile);
	 * OutputStream out = new FileOutputStream(destFile); CipherInputStream cis =
	 * new CipherInputStream(is, cipher); byte[] buffer = new byte[1024]; int r;
	 * while ((r = cis.read(buffer)) > 0) { out.write(buffer, 0, r); } cis.close();
	 * is.close(); out.close(); return destFile; } catch (Exception ex) {
	 * ex.printStackTrace(); } return null; }
	 */

	/**
	 * DES解密文件
	 *
	 * @param srcFile  已加密的文件
	 * @param destFile 解密后存放的文件路径
	 * @return 解密后的文件路径
	 */
	/*
	 * public static String decryptFile(String password, String srcFile, String
	 * destFile) { if (password == null || password.length() < 8) { throw new
	 * RuntimeException("加密失败，key不能小于8位"); } try { File file = new File(destFile);
	 * if (!file.exists()) { file.getParentFile().mkdirs(); file.createNewFile(); }
	 * IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
	 * Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
	 * cipher.init(Cipher.DECRYPT_MODE, generateKey(key), iv); InputStream is = new
	 * FileInputStream(srcFile); OutputStream out = new FileOutputStream(destFile);
	 * CipherOutputStream cos = new CipherOutputStream(out, cipher); byte[] buffer =
	 * new byte[1024]; int r; while ((r = is.read(buffer)) >= 0) { cos.write(buffer,
	 * 0, r); } cos.close(); is.close(); out.close(); return destFile; } catch
	 * (Exception ex) { ex.printStackTrace(); } return null; }
	 */

}
