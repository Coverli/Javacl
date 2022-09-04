package com.Object.Extend;

public class HiddenVariables {
    /*
        子类继承父类后，在子类中有可能声明了与父类一样的成员变量或方法
        子类成员变量与父类一样，会屏蔽父类中的成员变量，称为“成员变量隐藏”
    */
    public static void main(String[] args) {
        //实例化子类SonHV
        SonHV s = new SonHV();
        //调用子类 print方法
        s.print();
    }

}

class FatherHV {
    // 父类成员变量 x
    int x = 10;
}

class SonHV extends FatherHV {
    // 屏蔽父类x成员变量
    int x = 20;

    public void print() {
        // 访问子类对象 x成员变量
        System.out.println("子类成员变量 x = " + x);
        // 访问父类 x成员变量
        System.out.println("父类成员变量 super.x = " + super.x);
    }

}