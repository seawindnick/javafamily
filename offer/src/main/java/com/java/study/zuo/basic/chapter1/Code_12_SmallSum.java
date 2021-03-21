package com.java.study.zuo.basic.chapter1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Code_12_SmallSum {

    public static void main(String[] args) throws IOException {
        String path = "/Volumes/File/zuo";

        File file = new File(path);
        File newFile = new File("/Volumes/work/zuo");
        List<String> fileName = new ArrayList<>();
        fileName.add(file.getName());
        newFile.mkdirs();
        doFile(file, newFile,fileName);
    }

    private static void doFile(File file, File newFile,List<String> fileName) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    String newPath = newFile.getPath() + "/" + file1.getName();
                    File tempFile = new File(newPath);
                    tempFile.mkdir();
                    fileName.add(file1.getName());
                    doFile(file1, tempFile,fileName);
                    fileName.remove(file1.getName());
                } else {
                    if (!file1.getPath().contains("java")){
                        continue;
                    }

                    StringBuilder str = new StringBuilder();
                    String temp = String.join(".",fileName);
//                    str.append("package com.java.study.test"+"."+temp).append(";\r\n");
                    str.append("public class "+file1.getName().replace(".java","")+"{\r\n");
                    str.append("}");

                    String resultFilePath = newFile.getPath() + "/" + file1.getName() ;
                    File resultFile = new File(resultFilePath);
                    resultFile.createNewFile();

                    FileWriter writer = new FileWriter(resultFilePath, true);
                    writer.append(str.toString());
                    writer.flush();
                }
            }
        }
    }

}
