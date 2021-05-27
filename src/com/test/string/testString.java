package com.test.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class testString {
    public static void main(String[] args) {
        //反转字符串
//        char str[] = {'h', 'e', 'l', 'l', 'o'};
//        reverseString(str);
//        System.out.println(Arrays.toString(str));

        //整数反转
//        System.out.println(reverseNumber(-1501));

        //字符串中的第一个唯一字符
//        String s = "loveleetcode";
//        System.out.println(firstUniqChar(s));
//        System.out.println(firstUniqChar2(s));
    }

    public static void reverseString(char[] s) {
        int len = s.length;
        char temp = ' ';
        for (int i = 0; i < len / 2; i++) {
            temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }

    public static int reverseNumber(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0
            if ((newRes - t) / 10 != res)
                return 0;
            res = newRes;
            x = x / 10;
        }
        return res;
//        long res = 0;
//        while (x != 0) {
//            res = res * 10 + x % 10;
//            x /= 10;
//        }
//        return (int) res == res ? (int) res : 0;
    }

    public static int firstUniqChar(String s) {
        char[] strs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : strs) {
//            if (!map.containsKey(ch)) {
//                map.put(ch, 1);
//            } else {
//                map.put(ch, map.get(ch) + 1);
//            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < strs.length; i++) {
            if (map.get(strs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        return -1;
    }
}
