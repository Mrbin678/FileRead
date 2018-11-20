//package util;
//
//import com.sun.deploy.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class DealStrSubDemo {
//
//    String regex = "3,(.*?)!!!";
//
//    Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//    Matcher m = p.matcher(oldText);
//    List<String> list = new ArrayList<>();
//        while(m.find()){
//        // 原字符串
//        String strTemp = m.group();
//        if(StringUtils.isNotEmpty(strTemp)){
//            System.out.println(strTemp);
//            list.add(strTemp);
//            break;
//        }
//    }
//
//}
