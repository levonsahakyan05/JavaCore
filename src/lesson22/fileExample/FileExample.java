package lesson22.fileExample;

import java.io.File;
import java.io.IOException;

public class FileExample {

    static String filePath = "C:\\Users\\Levon\\IdeaProjects\\JavaCore\\src\\lesson22\\testFolder";
    static String newFilePath = "C:\\Users\\Levon\\IdeaProjects\\JavaCore\\src\\lesson22\\testFolder\\hello3.txt";

    public static void main(String[] args) throws IOException {
        File myFile = new File(filePath);
        System.out.println(myFile.exists());
    if (!myFile.exists()){
        myFile.createNewFile();
        System.out.println(myFile.exists());
    }
    System.out.println("isFile: " + myFile.isFile());
       System.out.println("isDirectory: " + myFile.isDirectory());
        if (myFile.isDirectory()){
         File[] files = myFile.listFiles();
          for (File file : files) {
                System.out.println(file.getName());
            }
       }


    }
}
