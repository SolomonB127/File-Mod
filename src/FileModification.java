//Importation of utilities.
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileModification {
    public static void main(String[] args) throws IOException {
//        Task 1: Creation of file & adding of content.
        String content = "Hello, this is a file handling project given by Aptech.";

        String contentReverse = new StringBuilder(content).reverse().toString();
        try {
//            Creation of first file.
            File firstFile = new File("firstFile.txt");
            if (firstFile.createNewFile()) {
                System.out.println("File Created:" + firstFile.getName());
            } else {
                System.out.println("File already exists.");
            }
//            Writing content into first file.
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
//            Writing content of file1 to file2(in reverse).
            writer = new FileWriter(secondFile);
            writer.write(contentReverse);
            writer.close();
            System.out.println("Successfully wrote reversed content to the second file.");
        } catch (IOException e) {
//            Exception Handling
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Compare the content of the first file and the reversed content in the second file
        String originalContent = Files.readString(Paths.get("firstFile.txt"));
        String reversedContent = Files.readString(Paths.get("secondFile.txt"));
        if (originalContent.equals(new StringBuilder(reversedContent).reverse().toString())) {
            System.out.println("The content of both files match.");
        } else {
            System.out.println("The content of both files is different.");
        }

//        Copy of first file(for reference)
        try {
            Files.copy(Paths.get("firstFile.txt"), Paths.get("firstFileCopy.txt"));
            System.out.println("Successfully created copy of first file(firstFile.txt)");
        } catch (IOException error) {
            System.out.println("Error occurred while making copy of firstFile");
            error.printStackTrace();
        }

//        Task 3: Displaying content of first file to the console.
        try (BufferedReader reader = new BufferedReader(new FileReader("firstFile.txt"))) {
            String onCurrentLine;
            while ((onCurrentLine = reader.readLine()) != null) {
                System.out.println(onCurrentLine);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while trying to read file");
            e.printStackTrace();
        }

//        Task 4: Ask user for input to extract and replace string
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Where should we start extracting text from? Remember, we start counting from 0!: ");
            int startPosition = sc.nextInt();
            System.out.println("How many characters should be replaced?: ");
            int len = sc.nextInt();
            sc.nextLine();//Consumption of trailing newline.
            System.out.println("Enter the string to replace with: ");
            String replace = sc.nextLine();
//            Reading content from firstFile.txt.
            StringBuilder fileRead = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader("firstFile.txt"))) {
                String onLine;
                while ((onLine = reader.readLine()) != null) {
                    fileRead.append(onLine).append(System.lineSeparator());
                }
            }
//            Replacing the specified substring with user input
            String contenUpdate = fileRead.substring(0, startPosition) + replace + fileRead.substring(startPosition + len);
//            Write updated content back to firstFile.txt
            try (FileWriter writer = new FileWriter("firstFile.txt")) {
                writer.write(contenUpdate);
                System.out.println("Successfully updated the file content");
            }
        } catch (IOException err) {
            System.out.println("An error occurred while updating the file.");
            err.printStackTrace();
        }
    }
}