package com.Object.Enum;

public class statement {
    public static void main(String[] args) {
        // day工作日变量
        WeekDays day = WeekDays.FRIDAY;
        //打印day默认调用枚举toString()方法
        System.out.println(day);
        //调用枚举实例方法
        System.out.println(day.getInfo());
        //调用枚举静态方法
        System.out.println(WeekDays.getStaticVar());
    }
}
