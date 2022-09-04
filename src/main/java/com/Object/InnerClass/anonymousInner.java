package com.Object.InnerClass;

//import com.Object.Class.demo03.DemoPerson;

// 匿名内部类
public class anonymousInner {
    /*
        匿名内部类是没有名字的内部类，本质上是没有名的局部内部类，具有局部内部类所有特征。
        例如：可以访问外部类所有成员。如果匿名内部类在方法中定义，它所访问的参数需要声明为final的。
    */
    public static void main(String[] args) {
        View1 v = new View1();
        // 方法参数是匿名内部类
        v.handler(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("实现接口的匿名内部类...");
            }
        });

        // 继承类的匿名内部类
        // 在赋值时使用匿名内部类
        Figure f = new Figure() {
            @Override
            public void onDraw() {
                System.out.println("继承类的匿名内部类...");
            }
        };
        f.onDraw();

        //具体类作为内部类
        // 匿名内部类通常用来实现接口或抽象类的，很少覆盖具体类。
        Person person = new Person("Tony", 18) {
            @Override
            public String toString() {
                return "匿名内部类.实现 "
                        + " Person[name=" + name
                        + ", age=" + age + "]";
            }
        };

        //打印过程自动调用person的 toString()方法
        System.out.println(person);
    }
}

class View1 {
    public void handler(OnClickListener listener) {
        listener.onClick();
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

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name
                + ", age=" + age + "]";
    }
}