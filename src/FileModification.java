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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}