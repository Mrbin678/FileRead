package util;

import java.math.BigDecimal;

public class StringTOBigDecimal {

    public static BigDecimal stringToBigDecimal(String str) {
        BigDecimal b = new BigDecimal(str);
        b=b.setScale(2, BigDecimal.ROUND_DOWN); //小数位 直接舍去，不会四舍五入
        return b;
    }
}
