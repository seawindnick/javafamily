package com.java.study.offer;

import org.apache.poi.POITextExtractor;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFComment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * <Description>
 *
 * @author hushiye
 * @since 5/12/21 23:52
 */
public class Move {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/hushiye/Downloads/temp";
        File file = new File(filePath);
        handle(file);
    }

    private static void handle(File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                handle(file1);
            }
        } else {
            if (file.length() > 1024 * 100 * 100 && !file.getName().contains(".js")) {

                File dest = new File("/Users/hushiye/Downloads/temp/" + file.getName());

                file.renameTo(dest);
//
//                InputStream input = null;
//                OutputStream output = null;
//                try {
//                    input = new FileInputStream(file);
//                    output = new FileOutputStream(dest);
//                    byte[] buf = new byte[1024 * 1024];
//                    int bytesRead;
//                    while ((bytesRead = input.read(buf)) > 0) {
//                        output.write(buf, 0, bytesRead);
//                    }
//                } catch (Exception ex) {
//                    System.out.println(file.getName());
//                } finally {
//                    try {
//                        input.close();
//                        output.close();
//                    } catch (Exception ec) {
//                        System.out.println(file.getName());
//                    }
//
//                }

            }


        }
    }


//    public static void main(String[] args) throws Exception {
//        InputStream in1 = null;
//        InputStream in2 = null;
//        OPCPackage src1Package = null;
//        OPCPackage src2Package = null;
//
//        OutputStream dest = new FileOutputStream("/Volumes/File/shishan/01/merge.docx");
//        String filePath = "/Volumes/File/shishan/01/word";
//        File file = new File(filePath);
//        File[] fileList = file.listFiles();
//        Arrays.sort(fileList, new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//        Stack<File> stack = new Stack<>();
//        for (int i = 0; i < fileList.length; i++) {
//            stack.push(fileList[i]);
//        }
//
//
//        in1 = new FileInputStream(fileList[0]);
//        src1Package = OPCPackage.open(in1);
//
//        for (int i = 1; i < fileList.length; i++) {
//            in2 = new FileInputStream(fileList[i]);
//            src2Package = OPCPackage.open(in2);
//        }
//
//
//

//    in1 =new
//
//    FileInputStream(fileList[1]);
//
//    src1Package =OPCPackage.open(in1);
//    XWPFDocument src1Document = new XWPFDocument(src1Package);
//    CTBody src1Body = src1Document.getDocument().getBody();
//
//        for(
//    int i = 2;
//    i<fileList.length;i++)
//
//    {
//        in2 = new FileInputStream(fileList[i]);
//        src2Package = OPCPackage.open(in2);
//        XWPFDocument src2Document = new XWPFDocument(src2Package);
//        CTBody src2Body = src2Document.getDocument().getBody();
//        appendBody(src1Body, src2Body);
//    }
//
//
//        src1Document.write(dest);

//}

    private static void appendBody(CTBody src, CTBody append) throws Exception {
        XmlOptions optionsOuter = new XmlOptions();
        optionsOuter.setSaveOuter();
        String appendString = append.xmlText(optionsOuter);
        String srcString = src.xmlText();
        String prefix = srcString.substring(0, srcString.indexOf(">") + 1);
        String mainPart = srcString.substring(srcString.indexOf(">") + 1, srcString.lastIndexOf("<"));
        String sufix = srcString.substring(srcString.lastIndexOf("<"));
        String addPart = appendString.substring(appendString.indexOf(">") + 1, appendString.lastIndexOf("<"));
        CTBody makeBody = CTBody.Factory.parse(prefix + mainPart + addPart + sufix);
        src.set(makeBody);
    }

    //    public static void main(String[] args) throws IOException {
//        String filePath = "/Volumes/File/shishan/01/word";
//        File file = new File(filePath);
//
//        String targetPath = "/Volumes/File/shishan/01/merge.docx";
//        File targetFile = new File(filePath);
//
//        if (targetFile.exists()) {
//            targetFile.delete();
//            targetFile.createNewFile();
//        }
//
//        FileOutputStream fos = new FileOutputStream(targetPath); //创建输出流对象
//        byte datas[] = new byte[1024 * 8];//创建搬运工具
//        int len = 0;//创建长度
//
//
//        File[] fileList = file.listFiles();
//
//        Arrays.sort(fileList, new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//
//        FileInputStream fis = null;
//        for (File file1 : fileList) {
//
//            if (file1.getName().contains("DS_Store")) {
//                continue;
//            }
//            fis = new FileInputStream(file1);//创建输入流对象
//
//            while ((len = fis.read(datas)) != -1)//循环读取数据
//            {
//                fos.write(datas, 0, len);
//            }
//
//        }
//
//        fis.close();//释放资源
//        fos.close();
//
//
//    }
}
