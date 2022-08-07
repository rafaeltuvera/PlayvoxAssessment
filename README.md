clone repo: git clone https://github.com/rafaeltuvera/PlayvoxAssessment.git

Pre requisite before running tests:
1. Set up maven and jdk -> download maven here: https://maven.apache.org/download.cgi select apache-maven-3.8.6-bin.zip, and download jdk-13 from google drive link provided in email.
2. Install jdk and maven in your machine(use files from step 1)\
-jdk for windows https://mkyong.com/java/how-to-set-java_home-on-windows-10/ \
-jdk for mac https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux OR https://www.digitalocean.com/community/tutorials/install-maven-mac-os (refer to Step1) \
-maven for windows(Skip to step2) https://phoenixnap.com/kb/install-maven-windows \
-maven for mac (Skip to step2) https://www.digitalocean.com/community/tutorials/install-maven-mac-os \

Install dependencies: navigate to project directory, open command line then -> mvn install -DskipTests=true\
Run tests: mvn clean test

reports - target/surefire-reports/index.html

Additional notes: ignore [Error] Warning in logs, its a known issue-> https://github.com/spotbugs/spotbugs/issues/499