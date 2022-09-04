package com.Advance.Annotation;

/**
 * 元注解
 * */
public class Meta {
    /**
        元注解包括：@Documented、@Target、@Retention、@Inherited、@Repeatable和@Native。
        元注解是为其他注解进行说明的注解，当自定义一个新的注解类型时，其中可以使用元注解。

        @Documented
            如果在一个自定义注解中引用@Documented注解，那么该注解可以修饰代码元素（类、接口、成员变量和成员方法等），
            javadoc等工具可以提取这些注解信息。

        @Target
            @Target注解用来指定一个新注解的适用目标。@Target注解有一个成员（value）用来设置适用目标，
            value是java.lang.annotation.ElementType枚举类型的数组，
            ElementType描述Java程序元素类型，它有10个枚举常量，如下表所示
                    ElementType枚举类型中的枚举常量
              枚举常量                   说明
            ANNOTATION_TYPE         其他注解类声明
            CONSTRUCTOR             构造方法声明
            FIELD                   成员变量或常量声明
            LOCAL_VARIABLE          局部变量声明
            METHOD                  方法声明
            PACKAGE                 包声明
            PARAMETER               参数声明
            TYPE                    类、接口声明
            TYPE_PARAMETER          用于泛型中类型参数声明
            TYPE_USE                用于任何类型的声明

        @Retention
            @Retention注解用来指定一个新注解的有效范围，@Retention注解有一个成员（value）用来设置保留策略，
            value是java.lang.annotation.RetentionPolicy枚举类型，
            RetentionPolicy描述注解保留策略，它有3个枚举常量，如下表所示。
                    RetentionPolicy枚举类型中的枚举常量
              枚举常量                   说明
            SOURCE                  只适用于Java源代码文件中，此范围最小
            CLASS                   编译器把注解信息记录在字节码文件中，此范围居中
            RUNTIME                 编译器把注解信息记录在字节码文件中，并在运行时可以读取这些信息，此范围最大

        @Inherited
            @Inherited注解用来指定一个新注解可以被继承。
            假定一个类A被该新注解修饰，那么这个A类的子类会继承该新注解。

        @Repeatable
            @Repeatable注解是Java8新增加的，
            它允许在相同的程序元素中重复注释，可重复的注释必须使用@Repeatable进行注释。

        @Native
            @Native注解一个成员变量，指示这个变量可以被本地代码引用。常常被代码生成工具使用。
     */
}
