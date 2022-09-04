package com.Object.Polymorphism;

public class Concept {
    /*
        发生多态要有三个前提条件：
        01. 继承。多态发生一定要子类和父类之间
        02. 覆盖。子类覆盖了父类的方法
        03. 声明的变量类型是父类类型，但实例则指向子类实例
    */
    public static void main(String[] args) {
        // f1变量是父类类型，指向父类实例
        Figure f1 = new Figure();
        f1.onDraw();

        //f2变量是父类类型，指向子类实例，发生多态
        Figure f2 = new Triangle();
        f2.onDraw();

        //f3变量是父类类型，指向子类实例，发生多态
        Figure f3 = new Ellipse();
        f3.onDraw();

        //f4变量是子类类型，指向子类实例
        Triangle f4 = new Triangle();
        f4.onDraw();
    }

}

class Figure {
    //绘制几何图形方法
    public void onDraw() {
        System.out.println("绘制Figure...");
    }
}

//几何图形椭圆形
class Ellipse extends Figure {
    //绘制几何图形方法
    @Override
    public void onDraw() {
        System.out.println("绘制椭圆形...");
    }
}

//几何图形三角形
class Triangle extends Figure {
    // 绘制几何图形方法
    @Override
    public void onDraw() {
        System.out.println("绘制三角形...");
    }
}
