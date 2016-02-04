# FloatNumFileProcessor

Prerequisite to build/run this project:
  1. jdk 1.8   - verified under build 1.8.0_40-b26
  2.  maven 3.2 - verified under Apache Maven 3.2.5
Steps to build:
  1. cd FloatNumFileProcessor
  2. mvn clean package
  As a result, a jar target\FloatNumFileProcessor-1.0-SNAPSHOT.jar is generated.

Steps to unit test:
  1. cd FloatNumFileProcessor
  2. mvn test
  Expected output:
   Results :
   Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

Steps to run:
  1. cd FloatNumFileProcessor
  2. mvn clean package
  3. (E.g in windows) java -cp "c:\Users\yixli\workspace\FloatNumFileProcessor\target\FloatNumFileProcessor-1.0-SNAPSHOT.jar;%CLASSPATH%"  com.codeway.FloatNumberFileProcessor <full path of file to process>
  4. (E.g in linux) java -cp "/Users/yixli/workspace/FloatNumFileProcessortarget/FloatNumFileProcessor-1.0-SNAPSHOT.jar:$CLASSPATH"  com.codeway.FloatNumberFileProcessor <full path of file to process>
  
About test cases:
 Currently, there are five cases to run in "mvn test"
 1. test normal data file
 2. test empty data file
 3. test data file having invalid num format
 4. test non-existing data file
 5. test no input paramter
