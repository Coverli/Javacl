package com.Object.InnerClass;

// 局部内部类
public class localityInner {
    /*
        局部内部类就是在方法体或代码块中定义的内部类，局部内部类的作用域仅限于方法体或代码块中。
        局部内部类访问级别只能是默认的，不能是公有的、私有的和保护的访问级别，
        即不能使用public、private和protected修饰。
        局部内部类也不能是静态，即不能使用static修饰。
        局部内部类可以访问外部类所有成员。
    */
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        outer.add(100, 300);
    }
}

class Outer1 {
    // 外部类成员变量
    private int value = 10;

    // 外部类方法
    public void add(final int x, int y) {

        //局部变量
        int z = 100;

        // 定义内部类
        class Inner {
            // 内部类方法
            void display() {
                int sum = x + z + value;
                System.out.println("sum = " + sum);
            }
        }

        // Inner inner = new Inner();
        // inner.display();
        //声明匿名对象
        new Inner().display();
        /*
            new Inner().display()是实例化Inner对象后马上调用它的方法，
            没有为Inner对象分配一个引用变量名，这种写法称为“匿名对象”。
            匿名对象适合只运行一次情况下。匿名对象写法使代码变得简洁，
        */
    }
}
