package com.Object.CommonClass.WrapperClass;

// 自动装箱/拆箱
public class auto {
    /*
        Java 5之后提供了拆箱(unboxing )功能，拆箱能够将包装类对象自动转换为基本数据类型的数值，
        而不需要使用intValue()或doubleValue()等方法。
        Java 5还提供了相反功能，自动装箱( autoboxing )，
        装箱能够自动地将基本数据类型的数值自动转换为包装类对象，而不需要使用构造方法。
    */
    public static void main(String[] args) {
        // Integer objInt = new Integer(80);
        Integer objInt = 80;
        // Double objDouble = new Double(80.0);
        Double objDouble = 80.00;
        //自动拆箱
        double sum = objInt + objDouble;
        //自动装箱
        //自动装箱'C'转换为Character对象
        Character objChar = 'C';
        //自动装箱true转换为Boolean对象
        Boolean objBoolean = true;
        //自动装箱80.0f转换为Float对象
        Float objFloat = 80.0f;
        //自动装箱100转换为Integer对象
        display(100);
        //避免出现下面的情况
        Integer obj = null;
        // int intVar = obj;
        // 以上注释代码运行时异常 NullPointerException这是因为拆箱的过程本质上是调用intValue()方法实现的，
        // 试图访问空对象的方法和成员变量，就会抛出运行期 NullPointerException异常
    }

    /**
     * @param objInt Integer对象
     * @return int数值
     */
    public static int display(Integer objInt) {
        System.out.println(objInt);
        //return objInt.intValue();
        //自动拆箱Integer对象转换为int
        return objInt;
    }
}
