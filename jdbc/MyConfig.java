package jdbc;

import io.github.cdimascio.dotenv.Dotenv;

public class MyConfig {
  public static Dotenv dotenv = Dotenv.load();

  public static final String DB_URL = dotenv.get("DB_URL");
  public static final String DB_USER = dotenv.get("DB_USER");
  public static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");
}
