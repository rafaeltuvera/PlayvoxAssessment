# PlayvoxAssessment

clone repo: git clone https://github.com/rafaeltuvera/PlayvoxAssessment.git

Pre requisite before running tests:
1. install jdk and maven in your machine 
-unzip apache-maven-3.6.2 and jdk-13.0.1
-jdk for windows https://mkyong.com/java/how-to-set-java_home-on-windows-10/
-jdk for mac https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux OR https://www.digitalocean.com/community/tutorials/install-maven-mac-os (Step1)
-maven for windows(Skip to step2) https://phoenixnap.com/kb/install-maven-windows
-maven for mac (Skip to step2) https://www.digitalocean.com/community/tutorials/install-maven-mac-os

Note: no need to download maven and jdk, please use the zip files :)

Install dependencies: navigate to project directory, open command line then -> mvn install -Dskiptests=true
Run tests: mvn test

reports - target/surefire-reports/index.html

Additional notes: ignore [Error] Warning in logs -> https://github.com/spotbugs/spotbugs/issues/499