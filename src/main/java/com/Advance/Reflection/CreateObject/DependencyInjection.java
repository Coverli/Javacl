package com.Advance.Reflection.CreateObject;


import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 案例：依赖注入实现
 * */
public class DependencyInjection {
    /**
        Java反射机制能够在运行时动态加载类，而不是在编译期。
        在一些框架开发中经常将要实例化的类名保存到配置文件中，在运行时从配置文件中读取类名字符串，
        然后动态创建对象，建立依赖关系 。采用new创建对象依赖关系是在编译期建立的，
        反射机制能够将依赖关系推迟到运行时建立，这种依赖关系动态注入进来称为依赖注入

        注：依赖关系是一种非常普遍的关系，如果在A中使用了B，B变化会引起A的变化，A依赖于B。

        例如：如下图所示有三个类，Student和Worker继承自Person，在DependencyInjection类的main()方法中会创建Person子类实例，
        至于依赖哪一个类，Student还是Worker，可以在运行时从配置文件中读取，然后创建对象。

                                <<Java Class>>
                                    Person
                        com.Advance.Reflection.CreateObject
                                 name；String
                                   age：int
                              Person(String,int)
                              toString():String
                              getName():String
                              setName(String):void
                                getAge():int
                              setAge(int):void
                                  ^     ^
                    --------------|     |------------------
                    |                                     |
              <<Java Class>>                        <<Java Class>>
                 Student                                Worker
     com.Advance.Reflection.CreateObject     com.Advance.Reflection.CreateObject
              school:String                          factory:String
          Student(String,int,String)              Worker(String,int,String)
             toString():String                      toString():String
             getSchool():String                    getFactory():String
            setSchool(String):void                setFactory(String):void
     */

    public static void main(String[] args) {
        try {
            // 通过调用readClassName()方法从Configuration.ini文件中读取类名，
            // 读取Configuration.ini文件内容，采用Java I/O技术
            String className = readClassName();

            // 从配置文件Configuration.ini中读取的字符串创建Class对象
            Class clz = Class.forName(className);
            // 指定参数类型
            Class[] params = new Class[3];
            // 第一个参数是String
            params[0] = String.class;
            // 第二个参数是int
            params[1] = int.class;
            // 第三个参数是String
            params[2] = String.class;

            // 获取对应参数的构造方法
            Constructor constructor = clz.getConstructor(params);
            // 设置传递参数
            Object[] argObjs = new Object[3];
            // 第一个参数传递"Tony"
            argObjs[0] = "Tony";
            // 第二个参数传递18
            argObjs[1] = 18;
            // 第三个参数传递"清华大学"
            argObjs[2] = "清华大学";

            // 调用非默认构造方法
            // 调用三个参数构造方法创建对象，这个对象是哪个类的实例，与你的Configuration.ini文件中配置字符串有关
            Object p = constructor.newInstance(argObjs);
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 从Configuration.ini文件中读取类名
    public static String readClassName() {
        FileInputStream readfile = null;
        InputStreamReader ir = null;
        BufferedReader in = null;
        try {
            readfile = new FileInputStream(".\\src\\main\\java\\com\\Advance\\Reflection\\CreateObject\\Configuration.ini");
            ir = new InputStreamReader(readfile);
            in = new BufferedReader(ir);
            // 读取文件中的一行数据
            String str = in.readLine();
            return str;
        } catch (FileNotFoundException e) {
            System.out.println("处理FileNotFoundException...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        }
        return null;
    }
}
