package com.Object.CommonClass.newDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// 日期格式化和解析
public class dateFormat {
    /*
        Java 8提供的日期格式化类是java.time.format.DateTimeFormatter，
        DateTimeFormatter中本身没有提供日期格式化和日期解析方法，
        这些方法还是由LocalDate、LocalTime和LocalDateTime提供的。

        01. 日期格式化
            日期格式化方法是format，这三个类每一个都有String format(DateTimeFormatter formatter)，
            参数formatter是DateTimeFormatter类型。
        02. 日期解析
            日期解析方法是parse，这三个类每一个都有两个版本的parse方法，具体说明如下：
                static LocalDateTime parse(CharSequence text)：使用默认格式，从一个文本字符串获取一个LocalDateTime实例，
                    如2007-12-03T10:15:30。
                static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter)：使用指定格式化，
                    从文本字符串获取LocalDateTime实例。
                static LocalDate parse(CharSequence text)：使用默认格式，从一个文本字符串获取一个LocalDate实例，
                    如2007-12-03。
                static LocalDate parse(CharSequence text, DateTimeFormatter formatter)：使用指定格式化，
                    从文本字符串获取LocalDate实例。
                static LocalTime parse(CharSequence text)：使用默认格式，从一个文本字符串获取一个LocalTime实例。
                static LocalTime parse(CharSequence text,  DateTimeFormatter formatter)：使用指定的格式化，
                    从文本字符串获取LocalTime实例。

        常用的日期和时间格式模式参见 com.Object.CommonClass.oldDateTime.dateFormat
    */

    public static void main(String[] args) {
        // 创建LocalDateTime对象
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("dateTime格式化之前：" + dateTime);

        // 设置格式化类
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = dateTime.format(formatter);
        System.out.println("dateTime格式化之后：" + text);

        // 格式化字符串"2018-08-18 08:58:18"，返回LocalDateTime对象
        LocalDateTime parsedDateTime = LocalDateTime.parse("2018-08-18 08:58:18", formatter);
        System.out.println("LocalDateTime解析之后：" + parsedDateTime);

        // 创建LocalDate对象
        LocalDate date = LocalDate.now();
        System.out.println("date格式化之前：" + date);

        // 重新设置格式化类
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        text = date.format(formatter);
        System.out.println("date格式化之后：" + text);

        // 格式化字符串"2018-08-18"，返回LocalDate对象
        LocalDate parsedDate = LocalDate.parse("2018-08-18", formatter);
        System.out.println("LocalDate解析之后：" + parsedDate);

        // 创建LocalTime对象
        LocalTime time = LocalTime.now();
        System.out.println("time格式化之前：" + time);

        // 重新设置格式化类
        // 格式化类DateTimeFormatter对象是通过ofPattern(String pattern)获得，其中pattern是日期和时间格式模式
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        text = time.format(formatter);
        System.out.println("time格式化之后：" + text);

        // 格式化字符串"08:58:18"，返回LocalTime对象
        LocalTime parsedTime = LocalTime.parse("08:58:18", formatter);
        System.out.println("LocalTime解析之后：" + parsedTime);

        /*
            注意 解析时间日期字符串时候需要注意两方面的问题：
            第一、要解析的字符串格式一定要与格式模式匹配，假设将时间字符串"08:58:18"改为"08 58 18"，
                那么程序运行会抛出异常DateTimeParseException；
            第二、要解析的字符串格式一定是有效的时间或日期，假设将时间字符串"08:58:18"改为"08:58:68"，
                那么程序运行页会抛出异常DateTimeParseException。
        */
    }
}
