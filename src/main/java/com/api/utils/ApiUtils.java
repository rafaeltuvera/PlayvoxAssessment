package com.api.utils;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.bouncycastle.util.encoders.Base64;

public class ApiUtils {

	
	public String getFile(String filepath) {
		String file = null;
		try {
			file = new String(Files.readAllBytes(Paths.get(filepath)));
		}catch (Exception e) {
			e.getMessage();
		}
		return file;
	}
	
	 public static String base64Encode(String token) {
		    byte[] encodedBytes = Base64.encode(token.getBytes());
		    return new String(encodedBytes, Charset.forName("UTF-8"));
		}


		public static String base64Decode(String token) {
		    byte[] decodedBytes = Base64.decode(token.getBytes());
		    return new String(decodedBytes, Charset.forName("UTF-8"));
		}

		public long getDatetimeInMillis(){
			return System.currentTimeMillis();
		}
}
