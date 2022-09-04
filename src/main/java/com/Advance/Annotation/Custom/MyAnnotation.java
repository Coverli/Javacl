package com.Advance.Annotation.Custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;

/**
 * @author cl
 * 注解MyAnnotation，它用来修饰类或接口，
 */
@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String description();
}
/**
    上述代码声明注解类型MyAnnotation，其中使用了三个元注解修饰MyAnnotation注解，
    使用@Documented指定MyAnnotation注解信息可以被javadoc工具读取。
    使用@Target({ ElementType.TYPE })指定MyAnnotation注解用于修饰类和接口等类型。
    @Retention(RetentionPolicy.RUNTIME)指定MyAnnotation注解信息可以在运行时被读取。
    description是MyAnnotation注解的成员。
 */