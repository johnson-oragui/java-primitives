package hash;

import java.util.*;

public class Hash {
  public static void main(String[] args) {
    // int[] toFind = new int[] { 2, 11, 3, 9, 8, 6, 7 };

    // System.out.println(Arrays.toString(indexOfTwoNumbers(toFind, 9)));

    // String s = "call", t = "lalc";
    // System.out.println(findAnagram(t, s));

    int[] toGro = new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3 };
    // System.out.println(Arrays.toString(frequentElements(toGro, 2)));

    System.out.println(countOccurrenceNumbers(toGro));
  }

  /*
   * 🧠 Leetcode-style Task 1:
   * 
   * 🔹 Given an array of integers, return the index of the two numbers such that
   * they add up to a specific target.
   * 
   * Input: nums = [2, 7, 11, 15], target = 9
   * Output: [0, 1] (because nums[0] + nums[1] == 9)
   */

  public static int[] indexOfTwoNumbers(int[] nums, int target) {
    if (nums.length < 1)
      return nums;
    Map<Integer, Integer> toMap = new HashMap<>();
    int idx = 0;

    for (int n : nums) {
      toMap.put(idx, n);
      idx++;
    }

    for (int i = 0; i < toMap.size(); i++) {
      for (int j = 0; j < toMap.size(); j++) {
        if (toMap.get(i) + toMap.get(j) == target) {
          return new int[] { i, j };
        }
      }
    }
    return nums;
  }

  /*
   * ✅ Task:
   * Given two strings s and t, determine if t is an anagram of s.
   * 
   * An anagram is formed by rearranging the letters of a word to produce a new
   * word, using all the original letters exactly once.
   * 
   * Input: s = "anagram", t = "nagaram"
   * Output: true
   */

  public static Boolean findAnagram(String first, String second) {
    if (first.length() != second.length())
      return false;

    Map<Character, Integer> firstMap = new HashMap<>();

    for (char c : first.toCharArray()) {
      firstMap.put(c, firstMap.getOrDefault(c, 0) + 1);

    }
    for (char c : second.toCharArray()) {
      int res = firstMap.getOrDefault(c, 0);
      if (res == 0)
        return false;

      firstMap.put(c, res - 1);

    }

    for (Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
      if (entry.getValue() > 0)
        return false;
    }

    return true;
  }
  /*
   * 🧩 Problem: Top K Frequent Elements
   * LeetCode #347
   * 
   * ✅ Task:
   * Given an integer array nums and an integer k, return the k most frequent
   * elements.
   * 
   * Input: nums = [1,1,1,2,2,3], k = 2
   * Output: [1,2]
   * 
   * Input: nums = [1], k = 1
   * Output: [1]
   * 
   * 🔐 Constraints:
   * 1 <= nums.length <= 10⁵
   * 
   * k is in the range [1, the number of unique elements in the array]
   * 
   * It is guaranteed that the answer is unique.
   */

  public static int[] frequentElements(int[] nums, int k) {
    Map<Integer, Integer> mapped = new HashMap<>();

    for (int n : nums) {
      mapped.put(n, mapped.getOrDefault(n, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> pQ = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

    pQ.addAll(mapped.entrySet());

    int[] res = new int[k];

    for (int idx = 0; idx < k; idx++) {
      if (idx == k)
        break;
      res[idx] = pQ.poll().getKey();
    }

    return res;

  }

  /*
   * Task:
   * You’re given an array of integers. Count how many times each number appears
   * in sorted key order.
   */

  public static TreeMap<Integer, Integer> countOccurrenceNumbers(int[] nums) {

    TreeMap<Integer, Integer> appears = new TreeMap<>();
    if (nums.length < 1)
      return appears;

    for (int n : nums) {
      appears.put(n, appears.getOrDefault(n, 0) + 1);
    }
    return appears;
  }

}
