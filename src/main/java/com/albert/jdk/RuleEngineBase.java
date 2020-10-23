package com.albert.jdk;

import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;

/**
 * 分表
 */
public class RuleEngineBase {
	public static final int SKIP = -1;

	public static long crc32(Object str) throws UnsupportedEncodingException {

		return crc32(str, "utf-8");
	}



	public static long crc32(Object str, String encode) throws UnsupportedEncodingException {
		CRC32 crc32 = new CRC32();
		crc32.update(String.valueOf(str).getBytes());
		return crc32.getValue();
	}
}
