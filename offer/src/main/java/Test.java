import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <Description>
 *
 * @author hushiye
 * @since 8/9/21 11:53
 */
public class Test {

    public static void main(String[] args) throws Exception {

        handle();
    }


    public static void handle() throws Exception {
        String filePath = "/Users/hushiye/Downloads/1.txt";
        Boolean flag = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
        String s = null;
        String fileName = "";
        StringBuilder body = new StringBuilder();
        String fileSort = "";

        while ((s = br.readLine()) != null) {
            if (s.contains("$$$$")) {
                if (body.length() > 0) {
//                    handle(fileName, body);
                    body = new StringBuilder();
                }
                String sort = br.readLine();
                fileSort = "L" + (10000 + Integer.parseInt(sort)) + "";
                continue;
            }
            if (s.contains("class") || s.contains("leetcode submit region end(Prohibit modification and deletion)")) {
                continue;
            }
            if (s.contains("public")) {
                String[] arr = s.split(" ");
                List<String> list = Stream.of(arr).filter(str -> !str.isEmpty()).collect(Collectors.toList());
                fileName = list.get(2);
                int leftIndex = fileName.indexOf("(");
                try {
                    fileName = fileName.substring(0, leftIndex);
                } catch (Exception ex) {
                    fileName = fileSort + "_ERROR";
                    System.out.println(fileSort);
                    continue;
                }


                fileName = fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
                fileName = fileSort + "_" + fileName;
                body.append("//public class " + fileName).append("\r\n");
            }
            body.append("//").append(s).append("\r\n");

        }


    }

    private static void handle(String fileName, StringBuilder body) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("/Volumes/work/workspace/study/javafamily/offer/src/main/java/temp/" + fileName + ".java"));
        out.write(body.toString().substring(0, body.toString().length() - 1));
        out.close();
        System.out.println("文件创建成功！");
    }
}
