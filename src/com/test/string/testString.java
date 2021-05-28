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
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindrome2(String s){
        // 可以使用正则匹配，把特殊字符过滤掉，只留下字母和数字，然后转化为小写，再反转，最后在判断是否相等
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

}
