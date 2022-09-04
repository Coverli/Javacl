package com.Advance.Annotation.Custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cl
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface MemberAnnotation {
    Class<?> type() default void.class;
    String description();
}

/**
    上述代码声明注解类型MemberAnnotation，其中也使用了三个元注解修饰MemberAnnotation注解，
    @Documented指定MyAnnotation注解信息可以被javadoc工具读取。
    @Retention(RetentionPolicy.RUNTIME)指定MemberAnnotation注解信息可以在运行时被读取。
    @Target({ ElementType.FIELD, ElementType.METHOD })指定MemberAnnotation注解用于修饰类中成员。

    声明两个成员，type类型是Class<?>，默认值是void.class，void.class是void类型表示方式。
    description类型是String，没有设置默认值。

    提示：代码中Class<?>类型，表示Class的泛型，?是泛型通配符，可以是任何类型。
    泛型多数情况下尖括号中指定的都某个具体类型，泛型也是为此而设计的。
    但是有时确实不需要知道具体类型，或者说什么类型都可以，此时可以使用?作为占位符。
 */