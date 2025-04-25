package scanners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Scanners {
  public static void main(String[] args) {
    // String cwd = System.getProperty("user.dir");
    // StringBuilder path = new StringBuilder();
    // path.append(cwd);
    // path.append("/README.md");

    // fileScanner(path.toString());
    miniShell();
  }

  // Reading from the Console (Keyboard Input)
  public static void consoleScanner() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter your name: ");

      String name = scanner.nextLine();
      System.out.println("Hello, " + name + "!");

    } catch (Exception exc) {
      System.out.println("Error " + exc.getMessage());
    }
  }

  // Reading from a File
  public static void fileScanner(String path) {
    try (Scanner scanner = new Scanner(new FileReader(path))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
      }
    } catch (FileNotFoundException exc) {
      System.out.println("Error: " + exc.getMessage());
    }
  }

  // mini shell
  public static void miniShell() {
    System.out.println("Welcome to MiniShell! Type 'exit' to quit.");
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        System.out.print(">>> ");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("exit")) {
          System.out.println("Exiting MiniShell...");
          break;
        }

        String[] parts = input.split("\\s+");
        if (parts.length == 0)
          continue;

        String command = parts[0];

        switch (command.toLowerCase()) {
          case "echo":
            if (parts.length > 1) {
              System.out.println(String.join(" ", Arrays.copyOfRange(parts, 1, parts.length)));
            } else {
              System.out.println();
            }
          case "ls":
            if (parts.length > 1 && parts.length == 2) {
              String pathName = parts[1];

              String cwd = System.getProperty("user.dir"); // get working dir

              StringBuilder builder = new StringBuilder();
              builder.append(cwd);
              builder.append("/");
              builder.append(pathName); // create a full path

              File isPath = new File(builder.toString());

              System.out.println(isPath.isDirectory());
              if (isPath.isDirectory()) { // its a dir

                File dir = new File(builder.toString());

                for (File file : dir.listFiles()) { // list its files
                  System.out.println(file.getName());
                }
              } else if (isPath.isFile()) {
                System.out.println(pathName);
              } else { // its a file
                System.out.println("ls: cannot access " + "'" + pathName + "'" + ": No such file or directory");
              }
            } else if (parts.length > 2) {
              System.out.println("can not list more than one dir");
            } else {
              File dir = new File(".");

              for (File file : dir.listFiles()) {
                System.out.println(file.getName());
              }
            }
        }
      }
    } catch (Exception exc) {
      System.out.println("An Error Occurred: " + exc.getMessage());
    }
  }
}
