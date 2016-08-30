package com.dmall.hisen.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	/**
	 * MD5加密方法。
	 * @param msg 要加密的串
	 * @param type 位数。16或32位
	 * @return
	 */
	public static String encrypt(String msg,int type)
	{
		try {
			   MessageDigest md = MessageDigest.getInstance("MD5");
			   md.update(msg.getBytes());
			   byte b[] = md.digest();
			   int i;
			   StringBuffer buf = new StringBuffer("");
			   for (int offset = 0; offset < b.length; offset++) {
			    i = b[offset];
			    if (i < 0)
			     i += 256;
			    if (i < 16)
			     buf.append("0");
			    buf.append(Integer.toHexString(i));
			   }
			   if(type == 16){
				   return buf.toString().substring(8,24);
			   }else if(type==32){
				   return buf.toString();
			   }else{
				   return buf.toString();
			   }
			  } catch (NoSuchAlgorithmException e) {
				  e.printStackTrace();
			  }
		return null;
	}

	private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

	public MD5() {
	}

	public static String byteArrayToHexString(byte[] b) {
		StringBuilder resultSb = new StringBuilder();
		byte[] arr$ = b;
		int len$ = b.length;

		for(int i$ = 0; i$ < len$; ++i$) {
			byte aB = arr$[i$];
			resultSb.append(byteToHexString(aB));
		}

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if(b < 0) {
			n = 256 + b;
		}

		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin) {
		String resultString = null;

		try {
			MessageDigest e = MessageDigest.getInstance("MD5");
			e.update(origin.getBytes("UTF-8"));
			resultString = byteArrayToHexString(e.digest());
		} catch (Exception var3) {
			var3.printStackTrace();
		}

		return resultString;
	}
	
	
}
