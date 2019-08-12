package com.yibin.ade.commonn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.hash.Hashing;
import com.yibin.ade.commonn.constants.Constants;
import org.springframework.util.StringUtils;

import com.google.common.base.Charsets;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
public class StringUtil {

    /**
     * 获取字符串长度（中文2个字符，英文1个字符）
     *
     * @param value
     * @return
     */
    public static int getStrLength(String value) {
        int valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        for (int i = 0; i < value.length(); i++) {
            String temp = value.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }
        }
        return valueLength;
    }

    /**
     * 验证字符串 只包含汉字、英文、数字
     * 各种字符的unicode编码的范围：
     * 汉字：[0x4e00,0x9fa5]（或十进制[19968,40869]）
     * 数字：[0x30,0x39]（或十进制[48, 57]）
     * 小写字母：[0x61,0x7a]（或十进制[97, 122]）
     * 大写字母：[0x41,0x5a]（或十进制[65, 90]）
     *
     * @param value
     */
    public static boolean validateStrRule(String value) {
        String regex = "^[a-zA-Z0-9\u4E00-\u9FA5]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(value);
        return match.matches();
    }


    /**
     * @return 符合要求 返回true
     * @brief 评估密码中包含的字符类型是否符合要求
     * @param[in] password            密码字符串
     */
    public static boolean checkPwd(String password) {
        if (password == null || "".equals(password)) {
            return false;
        }

        /**
         * 检测长度
         */
        if (!(getStrLength(password) < Constants.PASS_MAX_LENGTH)) {
            return false;
        }

//        if (!(getStrLength(password) > Constants.PASS_MIN_LENGTH)) {
//            return false;
//        }
//        /**
//         * 检测密码难度
//         */
//        if (!validateStrRule(password)) {
//            return false;
//        }

        return true;
    }


    public static String encrypt(String origin, String salt) {
        if (StringUtils.isEmpty(origin)) {
            return Constants.EMPTY;
        }
        return Hashing.md5().newHasher().putString(origin + salt, Charsets.UTF_8).hash().toString();
    }


}
