package com.Advance.Exception.tryCatch;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

// 一个简单 try-catch例子
public class simpleDemo {
    public static void main(String[] args){
        Date date = readDate();
        System.out.println("日期 = " + date);
    }

    // 解析日期
    // 方法后面的throws ParseException说明：当调用方法时有可以能产生ParseException异常。
    public static Date readDate() {
        try {
            String str = "2022-08-18"; //没有异常
            // String str = "201A-18-18"; // 发生异常
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            // 从字符串中解析日期
            // 根据 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");来判断是否能将字符串转换为日期字符串
            Date date = df.parse(str);
            return date;
        } catch (ParseException e) {
            System.out.println("处理ParseException…");
            e.printStackTrace();
        }
        return null;
    }
    /*
    方法后面的throws ParseException说明：当调用parse()方法时有可以能产生ParseException异常。
    提示：静态方法、实例方法和构造方法都可以声明抛出异常，凡是抛出异常的方法都可以通过try-catch进行捕获，
    当然运行时异常可以不捕获。一个方法声明抛出什么样的异常需要查询API文档。
    public Date parse(String source) throws ParseException
    {
        ParsePosition pos = new ParsePosition(0);
        Date result = parse(source, pos);
        if (pos.index == 0)
            throw new ParseException("Unparseable date: \"" + source + "\"" ,
                    pos.errorIndex);
        return result;
    }
    */
}
