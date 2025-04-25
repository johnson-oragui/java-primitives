package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exceptions {
  public static void main(String[] args) {
    // try {
    // checkAge(12);
    // } catch (AgeException exc) {
    // System.out.println("Error checking age: " + exc.getMessage());
    // }
    Path path = Paths.get("exceptions", "sample.txt");
    System.out.println(path.toAbsolutePath());
    readFromFile(path.toString());
  }

  static void divide(int a, int b) {
    try {
      int result = a / b;
      System.out.println("Result: " + result);
    } catch (ArithmeticException exc) {
      System.out.println("Cannot divide by zero.");
    } finally {
      System.out.println("Operation attempted.");
    }
  }

  // checked exceptions
  public static void readFile(String filePath) throws IOException {
    FileReader fr = new FileReader(filePath);
    System.out.println(fr);
  }

  // unchecked exception
  public static void parse(String num) {
    int val = Integer.parseInt(num); // NumberFormatException is unchecked
  }

  public static void checkAge(int age) throws AgeException {
    if (age < 18) {
      throw new AgeException("You must be atleast 18.");
    }
  }

  /*
   * try-with-resources
   */
  public static void readFromFile(String path) {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException exc) {
      System.out.println("Error reading file: " + exc.getMessage());
    }
  }
}

class AgeException extends Exception {
  public AgeException(String msg) {
    super(msg);
  }
}