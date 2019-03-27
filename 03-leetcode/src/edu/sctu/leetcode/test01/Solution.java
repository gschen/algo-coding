package edu.sctu.leetcode.test01;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] indexs = new int[2];

        int len = nums.length;
        int[] shadow = new int[len];

        for (int i = 0; i < len; i++) {

            shadow[i] = target - nums[i];
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[i] == shadow[j]) {

                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }


        return indexs;
    }


}
