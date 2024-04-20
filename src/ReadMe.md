# File Handling Project Documentation

## Certificate of Completion

This document certifies that the File Handling Project has been completed successfully. All required functionalities
have been implemented and tested.

## Acknowledgement

We would like to extend my heartfelt thanks to Mr. Obed Jonathan & Miss. Praise-Jah Ogbonna, whose invaluable guidance
and support played a pivotal role in the successful completion of this project. We are also grateful to our peers and
the technical staff at Aptech,Alagbole for their assistance and encouragement. This project would not have been possible
without the collaborative effort and shared insights of everyone involved.

## Project Synopsis

The File Handling Project is designed to streamline and automate file operations using Java. The project encompasses a
range of functionalities, including file creation, content manipulation, and byte code conversion. Aimed at enhancing
efficiency and accuracy, this application serves as a robust tool for managing and processing files within various
systems.

## Table of Contents

1. Problem Definition
2. Algorithms
3. Task Sheet
4. Project Review and Monitoring Report
5. Project Analysis
6. Project Design
7. Database Structure
8. Screen Shots
9. Source Codes with Comments
10. User Guide
11. Developers Guide-Module Description
12. Final Check List
13. Conclusion
14. Developers Information

## Problem Definition

The project involves creating a Java application that manages file operations such as creation, content reversal,
content comparison, content extraction and replacement, and byte code conversion.

## Algorithms

- **File Creation**: Check if the file exists, create it if not, and write initial content.
- **Content Reversal**: Read content from the first file, reverse it, and write to the second file.
- **Content Comparison**: Compare the content of the first and second files to check for equality.
- **Content Extraction**: Prompt the user for position and length, extract the substring if within bounds.
- **Content Replacement**: Replace the extracted string with user input in the third file.
- **Byte Code Conversion**: Convert the content of the first file into byte codes and write to the fourth file.

## Task Sheet

- Task 1: Implement file creation and data writing.
- Task 2: Develop logic for reversing file content.
- Task 3: Code the content comparison functionality.
- Task 4: Create user prompts for content extraction.
- Task 5: Handle content replacement in a new file.
- Task 6: Convert and save data as byte codes.

## Project Review and Monitoring Report

The project has been reviewed at various stages to ensure that it meets the requirements and follows best practices in
coding and file handling.

## Project Analysis

The project was initiated with the aim of creating a Java application capable of handling various file operations. The
development process involved several stages, each presenting unique challenges and learning opportunities. The
successful completion of the project demonstrates the effective application of Java programming concepts and file
handling techniques.

## Project Design

The project design includes:

- **DFD's (Data Flow Diagrams)
  **: ![diagram-export-20-04-2024-14_11_03.png](..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2Fdiagram-export-20-04-2024-14_11_03.png)
- **Flowcharts
  **: ![diagram-export-20-04-2024-14_14_43.png](..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2Fdiagram-export-20-04-2024-14_14_43.png)
- **Process Diagram
  **: ![diagram-export-20-04-2024-14_17_10.png](..%2F..%2F..%2F..%2F..%2F..%2FDownloads%2Fdiagram-export-20-04-2024-14_17_10.png)
  that visually represent the project's workflow. These diagrams provide a clear understanding of the project's
structure and the interconnections between its various components.

## Database Structure
The project does not involve the use of a database. Therefore, this section is not applicable.

## Screen Shots
Screenshots of the application's interface to illustrate its functionality:
![Screenshot (158).png](..%2F..%2F..%2F..%2F..%2F..%2FPictures%2FScreenshots%2FScreenshot%20%28158%29.png)
![Screenshot (155).png](..%2F..%2F..%2F..%2F..%2F..%2FPictures%2FScreenshots%2FScreenshot%20%28155%29.png)
![Screenshot (156).png](..%2F..%2F..%2F..%2F..%2F..%2FPictures%2FScreenshots%2FScreenshot%20%28156%29.png)
![Screenshot (157).png](..%2F..%2F..%2F..%2F..%2F..%2FPictures%2FScreenshots%2FScreenshot%20%28157%29.png)

## Source Codes with Comments
The source code of the project is provided below with detailed comments explaining each segment:

```java
// Importation of utilities

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileModification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            //  File creation & addition of data.
            File file1 = new File("firstFile.txt");
            if (file1.exists()) {
                System.out.println("The file 'firstFile.txt' already exists.");
            } else {
                file1.createNewFile();
                System.out.println("The file 'firstFile.txt' has been created.");
            }
            FileWriter writer = new FileWriter(file1);
            writer.write("Hello!, this is an Aptech file handling project.");
            writer.close();
            System.out.println("Content has been added to 'firstFile.txt'.");

            //  Create a copy of the first file(for reference).
            File file1Copy = new File("firstFile_copy.txt");
            if (!file1Copy.exists()) {
                file1Copy.createNewFile();
            }
            Files.copy(file1.toPath(), file1Copy.toPath(), StandardCopyOption.REPLACE_EXISTING);

            //  Create another file with reversed content of first file.
            File file2 = new File("reversed.txt");
            if (file2.exists()) {
                System.out.println("The file 'reversed.txt' already exists.");
            } else {
                file2.createNewFile();
                System.out.println("The file 'reversed.txt' has been created.");
            }
            writer = new FileWriter(file2);
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            String content = reader.readLine();
            String reversedContent = new StringBuilder(content).reverse().toString();
            writer.write(reversedContent);
            writer.close();
            System.out.println("Reversed content has been added to 'reversed.txt'.");

            //  Compare the contents of the first and second files to see if they match.
            boolean areContentsEqual = content.equals(new StringBuilder(reversedContent).reverse().toString());
            System.out.println("Do the first and second files have the same content? " + areContentsEqual);

            //  Display content of the first file.
            System.out.println("First file content: " + content);

            //  Ask user for input to extract string.
            System.out.println("Enter the position to extract the string! Remember we start counting from 0.:");
            int position = scanner.nextInt();
            System.out.println("Enter the length of the string to extract:");
            int length = scanner.nextInt();
            // Check if the length exceeds the content length
            if (position + length > content.length()) {
                System.out.println("The length you entered exceeds the content length. Please try again.");
                return;
            }
            String extractedString = content.substring(position, position + length);

            //  Replace extracted string in a third file
            File file3 = new File("modified.txt");
            if (!file3.exists()) {
                file3.createNewFile();
            }
            writer = new FileWriter(file3);
            System.out.println("Enter the string to replace the extracted string:");
            scanner.nextLine(); // Consume the remaining newline
            String replacement = scanner.nextLine();
            String modifiedContent = content.replace(extractedString, replacement);
            writer.write(modifiedContent);
            writer.close();

            // Convert first file data into byte codes
            File file4 = new File("bytecodes.txt");
            if (!file4.exists()) {
                file4.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(file4);
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            outputStream.write(byteContent);
            outputStream.close();

            // Closing resources
            reader.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## User Guide
This section provides detailed instructions on how to use the File Modification Application to perform various file
operations:
- **File Creation and Data Addition**: Upon running the app, it creates a text file named "firstFile.txt" if it does not
  already exist. It then adds the specified content to the file.
- **Content Reversal**: The app creates a copy of the first file and then generates another file named "reversed.txt"
  containing the reversed content of the first file.
- **Content Comparison**: After generating the reversed content, the app compares it with the original content to
  determine if they match.
- **Content Extraction & Replacement**: Users can input a position and length to extract a substring from the original
  content. The extracted string can then be replaced with a user-specified string in a separate file named "
  modified.txt".

## Developers Guide-Module Description
This section provides insights into the implementation details of the File Modification Application, guiding developers
on how to understand and extend its functionality:
- **Overview**: The app is implemented in Java and utilizes file handling and string manipulation techniques to perform
  various operations on text files.
- **File Handling**: It employs classes from the java.io and java.nio.file packages to create, read, write, and copy
  text files.
- **Content Manipulation**: The app uses FileReader, FileWriter, BufferedReader, and FileOutputStream to manipulate the
  content of text files, including reversing, extracting, and replacing strings.
- **Error Handling**: Exception handling is implemented to gracefully manage errors that may occur during file
  operations, ensuring a smooth user experience.

## Final Check List
- [x] Code compiles without errors.
- [x] All functionalities have been implemented as per the problem statement.
- [x] Code has been reviewed and optimized.
- [x] Documentation is complete and accurate.

## Conclusion
The File Modification Application provides a convenient way to perform various file operations in Java. Whether you're a
user looking to manipulate text files or a developer seeking to extend the app's functionality, this guide equips you
with the necessary knowledge to effectively utilize and understand the application.

## *Developers Information*:
- **_Developed By_**: *Akinsulire Solomon Olabode, Chukwujekwu Chimaobi Micheal & Ajayi Akinloluwa*.
- **_GitHub Repository_**: *https://github.com/SolomonB127/File-Mod.git*
- **_Start Date_**: 15th, April 2024.
- **_End Date_**: 18th, April 2024.
