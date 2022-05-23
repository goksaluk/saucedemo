SAUCE DEMO APPLICATION TESTING EXERCISE / INSTRUCTIONS

Codes and Tests Prepared by: Goksal Cavdar o

Test Automation Engineer

goksaluk@gmail.com

https://www.linkedin.com/in/goksal-cavdar-o

SELENIUM-JAVA-BDD:

 -This repository contains a collection of sample selenium-cucumber-java projects and libraries that demonstrate 
  how to use the tool and develop automation script using the Cucumber BDD framework with Java as programming language. 
  It generate HTML reporter as well. It also generate screen shots for our tests.

- Build Tool: Maven 
- Dependencies : Cucumber J-Unit, Cucumber-Java etc. from mvnrepository.com and stored in pom.xml file
- Test Framework: Cucumber BBD (with Junit Assertions)
- Design Pattern: Page Object Model

PROPERTIES FILE:
-browser
-URL :
  https://www.saucedemo.com/

ACCEPTANCE CRITERIA:

System Requirements:

- Java 8+ SDK
- Test RUN
- IntelliJ

RUN SOME SAMPLE TESTS
Open terminal (MAC OSX) or command prompt / power shell (for windows OS) and navigate to the project directory 
type:
-mvn test command to run tests. With this command it will invoke the default chorome browser and will execute the tests.
-If we want to override the configurations mentioned in the Runner, then we need to use following command: 
 mvn test –DCucumber.options="Your Options"
-If you want to run the test cases associated to Tags, this is how we specify : 
 mvn test -Dcucumber.options="--tags @tagName"
-To run features on specific browser use, mvn test "-Dbrowser=browser_name" browser_name can be one of following 
 but make sure that browser’s driver file are present and specified in system variable. -- firefox -- chrome -- ie -- safari etc.
-To run specific feature if you have multiple feature files use, mvn test -Dcucumber.options="classpath:features/login.feature"

REPORT:
-run: mvn verify test command, and get the report under the target file which is pointed in the cukes runner classes.