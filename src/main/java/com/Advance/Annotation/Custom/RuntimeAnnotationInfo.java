package com.Advance.Annotation.Custom;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 案例：读取运行时注解信息
 * */
public class RuntimeAnnotationInfo {
    /**
        注解是为工具读取信息而准备的。有些工具可以读取源代码文件中的注解信息；
        有的可以读取字节码文件中的注解信息；有的可以在运行时读取注解信息。但是读取这些注解信息的代码都是一样的，
        区别只在于自定义注解中@Retention的保留策略不同。

        读取注解信息需要反射相关API，Class类如下方法：
            <A extends Annotation> A getAnnotation(Class<A> annotationClass)：如果此元素存在
            annotationClass类型的注解，则返回注解，否则返回null。
            Annotation[] getAnnotations()：返回此元素上存在的所有注解。
            Annotation[] getDeclaredAnnotations():返回直接存在于此元素上的所有注解。
                与getAnnotations()区别在于该方法将不返回继承的注释。
            boolean isAnnotationPresent(Class<? extends Annotation> annotationClass)：如果此元素上存在
            annotationClass类型的注解，则返回true，否则返回false。
            boolean isAnnotation()：如果此Class对象表示一个注解类型则返回true。
     */

    public static void main(String[] args) {
        try {
            // 创建Person类对应的Class对象，
            Class<?> clz = Class.forName("com.Advance.Annotation.Custom.Person");

            // 读取类注解，判断Person类是否存在MyAnnotation注解
            if (clz.isAnnotationPresent(MyAnnotation.class)) {

                // 通过getAnnotation方法将MyAnnotation注解实例返回
                MyAnnotation ann = (MyAnnotation) clz.getAnnotation(MyAnnotation.class);
                System.out.printf("类%s，读取注解描述： %s \n",

                // ann.description()表达式读取MyAnnotation注解中description成员内容。
                clz.getName(), ann.description());
            }

            // 读取成员方法的注解信息，获得所有成员方法对象数组，通过遍历方法对象数组
            Method[] methods = clz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MemberAnnotation.class)) {
                    MemberAnnotation ann = method.getAnnotation(MemberAnnotation.class);
                    System.out.printf("方法%s，读取注解描述： %s \n",
                    method.getName(), ann.description());
                }
            }

            // 读取成员变量的注解信息
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MemberAnnotation.class)) {
                    MemberAnnotation ann = field.getAnnotation(MemberAnnotation.class);
                    System.out.printf("成员变量%s，读取注解描述： %s \n",
                    field.getName(), ann.description());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
