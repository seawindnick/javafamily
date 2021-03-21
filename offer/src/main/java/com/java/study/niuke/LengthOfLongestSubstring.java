package com.java.study.niuke;

import java.util.HashSet;
import java.util.Set;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-29 11:55
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Set<Character> set = new HashSet<>();
        int count = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            char indexChar = s.charAt(i);
            if (set.contains(indexChar)) {
                count = 0;
                set = new HashSet<>();
            }
            count++;
            set.add(indexChar);
            result = Math.max(result, count);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "aaaaabbbcd";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
