package com.vonguyen.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/next-greater-element-i/description/
 *
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all
 * the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not
 * exist, output -1 for this number.
 *
 * Example:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 */
public class NextGreatElement1 {
    private static Map<Integer, Integer> P = new HashMap();

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        for (int i=0; i<nums.length; i++) {
            P.put(nums[i],i);
        }

        int[] R = new int[findNums.length];
        for (int i=0; i<findNums.length; i++) {
            R[i] = nextGreaterNumber(findNums[i],nums,P.get(findNums[i]));
        }

        return R;
    }

    private static int nextGreaterNumber(int num, int[] numArray, int pos) {
        for (int i=pos; i<numArray.length; i++) {
            if (numArray[i]>num) {
                return numArray[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        Arrays.stream(nextGreaterElement(nums1, nums2)).forEach(System.out::println);
    }
}
