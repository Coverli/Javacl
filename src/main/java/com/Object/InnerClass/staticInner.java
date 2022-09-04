package com.Object.InnerClass;

// 静态内部类
public class staticInner {
    /*
        静态内部类与静态变量类似，在声明的时候使用关键字static修饰，
        静态内部类只能访问外部类静态成员，
        所以静态内部类使用的场景不多。但可以提供有别于包的命名空间。
    */
    public static void main(String[] args) {
        /*
            在声明静态内部时采用“内部类.静态内部类”形式，实例化也是如此形式

            提示：
                如果不看代码或文档，View.Button形式看起来像是View包中的Button类，
                事实上它是View类中静态内部类Button。
                View.Button形式客观上能够提供有别于包的命名空间，View相关的类集中管理起来，
                View.Button可以防止命名冲突。
        */
        // 直接访问内部类
        View.Button button = new View.Button();
        button.onClick();
    }

}

class View {
    // 外部类实例变量
    private int x = 20;
    // 外部类静态变量
    private static int staticX = 10;

    // 静态内部类
    static class Button {
        // 内部类方法
        void onClick() {

            //访问外部类的静态成员
            System.out.println(staticX);

            //不能访问外部类的非静态成员
            // System.out.println(x); //编译错误 ⑥
        }
    }
}
