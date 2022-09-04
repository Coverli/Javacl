package com.Object.AbstractInterface;

public class abstractConcept {
    public static void main(String[] args) {
        // 注意：抽象类不能被实例化,只有具体类才能被实例化。
        // f1变量是父类类型，指向子类实例，发生多态
        FigureA f1 = new TriangleA();
        f1.onDraw();
        // f2变量是父类类型，指向子类实例，发生多态
        FigureA f2 = new EllipseA();
        f2.onDraw();
    }
}

abstract class FigureA {
    // 绘制几何图形方法
    /*
        注意抽象方法中只有方法的声明，没有方法的实现，即没有大括号（{}）部分
        注意:
            如果一个方法被声明为抽象的，那么这个类也必须声明为抽象的。
            而一个抽象类中，可以有0~n个抽象方法，以及0~n具体方法。
        设计抽象方法目的就是让子类来实现的，否则抽象方法就没有任何意义
     */
    public abstract void onDraw();
}

//几何图形椭圆形
class EllipseA extends FigureA {
    //绘制几何图形方法
    @Override
    public void onDraw() {
        System.out.println("绘制椭圆形...");
    }
}

//几何图形三角形
class TriangleA extends FigureA {
    // 绘制几何图形方法
    @Override
    public void onDraw() {
        System.out.println("绘制三角形...");
    }
}