package com.Advance.Exception.ReleaseResource;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 自动资源管理
public class autoManagement {
    /*
        节使用finally代码块释放资源会导致程序代码大量增加，一个finally代码块往往比正常执行的程序还要多。
        在Java 7之后提供自动资源管理（Automatic Resource Management）技术，
        可以替代 finally代码块，优化代码结构，提高程序可读性。
        自动资源管理是在try语句上的扩展，语法如下：
        try (声明或初始化资源语句) {
            //可能会生成异常语句
        } catch(Throwable e1){
            //处理异常e1
        } catch(Throwable e2){
            //处理异常e1
        } catch(Throwable eN){
            //处理异常eN
        }
        // 在try语句后面添加一对小括号“()”，其中是声明或初始化资源语句，可以有多条语句语句之间用分号“;”分隔。
    */
    public static void main(String[] args) {
        Date date = readDate();
        System.out.println("读取的日期 = " + date);
    }
    public static Date readDate() {
        // 自动资源管理
        /*
            声明或初始化三个输入流，三条语句放到在try语句后面小括号中，语句之间用分号“;”分隔，
            这就是自动资源管理技术了，采用了自动资源管理后不再需要finally代码块，
            不需要自己close这些资源，释放过程交给了JVM。

            所有可以自动管理的资源需要实现AutoCloseable接口
            具体哪些资源实现AutoCloseable接口需要查询API文档
        */
        try (FileInputStream readfile = new FileInputStream("readme.txt");
             InputStreamReader ir = new InputStreamReader(readfile);
             BufferedReader in = new BufferedReader(ir)) {
            // 读取文件中的一行数据
            String str = in.readLine();
            if (str == null) {
                return null;
            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(str);
            return date;
        } catch (FileNotFoundException e) {
            System.out.println("处理FileNotFoundException...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("处理ParseException...");
            e.printStackTrace();
        }
        return null;
    }
}
