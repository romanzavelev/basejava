package com.urise.webapp;

import java.io.*;

public class MainFile {
    public static void main(String[] args)  {
        String filePath = ".\\.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File dir = new File("./src/com/urise/webapp");
        System.out.println(dir.isDirectory());
        for (String name: dir.list()
             ) {
            System.out.println(name);
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("---------------------------------------------------");
        readFiles(new File("."));


    }

    private static void readFiles(File dir) {
        for (File file: dir.listFiles()) {
            if (file.isDirectory()) {
                readFiles(file);
            } else {
                System.out.println(file.getName());
            }

        }
    }
}
