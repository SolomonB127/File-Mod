//Importation of utilities.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileModification {
    public static void main(String[] args) {
//        Task 1: Creation of file & adding of content.
        String content = "Hello, this  is a file handling project given by Aptech.";

        String contentReverse = new StringBuilder(content).reverse().toString();
        try {
//            Creation of first file.
            File firstFile = new File("firstFile.txt");
            if (firstFile.createNewFile()) {
                System.out.println("File Created:" + firstFile.getName());
            } else {
                System.out.println("File already exists.");
            }
//            Writing content into first file
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
//            Writing content of file1 to file2(in reverse)
            writer = new FileWriter(secondFile);
            writer.write(contentReverse);
            writer.close();
            System.out.println("Successfully wrote reversed content to the second file.");
        } catch (IOException e) {
//            Exception Handling
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}