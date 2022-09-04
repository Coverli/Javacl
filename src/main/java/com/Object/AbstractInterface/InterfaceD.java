package com.Object.AbstractInterface;

public interface InterfaceD {
    void methodA();

    String methodB();

    // 默认方法,类似于类中具体方法
    default int methodC() {
        return 0;
    }

    // 默认方法
    default String methodD() {
        return "这是默认方法...";
    }

    // 静态方法
    static double methodE() {
        return 0.0;
    }
}
