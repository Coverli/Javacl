package com.Object.AbstractInterface;

public class mutilExtends extends Object implements InterfaceA, InterfaceB {
    /*
        在Java中只允许继承一个类，但可实现多个接口。通过实现多个接口方式满足多继承的设计需求。
        如果多个接口中即便有相同方法，它们也都是抽象的，子类实现它们不会有冲突。
     */
    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }

    @Override
    public void methodC() {

    }
}

