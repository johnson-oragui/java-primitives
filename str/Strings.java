package str;

import java.util.*;

class Pair<T, U> {
  public T first;
  public U second;

  public Pair(T first, U second) {
    this.first = first;
    this.second = second;
  }
}

public class Strings {
  public static void main(String[] args) {
    String value = "A man, a plan, a canal: Panama";

    Pair<Boolean, String> result = ValidPalindrome(value);

    System.out.println(result.first);
    System.out.println(result.second);

  }

  /*
   * Given a string s, find the length of the longest substring without repeating
   * characters.
   */
  public static Pair<Integer, String> LongestSubstring(String value) {
    Map<Character, Boolean> seen = new HashMap<>();

    String word = "";

    for (char c : value.toCharArray()) {
      if (seen.get(c) == null) {
        seen.put(c, true);
        word += c;
      }
    }

    return new Pair<>(seen.size(), word);
  }

  /*
   * Given two strings s and t, return true if t is an anagram of s, and false
   * otherwise.
   * 
   * An anagram is a word or phrase formed by rearranging the letters of a
   * different word or phrase, using all the original letters exactly once.
   */

  public static Boolean findAnagram(String value1, String value2) {
    if (value1.length() != value2.length())
      return false;

    char[] value1CharArray = value1.toCharArray();
    Arrays.sort(value1CharArray);
    value1 = new String(value1CharArray);

    char[] value1CharArray2 = value2.toCharArray();
    Arrays.sort(value1CharArray2);
    value2 = new String(value1CharArray2);

    return value1.contentEquals(value2);
  }

  // Given a string s, return the longest palindromic substring in s.
  public String longestPalindrome(String word) {
    if (word == null || word.length() < 1)
      return "";
    int start = 0, end = 0;
    for (int i = 0; i < word.length(); i++) {
      int len1 = expandFromCenter(word, i, i);
      int len2 = expandFromCenter(word, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > (end - start)) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return word.substring(start, end + 1);
  }

  private int expandFromCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }

  /**
   * 📝 Task:
   * Given a string s, reverse the order of words.
   * 
   * A word is defined as a sequence of non-space characters.
   * 
   * Return a string with words in reverse order, separated by a single space.
   * 
   * Ignore leading/trailing/multiple spaces.
   * 
   * examples:
   * 
   * Input: " the sky is blue "
   * Output: "blue is sky the"
   */

  public static String reverSeString(String value) {
    if (value.trim().length() < 1)
      return "";
    String reveredString = "";

    String[] stringCharArray = value.trim().split(" ");

    for (int i = 0; i < stringCharArray.length; i++) {
      reveredString += stringCharArray[stringCharArray.length - (i + 1)];
      if (i != stringCharArray.length - 1)
        reveredString += " ";
    }

    return reveredString;
  }

  /*
   * 📝 Task:
   * Given a string s, return true if it's a valid palindrome, else false.
   * 
   * A valid palindrome:
   * 
   * Reads the same forward and backward
   * 
   * Ignore non-alphanumeric characters
   * 
   * Ignore case
   */
  public static Pair<Boolean, String> ValidPalindrome(String input) {
    char[] inputCharArray = input.toCharArray();
    String filteredValue = "";

    int lastIdx;

    for (int i = 0; i <= inputCharArray.length - 1; i++) {
      if ((inputCharArray[i] >= 'A' && inputCharArray[i] <= 'Z')
          || (inputCharArray[i] >= 'a' && inputCharArray[i] <= 'z')) {
        filteredValue += Character.toLowerCase(inputCharArray[i]);
      }
    }
    lastIdx = filteredValue.length() - 1;
    char[] filteredValueCharArray = filteredValue.toCharArray();

    for (int i = 0; i <= filteredValue.length() - 1; i++) {
      if (filteredValueCharArray[i] != filteredValueCharArray[lastIdx]) {
        return new Pair<>(false, filteredValue);
      }
      lastIdx -= 1;
    }

    Pair<Boolean, String> res = new Pair<>(true, filteredValue);
    return res;
  }

  /*
   * 📝 Leetcode-Style Task: Group Anagrams
   * Problem:
   * 
   * Given an array of strings strs, group the anagrams together. You can return
   * the answer in any order.
   * 
   * An Anagram is a word or phrase formed by rearranging the letters of a
   * different word or phrase, using all the original letters exactly once.
   * 
   * Example:
   * 
   * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
   * Output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
   */

  public static List<List<String>> GroupAnagrams(String[] input) {
    Map<String, List<String>> grouped = new HashMap<>();

    for (int i = 0; i < input.length; i++) {
      String word = input[i];
      char[] wordArray = word.toCharArray();
      Arrays.sort(wordArray);
      String sortedWord = new String(wordArray);

      // Check if key exists
      if (!grouped.containsKey(sortedWord)) {
        grouped.put(sortedWord, new ArrayList<>());
      }

      // Add original word to the correct group
      grouped.get(sortedWord).add(word);
    }

    // Convert map values to a list of lists
    List<List<String>> result = new ArrayList<>();
    for (List<String> group : grouped.values()) {
      result.add(group);
    }

    return result;
  }
}
