package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lists {
  public static void main(String[] args) {
    int[] toSort = { 5, 4, 9, 1, 7, 3, 2, 1 };

    int[] result = sortIntegerList(toSort);

    System.out.println(Arrays.toString(result));

    String[] toSort2 = { "maine", "mai", "main" };

    System.out.println(Arrays.toString(sortStringList(toSort2)));

    int[] toRemove = { 1, 1, 2, 3, 4, 5, 4, 5, 4, 5, 4 };
    System.out.println(removeDuplicates(toRemove));

    int[] toMove = { 0, 1, 0, 3, 12 };
    System.out.println(Arrays.toString(moveZeroes(toMove)));

    int[] toRotate = { 1, 2, 3, 4, 5, 6, 7 };

    System.out.println(Arrays.toString(rotateArray(toRotate, 3)));
    int[] toFind = { 0, 0, 1, 2, 2 };

    System.out.println(findSingleNumber(toFind));
    // System.out.println(0 % 2);
  }

  public static int[] sortIntegerList(int[] toSort) {
    for (int i = 0; i < toSort.length - 1; i++) {
      for (int j = 0; j < toSort.length - 1; j++) {

        if (j < toSort.length && (toSort[j] > toSort[j + 1])) {
          int rep = toSort[j];
          toSort[j] = toSort[j + 1];
          toSort[j + 1] = rep;
        }
      }
    }
    return toSort;
  }

  /*
   * 
   * examples:
   * ["name", "main"]
   */
  public static String[] sortStringList(String[] toSort) {
    for (int i = 0; i < toSort.length - 1; i++) {
      for (int j = 0; j < toSort.length - 1; j++) {
        if (toSort[j].compareTo(toSort[j + 1]) > 0) {
          String rep = toSort[j];
          toSort[j] = toSort[j + 1];
          toSort[j + 1] = rep;
        }
      }
    }
    return toSort;
  }
  /*
   * 🧠 Task: Remove Duplicates from Sorted Array
   * Prompt:
   * 
   * Given an integer array nums sorted in non-decreasing order, remove the
   * duplicates in-place such that each unique element appears only once. Return
   * the number of unique elements.
   * 
   * [1,1,2]
   */

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0)
      return 0;
    List<Integer> seen = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (seen.contains(nums[i]))
        continue;
      seen.add(nums[i]);

    }
    int[] c = new int[seen.size()];

    for (int i = 0; i < seen.size(); i++) {
      c[i] = seen.get(i);
    }

    return c.length;
  }

  /*
   * 🔢 Task: Move Zeroes
   * Problem:
   * Given an integer array nums, move all 0's to the end of it while maintaining
   * the relative order of the non-zero elements.
   * 
   * You must do this in-place without making a copy of the array.
   * Input: nums = [0, 1, 0, 3, 12]
   * Output: [1, 3, 12, 0, 0]
   */
  public static int[] moveZeroes(int[] nums) {
    if (nums.length == 0)
      return nums;

    int ZeroValueIndex = 0;

    // Move all non-zero elements to the front
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[ZeroValueIndex] = nums[i];
        ZeroValueIndex++;
      }
    }

    // Fill the remaining space with zeros
    while (ZeroValueIndex < nums.length) {
      nums[ZeroValueIndex] = 0;
      ZeroValueIndex++;
    }

    return nums;
  }

  /*
   * 🔄 Task: Rotate Array
   * Problem:
   * Given an array, rotate the array to the right by k steps, where k is
   * non-negative.
   * You must do this in-place without making a copy of the array.
   * 
   * Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3
   * Output: [5, 6, 7, 1, 2, 3, 4]
   * Explanation:
   * rotate 1 steps to the right: [7, 1, 2, 3, 4, 5, 6]
   * rotate 2 steps to the right: [6, 7, 1, 2, 3, 4, 5]
   * rotate 3 steps to the right: [5, 6, 7, 1, 2, 3, 4]
   */

  public static int[] rotateArray(int[] nums, int toRotate) {
    if (toRotate == 0 || nums.length == 0)
      return nums;

    int rotated = 0;

    while (rotated < toRotate) {
      int lastValue = nums[nums.length - 1];
      for (int i = nums.length - 1; i > 0; i--) {
        nums[i] = nums[i - 1];
      }
      nums[0] = lastValue;

      rotated++;

    }
    return nums;
  }

  /*
   * 🧠 Problem: Find the Single Number
   * Given a non-empty array of integers nums, every element appears twice except
   * for one. Find that single one.
   * 
   * example:
   * Input: [4,1,2,1,2]
   * Output: 4
   * 
   * ✅ Constraints:
   * Your solution should have linear runtime complexity (O(n)).
   * 
   * You must not use extra memory (or keep it very minimal).
   * [1,1,2,2,4,4,5]
   * [0, 1, 1, 2, 2]
   */
  public static int findSingleNumber(int[] nums) {
    int single = 0;
    nums = sortIntegerList(nums);

    for (int i = 0; i < nums.length; i++) {

      if ((i % 2 != 0) && (nums[i] != nums[i - 1])) {
        single = nums[i - 1];
      } else {
        if (single == 0 && (i == nums.length - 2) && (nums[i] != nums[i + 1])) {
          single = nums[i + 1];
        }
      }
      if (single != 0 && (i + 2 < nums.length - 1)) {
        break;
      }

    }
    if (nums[0] == 0 && nums[1] != 0) {
      single = 0;
    }
    return single;
  }
}
