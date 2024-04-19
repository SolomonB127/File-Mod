import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileModification {
    public static void main(String[] args) {
        // Task 1: Creation of file & adding of content.
        String content = "Hello, this is a file handling project given by Aptech.";

        String contentReverse = new StringBuilder(content).reverse().toString();
        try {
            // Creation of first file.
            File firstFile = new File("firstFile.txt");
            if (firstFile.createNewFile()) {
                System.out.println("File Created:" + firstFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            // Writing content into first file.
            FileWriter writer = new FileWriter(firstFile);
            writer.write(content);
            writer.close();
            System.out.println("Successfully wrote to file.");

            // Task 2: Creation of file2 with reversed content
            File secondFile = new File("secondFile.txt");
            if (secondFile.createNewFile()) {
                System.out.println("File Created:" + secondFile.getName());
            } else {
                System.out.println("File already exist");
            }
            // Writing content of file1 to file2(in reverse).
            writer = new FileWriter(secondFile);
            writer.write(contentReverse);
            writer.close();
            System.out.println("Successfully wrote reversed content to the second file.");

        } catch (IOException e) {
            // Exception Handling
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Copy of first file(for reference)
        try {
            Files.copy(Paths.get("firstFile.txt"), Paths.get("firstFileCopy.txt"));
            System.out.println("Successfully created copy of first file(firstFile.txt)");
        } catch (IOException error) {
            System.out.println("Error occurred while making copy of firstFile");
            error.printStackTrace();
        }

        // Task 3: Displaying content of first file to the console.
        try (BufferedReader reader = new BufferedReader(new FileReader("firstFile.txt"))) {
            String onCurrentLine;
            System.out.println("Content of firstFile.txt:");
            while ((onCurrentLine = reader.readLine()) != null) {
                System.out.println(onCurrentLine);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while trying to read file");
            e.printStackTrace();
        }

        // Task 4: Ask user for input to extract and replace string
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Where should we start extracting text from? Remember, we start counting from 0!: ");
            int startPosition = sc.nextInt();
            System.out.println("How many characters should be replaced?: ");
            int len = sc.nextInt();
            sc.nextLine(); // Consumption of trailing newline.
            System.out.println("Enter the string to replace with: ");
            String replace = sc.nextLine();
            // Reading content from firstFile.txt.
            StringBuilder fileRead = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader("firstFile.txt"))) {
                String onLine;
                while ((onLine = reader.readLine()) != null) {
                    fileRead.append(onLine).append(System.lineSeparator());
                }
            }
            // Replacing the specified substring with user input
            String contentUpdate = fileRead.substring(0, startPosition) + replace + fileRead.substring(startPosition + len);
            // Write updated content back to firstFile.txt
            try (FileWriter writer = new FileWriter("firstFile.txt")) {
                writer.write(contentUpdate);
                System.out.println("Successfully updated the file content");
            }
        } catch (IOException err) {
            System.out.println("An error occurred while updating the file.");
            err.printStackTrace();
        }

        // Task 5: Convert content to bytecode and save to another file
        try(FileInputStream fis = new FileInputStream("firstFile.txt");
             FileOutputStream fos = new FileOutputStream("firstFileBytes.txt")) {
            byte[] buffer = new byte[1024];
        int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("Successfully wrote bytecode to firstFileBytes.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while converting to bytecode.");
            e.printStackTrace();
        }
    }
}



























// //Importation of utilities.

// import java.io.*;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.util.Scanner;

// public class FileModification {
//     public static void main(String[] args) {
// //        Task 1: Creation of file & adding of content.
//         String content = "Hello, this is a file handling project given by Aptech.";

//         String contentReverse = new StringBuilder(content).reverse().toString();
//         try {
// //            Creation of first file.
//             File firstFile = new File("firstFile.txt");
//             if (firstFile.createNewFile()) {
//                 System.out.println("File Created:" + firstFile.getName());
//             } else {
//                 System.out.println("File already exists.");
//             }
// //            Writing content into first file.
//             FileWriter writer = new FileWriter(firstFile);
//             writer.write(content);
//             writer.close();
//             System.out.println("Successfully wrote to file.");

//             // Task 2: Creation of file2 with reversed content
//             File secondFile = new File("secondFile.txt");
//             if (secondFile.createNewFile()) {
//                 System.out.println("File Created:" + secondFile.getName());
//             } else {
//                 System.out.println("File already exist");
//             }
// //            Writing content of file1 to file2(in reverse).
//             writer = new FileWriter(secondFile);
//             writer.write(contentReverse);
//             writer.close();
//             System.out.println("Successfully wrote reversed content to the second file.");
//         } catch (IOException e) {
// //            Exception Handling
//             System.out.println("An error occurred.");
//             e.printStackTrace();
//         }

// //        Copy of first file(for reference)
//         try {
//             Files.copy(Paths.get("firstFile.txt"), Paths.get("firstFileCopy.txt"));
//             System.out.println("Successfully created copy of first file(firstFile.txt)");
//         } catch (IOException error) {
//             System.out.println("Error occurred while making copy of firstFile");
//             error.printStackTrace();
//         }

// //        Task 3: Displaying content of first file to the console.
//         try (BufferedReader reader = new BufferedReader(new FileReader("firstFile.txt"))) {
//             String onCurrentLine;
//             while ((onCurrentLine = reader.readLine()) != null) {
//                 System.out.println(onCurrentLine);
//             }
//         } catch (IOException e) {
//             System.out.println("An error occurred while trying to read file");
//             e.printStackTrace();
//         }

// //        Task 4: Ask user for input to extract and replace string
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Where should we start extracting text from? Remember, we start counting from 0!: ");
//             int startPosition = sc.nextInt();
//             System.out.println("How many characters should be replaced?: ");
//             int len = sc.nextInt();
//             sc.nextLine();//Consumption of trailing newline.
//             System.out.println("Enter the string to replace with: ");
//             String replace = sc.nextLine();
// //            Reading content from firstFile.txt.
//             StringBuilder fileRead = new StringBuilder();
//             try (BufferedReader reader = new BufferedReader(new FileReader("firstFile.txt"))) {
//                 String onLine;
//                 while ((onLine = reader.readLine()) != null) {
//                     fileRead.append(onLine).append(System.lineSeparator());
//                 }
//             }
// //            Replacing the specified substring with user input
//             String contenUpdate = fileRead.substring(0, startPosition) + replace + fileRead.substring(startPosition + len);
// //            Write updated content back to firstFile.txt
//             try (FileWriter writer = new FileWriter("firstFile.txt")) {
//                 writer.write(contenUpdate);
//                 System.out.println("Successfully updated the file content");
//             }
//         } catch (IOException err) {
//             System.out.println("An error occurred while updating the file.");
//             err.printStackTrace();
//         }

//     }
// }

































































// import java.io.*;

// public class FileModification {

//     public static void main(String[] args) throws IOException {
//         // 1. Create a file and write data
//         String fileName = "data.txt";
//         System.out.println("Enter data to write to " + fileName + ": ");
//         String data = new BufferedReader(new InputStreamReader(System.in)).readLine();
//         writeToFile(fileName, data);

//         // 2. Create a file with reversed data
//         String reversedFileName = "reversed_data.txt";
//         String reversedData = reverseString(data);
//         writeToFile(reversedFileName, reversedData);

//         // 3. Display content of the first file
//         System.out.println("\nContent of " + fileName + ":");
//         displayFileContent(fileName);

//         // 4. Extract string based on user input
//         System.out.println("\nEnter starting position (from 1) and length of string to extract:");
//         int start = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
//         int length = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
//         String extractedString = extractString(data, start - 1, length);
//         System.out.println("Extracted string: " + extractedString);

//         // 5. Replace extracted string with user input (assuming replacement happens in memory)
//         System.out.println("\nEnter new string to replace:");
//         String replacement = new BufferedReader(new InputStreamReader(System.in)).readLine();
//         String replacedData = data.replace(extractedString, replacement);

//         // 6. Convert data to byte array and save to another file
//         String byteCodeFileName = "data_bytes.txt";
//         byte[] byteCode = replacedData.getBytes();
//         writeByteArrayToFile(byteCodeFileName, byteCode);

//         System.out.println("\nOperations completed successfully.");
//     }

//     private static void writeToFile(String fileName, String data) throws IOException {
//         FileWriter writer = new FileWriter(fileName);
//         writer.write(data);
//         writer.close();
//     }

//     private static String reverseString(String data) {
//         StringBuilder sb = new StringBuilder(data);
//         return sb.reverse().toString();
//     }

//     private static void displayFileContent(String fileName) throws IOException {
//         FileReader reader = new FileReader(fileName);
//         int ch;
//         while ((ch = reader.read()) != -1) {
//             System.out.print((char) ch);
//         }
//         reader.close();
//     }

//     private static String extractString(String data, int start, int length) {
//         if (start < 0 || start >= data.length() || length <= 0 || start + length > data.length()) {
//             throw new IllegalArgumentException("Invalid start position or length");
//         }
//         return data.substring(start, start + length);
//     }

//     private static void writeByteArrayToFile(String fileName, byte[] byteCode) throws IOException {
//         FileOutputStream outputStream = new FileOutputStream(fileName);
//         outputStream.write(byteCode);
//         outputStream.close();
//     }
// }
