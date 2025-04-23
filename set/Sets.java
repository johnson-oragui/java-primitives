package set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Pair<K, V> {
  public K first;
  public V second;

  Pair(K first, V second) {
    this.first = first;
    this.second = second;
  }
}

public class Sets {
  public static void main(String[] args) {
    int[] nums = new int[] { 3, 5, 1, 4, 2, 6, 6, 6 };

    // System.out.println(firstRepeatedElement(nums));
    // System.out.println(Arrays.toString(smallestUniqueElements(nums, 2)));

    Pair<Integer, TreeSet<Integer>> result = countOfUniqueElements(nums);
    System.out.printf("number of unique elements: %d, all unique elements: %s\n", result.first, result.second);
  }

  /*
   * ✅ Task: Find the First Repeated Element
   * Description:
   * Given an array of integers, return the first element that appears more than
   * once. If no element is repeated, return -1.
   * 
   * 📥 Example:
   * 
   * Input: [3, 5, 1, 4, 2, 5, 6]
   * Output: 5
   * 
   * Input: [1, 2, 3, 4]
   * Output: -1
   */
  public static int firstRepeatedElement(int[] nums) {
    Set<Integer> seen = new HashSet<>();

    for (int n : nums) {
      if (seen.contains(n))
        return n;
      seen.add(n);
    }

    return -1;
  }

  /*
   * 🧠 Mini Task
   * Write a method that takes an array of integers and returns the k smallest
   * unique elements where k is an int using TreeSet.
   */

  public static int[] smallestUniqueElements(int[] nums, int k) {
    if (k > nums.length)
      return nums;
    TreeSet<Integer> tmap = new TreeSet<>();

    for (int n : nums) {
      tmap.add(n);
    }

    int[] result = new int[k];
    int idx = 1;
    for (Integer n : tmap) {
      if (idx == k + 1)
        break;
      result[idx - 1] = n;
      idx++;
    }

    return result;

  }

  /*
   * ✅ Practice Task (want to try?):
   * Task: Given an array of integers, return the count of unique elements.
   * and the elements in an ordered version.
   * 
   * Example:
   * 
   * 
   * Input: [1, 2, 2, 3, 4, 1]
   * Output: 4
   */
  public static Pair<Integer, TreeSet<Integer>> countOfUniqueElements(int[] nums) {
    HashSet<Integer> fruits = new HashSet<>();
    for (int n : nums) {
      fruits.add(n);
    }

    TreeSet<Integer> fruitTree = new TreeSet<>(fruits);

    return new Pair<>(fruits.size(), fruitTree);
  }
}
