package com.Object.Enum;

public class commonlyUsedMethod {
    /*
        所有枚举类都继承java.lang.Enum类，Enum中定义了一些枚举中常用的方法：
            int ordinal()：返回枚举常量的顺序。这个顺序根据枚举常量声明的顺序而定，顺序从零开始
            枚举类型[] values()：静态方法，返回一个包含全部枚举常量的数组
            枚举类型 valueOf(String str)：静态方法，str是枚举常量对应的字符串，返回一个包含枚举类型实例
    */
    public static void main(String[] args) {
        // 返回一个包含全部枚举常量的数组
        WeekDays[] allValues = WeekDays.values();

        // 遍历枚举常量数值
        for (WeekDays value : allValues) {
            System.out.printf("%d - %s\n", value.ordinal(), value);
        }

        // 创建WeekDays对象
        WeekDays day1 = WeekDays.FRIDAY;
        WeekDays day2 = WeekDays.valueOf("FRIDAY");
        System.out.println(day1 == WeekDays.FRIDAY);
        System.out.println(day1.equals(WeekDays.FRIDAY));
        System.out.println(day1 == day2);
        /*
            提示：在Java类引用类型进行比较时，有两种比较方法==和equals，
            ==比较的是两个引用是否指向同一个对象，equals是比较对象内容是否相同。
            但是，枚举引用类型中==和equals都是一样的，都是比较两个引用是否指向同一个实例，
            枚举类中每个枚举常量无论何时都只有一个实例
        */
    }
}
