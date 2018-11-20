package util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.StringTOBigDecimal.stringToBigDecimal;

public class DealStrSub {
    /**
     * 正则表达式匹配两个指定字符串中间的内容
     * @param soap
     * @return
     */
    public static List<String> getSubUtil(String soap, String rgex){
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

    /**
     * 返回单个字符串，若匹配到多个的话就返回第一个，方法与getSubUtil一样
     * @param soap
     * @param rgex
     * @return
     */
    public static String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";
    }

    public static String getSubUtilSimple2(String soap,String rgex) {
        Pattern p = Pattern.compile(rgex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(soap);
        List<String> list = new ArrayList<>();
        BigDecimal accountSum = new BigDecimal(0.00);
        while (m.find()){
            String num = m.group().replace(",","").replace(";","");
            System.out.println(num);
            accountSum = accountSum.add(stringToBigDecimal(num));          //stringToBigDecimal(num);
            list.add("               "+num+"\r\n");
        }
        String accountSunStr = "本日对账总金额："+accountSum.toString()+"\r\n"+" 对账金额记录  "+"\r\n";
        list.add(0,accountSunStr);
        System.out.println(accountSum);
        return list.toString();
    }
    /**
     * 测试
     * @param args
     */
        public static void main(String[] args) {
            String str = "abc3443abcfgjhgabcgfjabc!!!1233443abcfgjhgabcgfjabc!!!";
            String rgex = "3(.*?)!!!";
            System.out.println(getSubUtil(str,rgex));
            System.out.println(getSubUtilSimple(str, rgex));
        }

}
