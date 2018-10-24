package com.tan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        final int len = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    public int[] oneHashTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 23;
        System.out.println(twoSum.twoSum(nums, target)[0]);
        System.out.println(twoSum.twoSum(nums, target)[1]);
    }
}
