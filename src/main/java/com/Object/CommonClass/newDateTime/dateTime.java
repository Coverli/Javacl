package com.Object.CommonClass.newDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// 时间和日期
public class dateTime {
    /*
        Java 8之后提供了新的日期时间类有三个：
        LocalDate、LocalTime和LocalDateTime，它们都位于java.time包中，
        LocalDate表示一个不可变的日期对象；
        LocalTime表示一个不可变的时间对象；
        LocalDateTime表示一个不可变的日期和时间。

        这三个类有类似的方法，首先先看看创建日期时间对象相关方法，这三个类并没有提供公有的构造方法，
        创建它们对象可以使用静态工厂方法，主要有now()和of()方法。
        now()方法说明如下：
            static LocalDate now()：LocalDate静态工厂方法，该方法使用默认时区获得当前日期，返回LocalDate对象。
            static LocalTime now()：LocalTime静态工厂方法，该方法使用默认时区获得当前时间，返回LocalTime对象。
            static LocalDateTime now()：LocalDateTime静态工厂方法，该方法使用默认时区获得当前日期时间，
                返回LocalDateTime对象。

        of()方法有很多重载方法，说明如下：
            static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second)：
                按照指定的年、月、日、小时、分钟和秒获得LocalDateTime实例，将纳秒设置为零。
            static LocalTime of(int hour, int minute, int second)：按照指定的小时、分钟和秒获取一个LocalTime实例。
            static LocalDate of(int year, int month, int dayOfMonth)：按照指定的年、月和日获得一个LocalDate实例，
                日期中年、月和日必须有效，否则将抛出异常。

        上述方法中的参数取值范围如下所示。
            参数              说   明
            year            从-999,999,999到 999,999,999的年份
            month           一年中的月份，从1到 12
            dayOfMonth      月中的天，从1到 31
            hour            从0到 23表示的小时
            minute          从0到 59表示的分钟
            second          从0到 59表示的秒
    */

    public static void main(String[] args) {
        // 使用now方法获得LocalDate对象
        LocalDate date1 = LocalDate.now();
        System.out.println("date1 = " + date1);

        // 使用of方法获得LocalDate对象2018-08-18
        LocalDate date2 = LocalDate.of(2018, 8, 18);
        System.out.println("date2 = " + date2);

        // 使用now方法获得LocalTime对象
        LocalTime time1 = LocalTime.now();
        System.out.println("time1 = " + time1);

        // 使用of方法获得LocalTime对象08:58:18
        LocalTime time2 = LocalTime.of(8, 58, 18);
        System.out.println("time2 = " + time2);

        // 使用now方法获得LocalDateTime对象
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println("dateTime1 = " + dateTime1);

        // 使用of方法获得LocalDateTime对象2018-08-18T08:58:18
        LocalDateTime dateTime2 = LocalDateTime.of(2018, 8, 18, 8, 58, 18);
        System.out.println("dateTime2 = " + dateTime2);
    }
}
