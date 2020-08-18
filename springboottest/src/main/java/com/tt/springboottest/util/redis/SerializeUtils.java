package com.tt.springboottest.util.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeUtils {

	public static byte[] serializeObject(Object obj) {
		byte[] result = null;
		if (obj == null) {
			return new byte[0];
		}
		ByteArrayOutputStream stream = new ByteArrayOutputStream(128);
		try {
			if (!(obj instanceof Serializable)) {
				throw new IllegalArgumentException(
						SerializeUtils.class.getSimpleName() + " requires a Serializable payload "
								+ "but received an object of type [" + obj.getClass().getName() + "]");
			}
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
			objectOutputStream.writeObject(obj);
			;
			objectOutputStream.flush();
			result = stream.toByteArray();
		} catch (Throwable e) {
			try {
				throw new Exception("Failed to serialize", e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 * @return
	 */
	public static Object deserialize(byte[] bytes) {

		Object result = null;

		if (isEmpty(bytes)) {
			return null;
		}

		try {
			ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
			try {
				ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
				try {
					result = objectInputStream.readObject();
				} catch (ClassNotFoundException ex) {
					throw new Exception("Failed to deserialize object type", ex);
				}
			} catch (Throwable ex) {
				throw new Exception("Failed to deserialize", ex);
			}
		} catch (Exception e) {
		}
		return result;
	}

	public static boolean isEmpty(byte[] data) {
		return (data == null || data.length == 0);
	}

}
