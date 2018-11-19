package com.tan.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestSubsg {
    public int lengthOftrinLongestSubsg(String s) {
        if(s==null||"".equals(s)){
            return 0;
        }
        if("".equals(s.trim())&&s.length()>0){
            return 1;
        }
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        
        TreeMap<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
            }
            
        });
        
        
        int maxLen=1;
        char[] sc=s.toCharArray();
        int count=0;
        for (int i = 0; i < sc.length; i++) {
            char current = sc[i];
           if(sMap.containsKey(current)){
              // Integer ccour = sMap.get(current);
              // int len=i-ccour;
               //maxLen=(maxLen<len)?len:maxLen;
               maxLen=(maxLen<count)?count:maxLen;
               count=1;
           }else{
               count=count+1;
           }
            sMap.put(current, i);
        }

        return (maxLen>count)?maxLen:count;
    }
    
    public static void main(String[] args) {
       // System.out.println("123".substring(0, 1));
        LongestSubsg longestSubsg=new LongestSubsg();
        System.out.println(longestSubsg.lengthOftrinLongestSubsg("dvdf"));
        System.out.println("   ".length());
    }
}
