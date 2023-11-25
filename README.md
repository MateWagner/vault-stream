# Passphrase Validator

## About

It's a mini Java application that can tell you how many valid passphrases are in a text file based on certain criteria.
The text file should contain the passphrases, one line is equal to one passphrase.
Passphrase validation rules:

- should contain only lower-case English alphabet letters.
- should contain a minimum of two words.
- each word should be separated by a space.
- each passphrase should finish with one of three punctuation marks. *!.?*

## How to use

### Build with Maven

Required software:

- Java 17 SDK
- Maven
- Git (optional)

Steps to run:

- Download or clone the GitHub repository.
- Open a console in the project root directory.
- Run the command to build the jar file in the target folder: `mvn clean package`
- Step into the target folder: `cd ./target`
- Run the application with the path to the included
  input.txt: `java -jar vault-stream-1.0-SNAPSHOT.jar ../src/main/resources/input.txt`

### Download jar file from GitHub Releases

Required software:

- Java 17 JRE

Steps to run:

- Download the latest build release jar file from GitHub.
- Open a terminal window where the jar file is located.
- Create your own txt file that contains your passphrases.
- Run `java -jar vault-stream-1.0-SNAPSHOT.jar {relative path for txt file}`

### Run with IntelliJ

Required software:

- Java 17 SDK
- Maven
- Git

Steps to run:

- Clone the project repository.
- Open the pom.xml as a project in IntelliJ.
- Open the Run/Debug Configuration.
- Add a new configuration: Application
    - Choose the Main.class
    - In the Program arguments field, you can copy this path: *src/main/resources/input.txt* or give your own file path.
    - Click on the Run button, and the program will start.
