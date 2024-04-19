//Importation of utilities
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
