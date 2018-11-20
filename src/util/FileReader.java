package util;

import java.io.*;

import static util.DealStrSub.getSubUtilSimple;
import static util.DealStrSub.getSubUtilSimple2;
import static util.FileWriter.write;

public class FileReader {
    public static void main(String[] args) throws Exception {
        String filePath = "H:\\东平对账记录\\2018814.txt";
        String content = readTxt(filePath);
        System.out.println(content);
    }

    /**
     * 解析普通文本文件  流式文件 如txt
     * @param path
     * @return
     */
    @SuppressWarnings("unused")
    public static String readTxt(String path){
        StringBuilder content = new StringBuilder("");
        try {
            String code = resolveCode(path);
            File file = new File(path);
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is, code);
            BufferedReader br = new BufferedReader(isr);
//          char[] buf = new char[1024];
//          int i = br.read(buf);
//          String s= new String(buf);
//          System.out.println(s);
            String str = "";
            while ((str = br.readLine()) != null) {
                content.append(str);
//                System.out.println(str);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("读取文件:" + path + "失败!");
        }
        String rgex = "3,(.*?)!!!";
        String rgex2 =  ",[1-9]\\d*\\.?\\d*;";
        String contentStr = getSubUtilSimple(content.toString(),rgex);
        String contentStr2 = getSubUtilSimple2(contentStr,rgex2);
        write(contentStr2,path);
        return contentStr2;
    }



    public static String resolveCode(String path) throws Exception {
        InputStream inputStream = new FileInputStream(path);
        byte[] head = new byte[3];
        inputStream.read(head);
        String code = "gb2312";  //或GBK
        if (head[0] == -1 && head[1] == -2 )
            code = "UTF-16";
        else if (head[0] == -2 && head[1] == -1 )
            code = "Unicode";
        else if(head[0]==-17 && head[1]==-69 && head[2] ==-65)
            code = "UTF-8";

        inputStream.close();

//        System.out.println(code);
        return code;
    }

}
