package queue;

import java.util.*;

public class Queues {
  public static void main(String[] args) {

    List<String> tasks = new ArrayList<>(Arrays.asList("A", "B", "A", "B", "C"));
    int cooldown = 2;

    System.out.println(taskScheduler(tasks, cooldown));
  }

  /*
   * 🔸 Challenge 1: Task Scheduler (Queue)
   * 🧠 Problem:
   * You are given a list of tasks represented by strings and a time limit n that
   * represents the cooldown period between two same tasks.
   * Return the order in which tasks should be processed using a Queue to simulate
   * scheduling.
   * 
   * Input:
   * 
   * List<String> tasks = Arrays.asList("A", "B", "A", "B", "C");
   * int cooldown = 2;
   * 
   * 
   * Output:
   * 
   * [A, B, idle, A, B, C]
   * ✅ Goal:
   * Use a Queue to simulate task execution with idle slots when a task can't run
   * yet due to cooldown.
   */
  public static List<String> taskScheduler(List<String> tasks, int cooldown) {
    Map<String, Integer> cooldownTracker = new HashMap<>();
    Queue<String> scheduled = new LinkedList<>();
    List<String> result = new ArrayList<>();

    int time = 0;
    int index = 0;

    while (index < tasks.size()) {
      String currentTask = tasks.get(index);

      // If task is still cooling down, add idle
      if (cooldownTracker.containsKey(currentTask) && cooldownTracker.get(currentTask) > time) {
        result.add("idle");
      } else {
        result.add(currentTask);
        cooldownTracker.put(currentTask, time + cooldown + 1);
        index++;
      }
      scheduled.add(result.get(result.size() - 1)); // Add current output to queue
      time++;
    }

    return result;
  }

  /*
   * 🔹 Challenge 2: Sliding Window Maximum (Deque)
   * 🧠 Problem:
   * Given an array of integers and a window size k, return a list of the maximum
   * values in each sliding window.
   * 
   * Input:
   * 
   * int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
   * int k = 3;
   * 
   * 
   * Output:
   * 
   * [3, 3, 5, 5, 6, 7]
   * ✅ Goal:
   * Use a Deque to keep track of the indices of potential max elements in the
   * current window.
   */
}
