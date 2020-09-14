# Framework setup

Mac OS Platform:
  * java jdk - https://www.oracle.com/in/java/technologies/javase-downloads.html
  * IntelliJ - https://www.jetbrains.com/idea/download/
  * Maven - https://maven.apache.org/
  * Selenium - https://www.selenium.dev/downloads/
  * Git - Install xcode from apple appstore

Windows OS Platform:
  * java jdk - https://www.oracle.com/in/java/technologies/javase-downloads.html
  * IntelliJ - https://www.jetbrains.com/idea/download/
  * Maven - https://maven.apache.org/
  * Selenium - https://www.selenium.dev/downloads/
  * Git - https://git-scm.com/download/win
  * Firefox driver: https://github.com/mozilla/geckodriver/releases (Check for browser campatibility)
  * Chrome driver: https://chromedriver.chromium.org/downloads (Check for browser campatibility)
  
  
# Test execution

* mvn clean test - To run all test cases
* mvn -P All clean test - To run all test cases under profile All
* mvn -P Critical clean test - To run all critical test cases under profile Critical
