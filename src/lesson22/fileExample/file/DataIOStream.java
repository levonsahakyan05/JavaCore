package lesson22.fileExample.file;

import java.io.*;


public class DataIOStream {
    private static final String FILE_PATH = "C:\\Users\\Levon\\IdeaProjects\\JavaCore\\src\\lesson22\\fileExample\\example.txt";

    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    public static void write() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_PATH));
        out.write(543);
        out.writeBoolean(true);
        out.close();
    }

    public static void read() throws IOException {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(FILE_PATH));
        System.out.println(inputStream.readInt());
        System.out.println(inputStream.readBoolean());
        inputStream.close();
    }
}
