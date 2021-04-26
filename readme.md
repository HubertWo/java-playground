# Java Playground
Project with various Java functionalities categorized by version. 
All examples are in form of unit tests, so you can try them by your own and test your ideas. 

[![Build status](https://github.com/hubertwo/java-playground/actions/workflows/maven.yml/badge.svg)](https://github.com/HubertWo/java-playground/actions)

### Quick start
To clone the repository and run all tests run commands bellow.
Project requires Java 16 and Maven.
```shell
git clone https://github.com/HubertWo/java-playground.git;
cd java-playground;
mvn test
```
```shell
[INFO] Results:
[INFO] Tests run: 18, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## Java 16 
 - [Record Classes](src/test/java/com/github/hubertwo/playground/java16/record/VehicleTest.java)
 - [Streams toList()](src/test/java/com/github/hubertwo/playground/java16/streams/StreamTest.java)
 - [Streams mapMulti()](src/test/java/com/github/hubertwo/playground/java16/streams/StreamTest.java)
 - [Pattern matching for instanceof](src/test/java/com/github/hubertwo/playground/java16/instance/InstanceOfTest.java)
 - [Switch Expressions (yield)](src/test/java/com/github/hubertwo/playground/java16/swtichexpression/SwitchExpressionTest.java)

## Java 15
 - [Text Blocks](src/test/java/com/github/hubertwo/playground/java15/string/TextBlocksTest.java)
## Old Java
 - [POJO deserialization issue](src/test/java/com/github/hubertwo/playground/javaold/serialization/SerializationTest.java)

# Read more
1. [Even more greatness packed into Java 16, including tools for improving future JVMs](https://blogs.oracle.com/javamagazine/java-champion-more-favorite-java16-features)
2. [Record Classes](https://docs.oracle.com/en/java/javase/16/language/records.html)