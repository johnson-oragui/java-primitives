package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Iterators {
  public static void main(String[] args) {
    List<String> words = new ArrayList<>(Arrays.asList("cat", "book", "hi", "java", "sun", "tree"));
    System.out.println(removeShortWords(words));

    List<String> words2 = new ArrayList<>(Arrays.asList("Apple", "Banana", "apple", "Orange", "BANANA", "Mango"));
    System.out.println(removeDuplicateStrings(words2));
  }

  /*
   * ✅ Task:
   * Given a list of strings, remove all strings that have a length less than 4.
   * 
   * 🔠 Input Example:
   * 
   * ["cat", "book", "hi", "java", "sun", "tree"]
   * 🧾 Expected Output:
   * 
   * ["book", "java", "tree"]
   * 
   */

  public static List<String> removeShortWords(List<String> words) {
    Iterator<String> newIter = words.iterator();

    while (newIter.hasNext()) {
      String next = newIter.next();
      if (next.length() < 4)
        newIter.remove();
    }

    return words;
  }

  /*
   * ✅ Iterator Challenge Task: Remove Duplicate Strings (Case Insensitive)
   * Task:
   * Given a list of strings, remove any duplicates ignoring case sensitivity
   * (e.g., "Apple" and "apple" are duplicates). Keep only the first occurrence.
   * 
   * ✍️ Example
   * Input: ["Apple", "Banana", "apple", "Orange", "BANANA", "Mango"]
   * Output: ["Apple", "Banana", "Orange", "Mango"]
   * 🚧 Your Challenge
   * You must use an Iterator to loop through the list.
   * 
   * You will need to track seen items using a Set<String> (maybe lowercase them).
   * 
   * Only the first occurrence of a word (case-insensitively) should be retained.
   */

  public static List<String> removeDuplicateStrings(List<String> words) {
    Set<String> seen = new HashSet<>();

    Iterator<String> toIter = words.iterator();

    while (toIter.hasNext()) {
      String currentValue = toIter.next();
      String lowered = currentValue.toLowerCase();

      if (seen.contains(lowered)) {
        toIter.remove();
      } else {
        seen.add(lowered);
      }
    }

    return words;
  }
}
