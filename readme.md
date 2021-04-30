# Java Playground
Project with various Java functionalities categorized by version. 
All examples are in form of unit tests, so you can try them by your own and test your ideas. 

[![Build status](https://github.com/hubertwo/java-playground/actions/workflows/maven.yml/badge.svg)](https://github.com/HubertWo/java-playground/actions)

If you like the repo don't forget to leave a ⭐️ Thanks!

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
[INFO] Tests run: X, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## Topics
Click on the topic to jump straight to code example.

## Java 16 
 - [Record Classes](src/test/java/com/github/hubertwo/playground/java16/record/VehicleTest.java)
 - [Streams toList()](src/test/java/com/github/hubertwo/playground/java16/streams/StreamTest.java)
 - [Streams mapMulti()](src/test/java/com/github/hubertwo/playground/java16/streams/StreamTest.java)
   - [Read more ↗](https://nipafx.dev/java-16-stream-mapmulti/)
 - [Pattern matching for instanceof](src/test/java/com/github/hubertwo/playground/java16/instance/InstanceOfTest.java)
 - [Switch Expressions (yield)](src/test/java/com/github/hubertwo/playground/java16/swtichexpression/SwitchExpressionTest.java)

## Java 15
 - [Text Blocks](src/test/java/com/github/hubertwo/playground/java15/string/TextBlocksTest.java)
## Old Java
 - [POJO deserialization issue](src/test/java/com/github/hubertwo/playground/javaold/serialization/SerializationTest.java)

## Java 12
- [Streams teeing](src/test/java/com/github/hubertwo/playground/java12/streams/StreamTest.java)
- [Strings - indent(), transform()](src/test/java/com/github/hubertwo/playground/java12/string/StringTest.java)


# Read more
1. [Even more greatness packed into Java 16, including tools for improving future JVMs](https://blogs.oracle.com/javamagazine/java-champion-more-favorite-java16-features)
2. [Record Classes](https://docs.oracle.com/en/java/javase/16/language/records.html)