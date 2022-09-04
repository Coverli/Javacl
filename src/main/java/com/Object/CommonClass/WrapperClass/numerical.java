package com.Object.CommonClass.WrapperClass;

// 数值包装类
public class numerical {
    /*
        这些数值包装类（Byte、Short、Integer、Long、Float和Double）都有一些相同特点。
        01. 构造方法类似
            每一个数值包装类都有两个构造方法，以Integer为例，Integer构造方法如下：
                Integer(int value)：通过指定一个数值构造Integer对象。
                Integer(String s)：通过指定一个字符串s构造对象，s是十进制字符串表示的数值。
        02. 共同的父类
            这6个数值包装类有一个共同的父类——Number，Number是一个抽象类，除了这6个子类还有：
            AtomicInteger、AtomicLong、BigDecimal和BigInteger，其中BigDecimal和BigInteger后面还会详细介绍。
            Number是抽象类，要求它的子类必须实现如下6个方法：
                byte byteValue()：将当前包装的对象转换为byte类型的数值。
                double doubleValue()：将当前包装的对象转换为double类型的数值。
                float floatValue()：将当前包装的对象转换为float类型的数值。
                int intValue()：将当前包装的对象转换为int类型的数值。
                long longValue()：将当前包装的对象转换为long类型的数值。
                short shortValue()：将当前包装的对象转换为short类型的数值。
            通过这6个方法数值包装类可以互相转换这6种数值，但是需要注意的是大范围数值转换为小范围的数值，
            如果数值本身很大，可以会导致精度的丢失。
        03. compareTo()方法
            每一个数值包装类都有int compareTo(数值包装类对象)方法，可以进行包装对象的比较。
            方法返回值是int，如果返回值是0，则相等；
            如果返回值小于0，则此对象小于参数对象；
            如果返回值大于0，则此对象大于参数对象。
        04. 字符串转换为基本数据类型
            每一个数值包装类都提供一些静态parseXXX()方法将字符串转换为对应的基本数据类型，以
                Integer为例，方法定义如下：
                    static int parseInt(String s)：将字符串s转换有符号的十进制整数。
                    static int parseInt(String s, int radix)：将字符串s转换有符号的整数，radix是指定基数，基数用来指定进制。
                        注意这种指定基数的方法在浮点数包装类（Double和Float）中没有的。
        05. 基本数据类型转换为字符串
            每一个数值包装类都提供一些静态toString()方法实现将基本数据类型数值转换为字符串，以
                Integer为例，方法定义如下：
                    static String toString(int i)：将该整数i转换为有符号的十进制表示的字符串。
                    static String toString(int i, int radix)：将该整数i转换为有符号的特定进制表示的字符串，radix是基数可以指定进制。
                        注意这种指定基数的方法在浮点数包装类（Double和Float）中没有的。
    */
    public static void main(String[] args) {
        // 1.构造方法
        //创建数值为80的Integer对象
        Integer objInt = new Integer(80);
        //创建数值为80.0的Double对象
        Double objDouble = new Double(80.0);
        //通过"80.0"字符串创建数值为80.0的Float对象
        Float objFloat = new Float("80.0");
        //通过"80"字符串创建数值为80的Long对象
        Long objLong = new Long("80");

        // 2.Number类方法
        //Integer对象转换为long数值
        long longVar = objInt.longValue();
        //Double对象转换为int数值
        int intVar = objDouble.intValue();
        System.out.println("intVar = " + intVar);
        System.out.println("longVar = " + longVar);

        // 3.compareTo()方法
        Float objFloat2 = new Float(100);
        int result = objFloat.compareTo(objFloat2);
        // result = -1，表示objFloat小于objFloat2
        System.out.println(result);

        // 4.字符串转换为基本数据类型
        // 10进制"100"字符串转换为10进制数为100
        int intVar2 = Integer.parseInt("100");
        // 16进制"ABC"字符串转换为10进制数为2748
        int intVar3 = Integer.parseInt("ABC", 16);
        System.out.println("intVar2 = " + intVar2);
        System.out.println("intVar3 = " + intVar3);

        // 5.基本数据类型转换为字符串
        // 100转换为10进制字符串
        String str1 = Integer.toString(100);
        // 100转换为16进制字符串结果是64
        String str2 = Integer.toString(100, 16);
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    }
}
