package com.Object.CommonClass.Big;

import java.math.BigDecimal;

public class Decimal {
    /*
        java.math.BigDecimal是不可变的任意精度的有符号十进制数。BigDecimal构造方法有很多：
            BigDecimal(BigInteger val)：将BigInteger对象val转换为BigDecimal对象。
            BigDecimal(double val)：将double转换为BigDecimal对象，参数val是double类型的二进制浮点值准确的十进制表示形式。
            BigDecimal(int val)：将int转换为BigDecimal对象。
            BigDecimal(long val)：将long转换为BigDecimal对象。
            BigDecimal(String val)：将字符串表示数值形式转换为BigDecimal对象。
        BigDecimal提供多种方法，下面列举几个常用的方法：
            int compareTo(BigDecimal val)：将当前对象与参数val进行比较，方法返回值是int，
                如果返回值是0，则相等；如果返回值小于0，则此对象小于参数对象；如果返回值大于0，则此对象大于参数对象。
            BigDecimal add(BigDecimal val)：加运算，当前对象数值加参数val。
            BigDecimal subtract(BigDecimal val)：减运算，当前对象数值减参数val。
            BigDecimal multiply(BigDecimal val)：乘运算，当前对象数值乘参数val。
            BigDecimal divide(BigDecimal val)：除运算，当前对象数值除以参数val。
            BigDecimal divide(BigDecimal val, int roundingMode)：除运算，当前对象数值除以参数val。
                roundingMode要应用的舍入模式。

            另外，BigDecimal继承了抽象类Number，那么它还实现抽象类Number的6个方法，
    */
    public static void main(String[] args) {
        // 创建BigDecimal，通过字符参数串创建
        BigDecimal number1 = new BigDecimal("999999999.99988888");
        // 创建BigDecimal，通过double参数创建
        BigDecimal number2 = new BigDecimal(-567800000.888888);
        // 加法操作
        System.out.println("加法操作：" + number1.add(number2));
        // 减法操作
        System.out.println("减法操作：" + number1.subtract(number2));
        // 乘法操作
        System.out.println("乘法操作：" + number1.multiply(number2));
        // 除法操作
        System.out.println("除法操作："
                + number1.divide(number2, BigDecimal.ROUND_HALF_UP));
        // 除法运算divide，该方法需要指定舍入模式，如果不指定舍入模式那么会发生运行期异常ArithmeticException，
        // 舍入模式BigDecimal.ROUND_HALF_UP是四舍五入
    }
}
