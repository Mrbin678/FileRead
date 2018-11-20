package util;

import java.io.File;

public class FileName {
    /**
     * @param args
     */
    public static void main(String[] args) {
//      举例：
        String fName =" G:\\Java_Source\\navigation_tigra_menu\\demo1\\img\\lev1_arrow.gif ";

//      方法一：

        File tempFile =new File( fName.trim());

        String fileName = tempFile.getName();

        System.out.println("fileName = " + fileName);

//      方法二：

//        String fName = fName.trim();
//
//        String fileName = fName.substring(fName.lastIndexOf("/")+1);
//        //或者
//        String fileName = fName.substring(fName.lastIndexOf("\\")+1);
//
//        System.out.println("fileName = " + fileName);

//      方法三：

//        String fName = fName.trim();
//
//        String temp[] = fName.split("\\\\"); /**split里面必须是正则表达式，"\\"的作用是对字符串转义*/
//
//        String fileName = temp[temp.length-1];
//
//        System.out.println("fileName = " + fileName);
//
    }
}
