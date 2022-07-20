package homework.fileUtil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // fileSearch();
        // contentSearch();
        // findLines();
        //  printSizeOfPackage();
        // createFileWithContent();
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() throws IOException {
        System.out.println("Input folder path");
        String path = scanner.nextLine();
        System.out.println("Input fileName");
        String fileName = scanner.nextLine();

        File file = new File(path, fileName);
        System.out.println(file.exists());

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() throws IOException {
        System.out.println("Input folder path");
        String path = scanner.nextLine();
        System.out.println("Input keyword");
        String keyword = scanner.nextLine();

        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isFile() && file1.getName().endsWith(".txt")) {
                    BufferedReader reader = new BufferedReader(new FileReader(file1.getAbsolutePath()));
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        if (keyword.contains(line)) {
                            System.out.println(file1.getName());
                        }

                    }

                }
            }
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() throws IOException {
        System.out.println("input txtPath");
        String txtPath = scanner.nextLine();
        System.out.println("input keyword");
        String keyword = scanner.nextLine();
        File file = new File(txtPath);
        if (file.exists() && file.isFile()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String txtKeyword = "";
            int num = 0;
            while ((txtKeyword = reader.readLine()) != null) {
                num++;
                if (txtKeyword.equals(keyword)) {
                    System.out.println(num + ": " + keyword);

                }
            }

        }


    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        System.out.println("Input folder path");
        String path = scanner.nextLine();
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            int x = 0;
            for (File listFile : file.listFiles()) {
                x += listFile.length();
            }
            System.out.println(x);

        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() throws IOException {
        System.out.println("input folder path");
        String folderPath = scanner.nextLine();
        System.out.println("input fileName");
        String filName = scanner.nextLine();
        System.out.println("input content");
        String content = scanner.nextLine();
        File file = new File(folderPath);
        if (file.exists() && file.isDirectory()) {
            StringBuilder path = new StringBuilder(folderPath);
            path.append("\\");
            path.append(filName);
            File folder = new File(String.valueOf(path));
            folder.createNewFile();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(folder))) {
                bufferedWriter.write(content);
            }


        }
    }

}
