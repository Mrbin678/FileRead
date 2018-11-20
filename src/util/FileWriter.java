package util;

import java.io.File;
import java.io.FileOutputStream;

public class FileWriter {

    public static void write(String sourceString,String path){

        File tempFile =new File( path.trim());
        String fileName = tempFile.getName();
        String filePath = "C:\\Users\\Administrator\\Desktop\\银行对账记录\\"+fileName;
//        String sourceString = "sourceString";	//待写入字符串
        byte[] sourceByte = sourceString.getBytes();
        if(null != sourceByte){
            try {
                File file = new File(filePath);		//文件路径（路径+文件名）
                if (!file.exists()) {	//文件不存在则创建文件，先创建目录
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);	//文件输出流用于将数据写入文件
                outStream.write(sourceByte);
                outStream.close();	//关闭文件输出流
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}



