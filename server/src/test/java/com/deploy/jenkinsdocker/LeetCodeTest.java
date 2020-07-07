package com.deploy.jenkinsdocker;

import java.util.*;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class LeetCodeTest {

    public static void main(String[] args) {
       /* int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        LeetCodeTest leetCodeTest = new LeetCodeTest();
        Map<Integer, int[]> ints1 = leetCodeTest.twoSum(ints, 10);
        ints1.forEach((k,v)->{
            System.out.println(Arrays.toString(v));
        });*/

    }

    public Map twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, int[]> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                resultMap.put(i,new int[] { map.get(complement), i });
            }
            map.put(nums[i], i);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add(1, "235");
        list.remove("235");
        list.get(1);

        return resultMap;

    }

}
