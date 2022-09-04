package com.Object.AbstractInterface;

public class newFeatures {
    /*
        在Java 8之前，尽管Java语言中接口已经非常优秀了，但相比其他面向对象的语言而言Java接口存在如下不足之处：
            01. 不能可选实现方法，接口的方法全部是抽象的，实现接口时必须全部实现接口中方法，哪怕是有些方法并不需要，也必须实现。
            02. 没有静态方法。
        针对这些问题，Java 8在接口中提供了声明默认方法和静态方法的能力。
    */
    public static void main(String[] args) {
        //声明接口类型，对象是实现类，发生多态
        InterfaceD abc = new ABC();
        // 访问实现类methodB方法
        System.out.println(abc.methodB());
        // 访问默认方法methodC，是调用类ABC中的实现
        System.out.println(abc.methodC());
        // 访问默认方法methodD，是调用接口 InterfaceA中的实现
        System.out.println(abc.methodD());
        // 访问InterfaceA静态方法 methodE，只能通过接口名（InterfaceA）调用，
        // 不能通过实现类ABC调用，可以这样理解接口中声明的静态方法与其他实现类没有任何关系。
        System.out.println(InterfaceD.methodE());
    }
}

class ABC implements InterfaceD {
    /*
        实现接口时接口中原有的抽象方法在实现类中必须实现。默认方法可以根据需要有选择实现（覆盖）。
        静态方法不需要实现，实现类中不能拥有接口中的静态方法。
    */
    @Override
    public void methodA() {
    }
    @Override
    public String methodB() {
        return "实现methodB方法...";
    }
    @Override
    public int methodC() {
        return 500;
    }
}
