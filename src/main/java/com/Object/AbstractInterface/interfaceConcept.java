package com.Object.AbstractInterface;

// 如果接口与 Java文件不在同一个包下需要导入
import com.Object.AbstractInterface.FigureI;

public class interfaceConcept {
    // 比抽象类更加抽象的是接口，在接口中所有的方法都是抽象的
    /*
        某个类实现接口时，要在声明时使用 implements关键字，
        当实现多个接口之间用逗号（,）分隔。实现接口时要实现接口中声明的所有方法。
    */
    public static void main(String[] args) {
        // f1变量是父类类型，指向子类实例，发生多态
        FigureI f1 = new TriangleI();
        f1.onDraw();
        System.out.println(f1.name);
        System.out.println(FigureI.name);
        // f2变量是父类类型，指向子类实例，发生多态
        FigureI f2 = new EllipseI();
        f2.onDraw();
        /*
            上述代码中实例化两个具体类 Triangle和 Ellipse，对象 f1和 f2是 Figure接口引用类型。
            接口 Figure中声明了成员变量，它是静态成员变量，f1.name和 FigureI.name是访问 name静态变量。
            注意：接口与抽象类一样都不能被实例化。
        */
    }
}

//几何图形椭圆形
class EllipseI implements FigureI {
    //绘制几何图形方法
    @Override
    public void onDraw() {
        System.out.println("绘制椭圆形...");
    }
}

//几何图形三角形
class TriangleI implements FigureI {
    // 绘制几何图形方法
    @Override
    public void onDraw() {
        System.out.println("绘制三角形...");
    }
}
