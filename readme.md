# Java Playground
Project with various Java functionalities categorized by version. 
All examples are in form of unit tests, so you can try them by your own and test your ideas. 

[![Build status](https://github.com/hubertwo/java-playground/actions/workflows/maven.yml/badge.svg)](https://github.com/HubertWo/java-playground/actions)

## HowTo
#### Run all tests 
```shell 
mvn test
```
```shell
[INFO] Results:
[INFO] Tests run: X, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## Java 16 
 - [Record](src/test/java/com/github/hubertwo/playground/java16/record/VehicleTest.java)
 - [Streams](src/test/java/com/github/hubertwo/playground/java16/streams/StreamTest.java)
-  [Pattern matching for instanceof](src/test/java/com/github/hubertwo/playground/java16/instance/InstanceOfTest.java)
## Java 15
- [Code blocks](src/test/java/com/github/hubertwo/playground/java15/string/StringTest.java)
## Old Java
- [POJO deserialization issue](src/test/java/com/github/hubertwo/playground/javaold/serialization/SerializationTest.java)

# Read more
1. [Even more greatness packed into Java 16, including tools for improving future JVMs](https://blogs.oracle.com/javamagazine/java-champion-more-favorite-java16-features)
2. [Record Classes](https://docs.oracle.com/en/java/javase/16/language/records.html)