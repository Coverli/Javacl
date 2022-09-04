package com.Object.CommonClass.WrapperClass;

// Boolean类
public class booleanClass {
    /*
        Boolean类是boolean类型的包装类。
            01. 构造方法
                Boolean类有两个构造方法，构造方法定义如下：
                Boolean(boolean value)：通过一个boolean值创建Boolean对象。
                Boolean(String s)：通过字符串创建Boolean对象。s不能为null，
                    s如果是忽略大小写"true"则转换为true对象，其他字符串都转换为false对象。
            02. compareTo()方法
                Boolean类有int compareTo(Boolean包装类对象)方法，可以进行包装对象的比较。方法返回值是int，
                    如果返回值是0，则相等；如果返回值小于0，则此对象小于参数对象；如果返回值大于0，则此对象大于参数对象。
            03. 字符串转换为boolean类型
                Boolean包装类都提供静态parseBoolean()方法实现将字符串转换为对应的boolean类型，方法定义如下：
                    static boolean parseBoolean(String s)：将字符串转换为对应的boolean类。s不能为null，
                        s如果是忽略大小写"true"则转换为true，其他字符串都转换为false。
    */
    public static void main(String[] args) {
        // 创建数值为 true的Character对象true
        Boolean obj1 = new Boolean(true);
        // 通过字符串"true"创建Character对象true
        Boolean obj2 = new Boolean("true");
        // 通过字符串"True"创建Character对象true
        Boolean obj3 = new Boolean("True");
        // 通过字符串"TRUE"创建Character对象true
        Boolean obj4 = new Boolean("TRUE");
        // 通过字符串"false"创建Character对象false
        Boolean obj5 = new Boolean("false");
        // 通过字 符串"Yes"创建Character对象false
        Boolean obj6 = new Boolean("Yes");
        // 通过字符串"abc"创建Character对象false
        Boolean obj7 = new Boolean("abc");

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
        System.out.println(obj4);
        System.out.println(obj5);
        System.out.println(obj6);
        System.out.println(obj7);
        System.out.println("===============");

        int result1 = obj1.compareTo(obj2);
        if ( result1 != 0 ) {
            System.out.println("obj1和obj2不相等");
        } else {
            System.out.println("obj1和obj2相等");
        }
        int result2 = obj1.compareTo(obj7);
        if ( result2 != 0 ) {
            System.out.println("obj1和obj7不相等");
        } else {
            System.out.println("obj1和obj7相等");
        }
        System.out.println("===============");

        boolean b1 = Boolean.parseBoolean("true");
        boolean b2 = Boolean.parseBoolean("True");
        boolean b3 = Boolean.parseBoolean("TRUE");
        boolean b4 = Boolean.parseBoolean("false");
        boolean b5 = Boolean.parseBoolean("Yes");
        boolean b6 = Boolean.parseBoolean("abc");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
    }
}
