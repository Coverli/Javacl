package com.Advance.Exception;

public class Extend {
        /*
            异常封装成类 Exception，此外还有 Throwable类和 Error类，异常类继承层次如下所示
                                   |----VirtualMechineError
                             错误   |----LinkageError          |----IndexOutBoundsException
                        ----Error--|----AWTError              |----DateTimeParseException
                        |          |----......                |----NullPointException
                        |                                     |----ClassCastException
            Throwable----                       (运行时异常)    |----ArithmeticException
                        |              |----RuntimeException--|----......
                        |      异常     |       (受检查异常)
                        ----Exception--|----IOException--|----FileNotFoundException
                                       |                 |----EOFException
                                       |                 |----......
                                       |
                                       |----ParseException
                                       |----......
            从上面可知所有的异常类都直接或间接地继承于 java.lang.Throwable类，在Throwable类中有几个非常重要的方法：
                String getMessage()：获得发生异常的详细消息
                void printStackTrace()：打印异常堆栈跟踪信息
                String toString()：获得异常对象的描述
            提示：堆栈跟踪的是方法调用过程的轨迹，它包含了程序执行过程中方法调用的顺序和所在源代码行号
                堆栈跟踪信息从下往上是方法调用的顺序
        */
    public static void main (String[] args) {
        Extend extend = new Extend();
        extend.throwableDemo();
    }

    void throwableDemo () {
        int a = 0;
        try {
            System.out.println(5/a);
        } catch ( Throwable throwable ){
            System.out.println(throwable.getMessage());
            System.out.println(throwable.toString());
            throwable.printStackTrace();
        }
    }

    /*
        Throwable有两个直接子类：Error和Exception。
        01. Error
            Error是程序无法恢复的严重错误，程序员根本无能为力，只能让程序终止。
            例如：JVM内部错误、内存溢出和资源耗尽等严重情况。
        02. Exception
            Exception是程序可以恢复的异常，它是程序员所能掌控的。
            例如：除零异常、空指针访问、网络连接中断和读取不存在的文件等。

        Exception类可以分为：受检查异常和运行时异常。
        01. 受检查异常
            受检查异常是除 RuntimeException以外的异常类。
            它们的共同特点是：编译器会检查这类异常是否进行了处理，
            即要么捕获（try-catch语句），要么不抛出（通过在方法后声明throws），否则会发生编译错误。
            它们种类很多，例如日期解析异常 ParseException。
        02. 运行时异常
            运行时异常是继承RuntimeException类的直接或间接子类。
            运行时异常往往是程序员所犯错误导致的，健壮的程序不应该发生运行时异常。
            它们的共同特点是：编译器不检查这类异常是否进行了处理，也就是对于这类异常不捕获也不抛出，程序也可以编译通过。
            由于没有进行异常处理，一旦运行时异常发生就会导致程序的终止，这是用户不希望看到的。
            如上面的 throwableDemo方法的除零示例的ArithmeticException异常属于RuntimeException异常，
            可以不用加try-catch语句捕获异常。

        提示：对于运行时异常通常不采用抛出或捕获处理方式，而是应该提前预判，防止这种发生异常，做到未雨绸缪。
        例如上面的 throwableDemo方法的除零示例，在进行除法运算之前应该判断除数是非零的，修改示例代码如下，
        从代码可见提前预判这样处理要比通过try-catch捕获异常要友好的多。
        if ( a != 0 ) {
            System.out.println(5/a);
        } return 0;
    */

}
