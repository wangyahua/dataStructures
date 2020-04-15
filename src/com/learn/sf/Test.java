package com.learn.sf;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-10 18:51
 */
public class Test {


    public static void main(String[] args) {
        String s = "pwwkew";
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
        System.out.println(maxLength);
    }


}
