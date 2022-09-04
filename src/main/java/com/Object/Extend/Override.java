package com.Object.Extend;

public class Override {
    /*
        如果子类方法完全与父类方法相同，即：相同的方法名、相同的参数列表和相同的返回值，
        只是方法体不同，这称为子类覆盖（Override）父类方法。

        注意 方法覆盖时应遵循的原则：
            01. 覆盖后的方法不能比原方法有更严格的访问控制（可以相同）。
                例如将代码访问控制public修改private，那么会发生编译错误，因为父类原方法是protected。
            02. 覆盖后的方法不能比原方法产生更多的异常。
    */
    public static void main(String[] args) {
        //实例化子类
        SonOR s = new SonOR();
        // 调用square方法
        s.square();
        //调用子类 print方法
        s.print();
    }
}

class FatherOR {
    // 父类成员变量 x
    int x = 10;

    protected void square() {
        System.out.println( "x的平方" + x * x );
    }
}

class SonOR extends FatherOR {
    // 屏蔽父类x成员变量
    int x = 20;

    // 覆盖父类方法
    @java.lang.Override
    /*
        在声明方法时添加@Override注解，@Override注解不是方法覆盖必须的，它只是锦上添花，
        但添加 @Override注解有两个好处：
            01. 提高程序的可读性。
            02. 编译器检查@Override注解的方法在父类中是否存在，如果不存在则报错。
    */
    public void square() {
        // 调用父类square()方法
        super.square();
    }


    public void print() {
        // 访问子类对象 x成员变量
        System.out.println("子类成员变量 x = " + x);
        // 访问父类 x成员变量
        System.out.println("父类成员变量 super.x = " + super.x);
    }

}