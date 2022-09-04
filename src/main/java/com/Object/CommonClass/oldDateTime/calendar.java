package com.Object.CommonClass.oldDateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Calendar类
public class calendar {
    /*
        有时为了取得更多的日期时间信息，或对日期时间进行操作，可以使用java.util.Calendar类，
        Calendar是一个抽象类，不能实例化，但是通过静态工厂方法getInstance()获得Calendar实例。
        Calendar类的主要方法：
            static Calendar getInstance()：使用默认时区和语言环境获得一个日历。
            void set(int field, int value)：将给定的日历字段设置为给定值。
            void set(int year,int month,int date)：设置日历字段YEAR、MONTH和DAY_OF_MONTH的值。
            Date getTime()：返回一个表示此Calendar时间值（从1970年1月1日00:00:00至现在的毫秒数）的Date对象。
            boolean after(Object when)：判断此Calendar表示的时间是否在指定时间之后，返回判断结果。
            boolean before(Object when)：判断此Calendar表示的时间是否在指定时间之前，返回判断结果。
            int compareTo(Calendar anotherCalendar)：比较两个Calendar对象表示的时间值。
    */
    public static void main(String[] args) throws ParseException {
        // 获得默认的日历对象
        Calendar calendar1 = Calendar.getInstance();
        // 设置日期2018年8月18日
        calendar1.set(1999, 11, 29);

        // 通过日历获得Date对象
        Date date1 = calendar1.getTime();
        System.out.println("格式化前date1 = " + date1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("格式化后date1 = " + df.format(date1));
        System.out.println();

        Calendar calendar2 = Calendar.getInstance();
        Date date2 = calendar1.getTime();
        // 设置日期2000年7月4日
        calendar2.set(Calendar.YEAR, 2000);
        calendar2.set(Calendar.MONTH, 7);
        calendar2.set(Calendar.DATE, 4);

        // 通过日历获得Date对象
        date2 = calendar2.getTime();
        System.out.println("格式化前date2 = " + date2);
        System.out.println("格式化后date2 = " + df.format(date2));
        System.out.println();

        // 时间判断
        System.out.println(date1.after(date2));
        System.out.println(date1.before(date2));
        System.out.println(date1.compareTo(date2));
        System.out.println();

        calendar1.clear();
        calendar2.clear();
        System.out.println("清空date1值 = " + (date1 = calendar1.getTime()));
        System.out.println("清空date2值 = " + (date2 = calendar2.getTime()));
    }
}
