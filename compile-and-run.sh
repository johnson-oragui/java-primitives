CLASSPATH="java-libs/slf4j-simple-2.1.0-alpha0.jar:java-libs/slf4j-api-2.1.0-alpha1.jar:java-libs/dotenv-java.jar:java-libs/HikariCP-6.3.0.jar:java-libs/postgresql-42.7.3.jar:java-libs/jbcrypt-0.4.jar:."


javac -d build -cp "$CLASSPATH" jdbc/*.java
# java -cp java-libs/HikariCP-6.3.0.jar:java-libs/postgresql-42.7.3.jar:java-libs/jbcrypt-0.4.jar:. jdbc.Main

java -cp "$CLASSPATH:build" jdbc.Main
