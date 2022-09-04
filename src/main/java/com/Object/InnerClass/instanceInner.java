package com.Object.InnerClass;

// 成员内部类类似于外部类的成员变量，在外边类的内部，且方法体和代码块之外定义的内部类

// 实例内部类
public class instanceInner {
    public static void main ( String[] args ) {
        // 通过外部类访问内部类
        Outer outer = new Outer();
        System.out.println(outer); // 内部类编译成功后生成的字节码文件是“外部类$内部类.class”。
        outer.test();

        System.out.println("-------直接访问内部类------");
        // 直接访问内部类
        /*
            通常情况下，使用实例成员内部类不是给外部类之外调用使用的，而就是给外部类自己使用的。
            但是一定要在外部类的之外访问内部类，Java语言也是支持的，见内部类的类型表示“外部类.内部类”，

            实例化过程是先实例化外部类，再实例化内部类，outer对象是外部类实例，outer.new Inner()表达式实例化内部类对象。

            另外，instance与内部类Inner在同一个包中，内部类Inner和它的方法display()访问级别都是默认的，
            它们对于在同一包中instance是可见的。
        */
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}

class Outer {
    /*
        实例内部类与实例变量类似，可以声明为公有级别、私有级别、默认级别或保护级别，即4种访问级别都可以，
        而外部类只能声明为公有或默认级别。
    */

    // 外部类成员变量
    private int x = 10;

    // 外部类方法
    private void print() {
        System.out.println("调用外部方法...");
    }

    // 测试调用内部类
    public void test() {
        Inner inner = new Inner();
        inner.display();
    }

    // 内部类
    class Inner {
        // 内部类成员变量
        private int x = 5;

        // 内部类方法
        void display() {

            // 访问外部类的成员变量x
            // 引用外部类对象需要使用“外部类名.this”
            System.out.println("外部类成员变量 x = " + Outer.this.x);

            // 访问内部类的成员变量x
            // 在内部类中this是引用当前内部类对象
            System.out.println("内部类成员变量 x = " + this.x);
            System.out.println("内部类成员变量 x = " + x);

            // 调用外部类的成员方法
            Outer.this.print();
            // 如果内部类和外部类它们的成员命名没有冲突情况下，在引用外部类成员时可以不用加“外部类名.this”
            print();
        }
    }
}