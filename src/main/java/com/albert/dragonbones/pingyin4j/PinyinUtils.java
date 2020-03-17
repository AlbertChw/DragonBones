package com.albert.dragonbones.pingyin4j;


import com.alibaba.fastjson.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtils {

    /**
     * 将字符串中的中文转化为拼音全拼,英文字符不变
     *
     * @param chines 汉字
     * @return 拼音
     */
    public static String getPingYinAll(String chines) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuilder output = new StringBuilder();
        if (chines != null && chines.length() > 0
                && !"null".equals(chines)) {
            char[] input = chines.trim().toCharArray();
            try {
                for (char anInput : input) {
                    if (Character.toString(anInput).matches(
                            "[\\u4E00-\\u9FA5]+")) {
                        String[] temp = PinyinHelper.toHanyuPinyinStringArray(
                                anInput, format);


                        String letter = temp[0];
                        output.append(letter.substring(0, 1).toUpperCase()+letter.substring(1));
                    } else {
                        output.append(Character.toString(anInput));
                    }
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            return "*";
        }
        return output.toString();
    }

    /**
     * 将字符串中的中文转化为拼音首字母（大写），英文字符不变
     *
     * @param chines 汉字
     * @return 拼音
     */
    public static String getPingYinAllUpper(String chines) {
        StringBuilder pinyinName = new StringBuilder();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char aNameChar : nameChar) {
            if (aNameChar > 128) {
                try {
                    pinyinName.append(PinyinHelper.toHanyuPinyinStringArray(
                            aNameChar, defaultFormat)[0].charAt(0));
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName.append(aNameChar);
            }
        }
        return pinyinName.toString();
    }

    /**
     * 将字符串中的中文转化为拼音首字母（小写），英文字符不变
     *
     * @param chines 汉字
     * @return 拼音
     */
    public static String getPingYinAllLower(String chines) {
        StringBuilder pinyinName = new StringBuilder();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char aNameChar : nameChar) {
            if (aNameChar > 128) {
                try {
                    pinyinName.append(PinyinHelper.toHanyuPinyinStringArray(
                            aNameChar, defaultFormat)[0].charAt(0));
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName.append(aNameChar);
            }
        }
        return pinyinName.toString();
    }

    public static void main(String[] args) {
//        String test = "江苏满运科技有限公司";
//        System.out.println(PinyinUtils.getPingYinAll(test));

        JSONObject jo = new JSONObject();

        jo.put("1",1);
        jo.put("2",2);
        jo.put("3",3);
        jo.put("1","a");

        JSONObject priceMakeUpRuleJson = new JSONObject();
        priceMakeUpRuleJson.put("all" ,jo);

        System.out.println(priceMakeUpRuleJson.toJSONString());
    }
}