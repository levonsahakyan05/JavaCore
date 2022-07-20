package lesson22.fileExample.file;

import java.io.*;

public class FileReadAndWrite {
    private static final String FILE_PATH = "C:\\Users\\Levon\\IdeaProjects\\JavaCore\\src\\lesson22\\fileExample\\file\\textExample.txt";
   static   String rg = "iorhtihe";
    public static void main(String[] args) throws IOException {
        write();
        //read();
    }

    public static void write() throws IOException {
        String re = "levin";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("Hello f rom java \r\n");
            bw.write("Hello from java line 2 !!!!");
            bw.write(rg);
            bw.write(rg);
            bw.write(re);
        }
    }

    public static void read() throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(FILE_PATH))) {
            System.out.println();
          //  String line = "";
           // while ((line = inputStream.readLine()) != null) {
           //     System.out.println(line);
            //}

        }
    }
}
