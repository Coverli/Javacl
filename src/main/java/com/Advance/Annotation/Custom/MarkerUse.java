package com.Advance.Annotation.Custom;

/**
 * 声明注解
 * 默认情况下注解可以修饰任意的程序元素（类、接口、成员变量、成员方法和数据类型等）
 * */
@Marker
public class MarkerUse {
    /**
     * @MyAnnotation0(value = "Annotation")注解修饰成员变量，
     * 其中value = "Annotation"是为value成员提供数值
     * */
    @MyAnnotation0(value = "Annotation")
    private String info = "";

    /**
     * @MyAnnotation1(count = 10) 注解修饰成员方法，@MyAnnotation1有两个成员，
     * 但是只为count成员赋值，另外一个成员value使用默认值
     * */
    @MyAnnotation1(count = 10)
    public static void main(String[] args) {}

    /**
     * @MyAnnotation1(value = "132",count = 10) 注解修饰成员方法，
     * 为count赋值为10，为value赋值为132
     * */
    @MyAnnotation1(value = "132",count = 10)
    void ab () {

    }
}
