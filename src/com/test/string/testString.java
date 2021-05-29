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

        //有效的字母异位词
//        String s = "anagram", t = "nagaram";
//        System.out.println(isAnagram3(s, t));

        //验证回文串
//        String s = "A man, a plan, a canal: Panama";
//        System.out.println(isPalindrome2(s));

        //实现一个 myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数
//        String s = "-91283472332";
//        String s = " ";
//        System.out.println(myAtoi(s));

        //给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
//        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "ddd", needle = "";
//        String haystack = "a", needle = "a";
//        System.out.println(strStr(haystack, needle));

        //给定一个正整数 n ，输出外观数列的第 n 项
//        System.out.println(countAndSay(5));

        //查找字符串数组中的最长公共前缀。
//        String[] strs = {"flower", "flow", "flight"};
//        System.out.println(longestCommonPrefix(strs));
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

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] letterNum = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterNum[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            //优化一下，当减去字符串t中某个字符之前如果为0，直接返回false
            if (letterNum[t.charAt(j) - 'a'] == 0)
                return false;
            letterNum[t.charAt(j) - 'a']--;
        }
//        for (int num : letterNum)
//            if (num != 0) {
//                return false;
//            }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }

    public static boolean isAnagram3(String s, String t) {
        //使用一个变量count记录新出现字符的个数，然后同时遍历两个数组，如果出现了一个新的字符，
        // count就加1，如果消失了一个字符，count就减1，最后判断count是否等于0即可
        if (s.length() == 0 || t.length() == 0)
            return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < sc.length; i++) {
            //出现了一个新的字符
            if (++map[sc[i] - 'a'] == 1) {
                count++;
            }
            //消失了一个新的字符
            if (--map[tc[i] - 'a'] == 0) {
                count--;
            }
        }
        return count == 0;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return false;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        // 可以使用正则匹配，把特殊字符过滤掉，只留下字母和数字，然后转化为小写，再反转，最后在判断是否相等
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    public static int myAtoi(String s) {
        char[] sc = s.trim().toCharArray();
        if (sc.length == 0)
            return 0;
        int res = 0;
        int sign = 1;
        int index = 0;
        if (sc[index] == '+' || sc[index] == '-') {
            sign = sc[0] == '+' ? 1 : -1;
            index++;
        }
        for (; index < sc.length; index++) {
            int digit = sc[index] - '0';
            if (digit < 0 || digit > 9)
                break;
            //越界处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                res = res * 10 + digit;
        }
        return res * sign;
    }

    public static int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
        int needlen = needle.length();
        int hayslen = haystack.length();
        int Diff = hayslen - needlen + 1;
        for (int i = 0; i < Diff; i++) {
            if (haystack.substring(i, i + needlen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        String strN = countAndSay(n - 1);
        int count = 0;
        char indexVal = strN.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strN.length(); i++) {
            if (indexVal == strN.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(indexVal);
                count = 1;
                indexVal = strN.charAt(i);
            }
        }
        sb.append(count);
        sb.append(indexVal);
        return sb.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String cp = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(cp) != 0) {
                cp = cp.substring(0, cp.length()-1);
            }
            i++;
        }
        return cp;
    }

}
