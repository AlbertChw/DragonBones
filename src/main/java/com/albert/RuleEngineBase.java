package com.albert;

import java.util.zip.CRC32;

public class RuleEngineBase {

    public static long crc32(Object str) {
        CRC32 crc32 = new CRC32();
        crc32.update(String.valueOf(str).getBytes());
        return crc32.getValue();
    }

    public static void main(String[] args) {
        System.out.println(crc32("11441609153496064") % 32);
    }
}
