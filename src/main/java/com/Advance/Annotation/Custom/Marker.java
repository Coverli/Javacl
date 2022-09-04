package com.Advance.Annotation.Custom;

/**
 * @author 声明注解
 */
public @interface Marker{
    /**
    声明自定义注解可以使用@interface关键字实现
    上述代码声明一个Marker注解，@interface声明一个注解类型，
    它前面的访问限定修饰符与类一样有两种：公有访问权限和默认访问权限。

    注意：关于注解源程序文件与类一样，一个源程序文件中可以声明多个注解，
    但只能有一个是公有访问权限的，源程序文件命名与公有访问权限的注解名一致。
 */
}

/**
 * @author cl
 */
@interface MyAnnotation0 {
    //单值注解
    String value();
    /**
        Marker注解中不包含任何的成员，这种注解称为标记注解（Marked Annotation），
        基本注解中的@Override就属于标记注解。根据需要注解中可以包含一些成员，示例代码如上

        代码中声明MyAnnotation注解，它有一个成员value，注意value后面是有一对小括号，
        value前面的是数据类型。成员也可以有访问权限修饰符，但是只能是公有权限和默认权限。
     */
}

/**
 * @author cl
 * 注解中的成员也可以有默认值
 * 通过关键字default指定默认值
 */
@interface MyAnnotation1 {
    //带有默认值注解
    String value() default "注解信息";
    int count() default 0;
}
