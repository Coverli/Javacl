package com.Object.CommonClass.Big;

import java.math.BigInteger;

// 对货币等大值数据进行计算时，int、long、float和double等基本数据类型已经在精度方面不能满足需求了。
// 为此Java提高了两个大数值类：BigInteger和BigDecimal，这里两个类都继承自Number抽象类。
public class Integer {
    /*
        java.math.BigInteger是不可变的任意精度的大整数。BigInteger构造方法有很多，
        其中字符串参数的构造方法有两个：
            BigInteger(String val)：将十进制字符串val转换为BigInteger对象。
            BigInteger(String val, int radix)：按照指定基数radix将字符串val转换为BigInteger对象。
        BigInteger提供多种方法，下面列举几个常用的方法：
            int compareTo(BigInteger val)：将当前对象与参数val进行比较，方法返回值是int，
                如果返回值是0，则相等；如果返回值小于0，则此对象小于参数对象；如果返回值大于0，则此对象大于参数对象。
            BigInteger add(BigInteger val)：加运算，当前对象数值加参数val。
            BigInteger subtract(BigInteger val)：减运算，当前对象数值减参数val。
            BigInteger multiply(BigInteger val)：乘运算，当前对象数值乘参数val。
            BigInteger divide(BigInteger val)：除运算，当前对象数值除以参数val。

        另外，BigInteger继承了抽象类Number，那么它还有实现抽象类Number的6个方法
    */
    public static void main(String[] args) {
        //创建BigInteger，字符串表示10进制数值
        BigInteger number1 = new BigInteger("999999999999");
        //创建BigInteger，字符串表示16进制数值
        BigInteger number2 = new BigInteger("567800000", 16);
        // 加法操作
        System.out.println("加法操作：" + number1.add(number2));
        // 减法操作
        System.out.println("减法操作：" + number1.subtract(number2));
        // 乘法操作
        System.out.println("乘法操作：" + number1.multiply(number2));
        // 除法操作
        System.out.println("除法操作：" + number1.divide(number2));
    }
}
