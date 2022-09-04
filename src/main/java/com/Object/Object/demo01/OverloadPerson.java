package com.Object.Object.demo01;

import java.util.Date;

// 构造方法重载
public class OverloadPerson {
    // 名字
    private String name;
    // 年龄
    private int age;
    // 出生日期
    private Date birthDate;
    public OverloadPerson(String n, int a, Date d) {
        name = n;
        age = a;
        birthDate = d;
    }
    public OverloadPerson(String n, int a) {
        name = n;
        age = a;
    }
    public OverloadPerson(String n, Date d) {
        name = n;
        age = 30;
        birthDate = d;
    }
    public OverloadPerson(String n) {
        name = n;
        age = 30;
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("名字: ").append(name).append('\n');
        sb.append("年龄: ").append(age).append('\n');
        sb.append("出生日期: ").append(birthDate).append('\n');
        return sb.toString();
    }
}
