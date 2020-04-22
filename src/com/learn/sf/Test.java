package com.learn.sf;

import java.util.*;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-10 18:51
 */
public class Test {


    public static void main(String[] args) {
        /*String s = "pwwkew";
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int i;
        int j = 0;
        // 遍历字符串
        for (i = 0; i < s.length(); i++) {
            // 判断是否set中有值
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                maxLength = Math.max(maxLength, set.size());
            } else {
                // 如果存在这个值  那么就需要删除
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(j));
                    j++;
                }
                set.add(s.charAt(i));
            }
        }
        System.out.println(maxLength);*/


        Map<String, Integer> symbol = new HashMap<>();


        System.out.println(isValid("["));

    }


    public static boolean isValid(String s) {
        /**
         * 有效的括号
         */
        boolean result = true;
        if (s == null || s.length() == 0) return result;
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char sc : s.toCharArray()) {
            if (sc == '(' || sc == '{' || sc == '[') {
                stack.push(sc);
            } else if (stack.isEmpty() || stack.pop() != map.get(sc)) {
                result = false;
                break;
            }
        }
        if (result) {
            result = stack.isEmpty();
        }
        return result;
    }

}
