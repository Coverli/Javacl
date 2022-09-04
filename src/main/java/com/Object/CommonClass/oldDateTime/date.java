package com.Object.CommonClass.oldDateTime;

/*
    Java 8之前日期类是java.util.Date,
    Java 8之前与日期时间相关类还有DateFormat、Calendar和TimeZone，
        DateFormat用于日期格式化，
        Calendar日历类
        TimeZone是时区类。

    提示：在Java SE核心类中有两个Date，分别是java.util.Date和java.sql.Date。
        java.util.Date就是日期时间类，
        java.sql.Date是JDBC中日期字段类型。
*/

import java.util.Date;

// Date类
public class date {
    /*
        Date类构造方法：
            Date()：用当前时间创建Date对象，精确到毫秒。
            Date(long date)：指定标准基准时间以来的毫秒数创建Date对象。标准基准时间是格林威治时间1970年1月1日00:00:00。
        Date类的普通方法：
            boolean after(Date when)：测试此日期是否在when日期之后。
            boolean before(Date when)：测试此日期是否在when日期之前。
            int compareTo(Date anotherDate)：比较两个日期的顺序。如果参数日期等于此日期，则返回值0；
                如果此日期在参数日期之前，则返回小于0的值；如果此日期在参数日期之后，则返回大于0的值。
            long getTime()：返回自1970年1月1日00:00:00以来此Date对象表示的毫秒数。
            void setTime(long time)：用毫秒数time设置日期对象，time是自1970年1月1日00:00:00以来此Date对象表示的毫秒数
    */

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("now = " + now);
        System.out.println("now.getTime() = " + now.getTime());
        System.out.println();
        Date date = new Date(1234567890123L);
        System.out.println("date = " + date);
        // 测试now和date日期
        display(now, date);
        // 重新设置日期time
        date.setTime(9999999999999L);
        System.out.println("修改之后的date = " + date);
        // 重新测试now和date日期
        display(now, date);
    }

    // 测试after、before和compareTo方法
    public static void display(Date now, Date date) {
        System.out.println();
        System.out.println("now.after(date) = " + now.after(date));
        System.out.println("now.before(date) = " + now.before(date));
        System.out.println("now.compareTo(date) = " + now.compareTo(date));
        System.out.println();
    }
}
