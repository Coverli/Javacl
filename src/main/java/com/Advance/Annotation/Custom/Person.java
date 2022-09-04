package com.Advance.Annotation.Custom;

/**
 * 使用了MyAnnotation和MemberAnnotation注解的Person类
 * 使用注解时如果当前类与注解不在同一个包中，则需要将注解引入
 * */
/** @MyAnnotation注解只能Person之前，修饰Person类 */
@MyAnnotation(description = "这是一个测试类")
public class Person {

    /** 使用@MemberAnnotation注解修饰成员变量 */
    @MemberAnnotation(type = String.class, description = "名字")
    private String name;

    @MemberAnnotation(type = int.class, description = "年龄")
    private int age;

    /** 使用@MemberAnnotation注解修饰成员方法 */
    @MemberAnnotation(type = String.class, description = "获得名字")
    public String getName() {
        return name;
    }

    @MemberAnnotation(type = int.class, description = "获得年龄")
    public int getAge() {
        return age;
    }

    @MemberAnnotation(description = "设置姓名和年龄")
    public void setNameAndAge(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}