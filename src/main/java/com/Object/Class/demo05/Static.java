package com.Object.Class.demo05;

public class Static {
    public static void main(String[] args) {

    }
}

class Account {
    // 实例变量账户金额
    double amount = 0.0;
    // 实例变量账户名
    String owner;
    // 静态变量利率
    static double interestRate = 0.0668;
    /*
        amount和owner成员变量与账户个体有关，称为 “实例变量”
        interestRate成员变量与个体无关，或者说是所有账户个体共享的，这种变量称为 “静态变量”或 “类变量”
    */
    // 静态方法
    public static double interestBy(double amt) {
    //静态方法可以访问静态变量和其他静态方法
        return interestRate * amt;
    }

    // 实例方法
    public String messageWith(double amt) {
        //实例方法可以访问实例变量、实例方法、静态变量和静态方法
        double interest = Account.interestBy(amt);
        StringBuilder sb = new StringBuilder();
        // 拼接字符串
        sb.append(owner).append("的利息是").append(interest);
        // 返回字符串
        return sb.toString();
    }

    // 静态代码块
    static {
        System.out.println("静态代码块被调用...");
        // 初始化静态变量
        interestRate = 0.0668;
    }

}

class myAccount {
    public static void main(String[] args) {
        // 访问静态变量
        System.out.println(Account.interestRate);
        // 访问静态方法
        System.out.println(Account.interestBy(1000));
        Account myAccount = new Account(); // Account静态代码块是在第一次加载Account类时调用
        // 访问实例变量
        myAccount.amount = 1000000;
        myAccount.owner = "Tony";
        // 访问实例方法
        System.out.println(myAccount.messageWith(1000));
        // 通过实例访问静态变量
        System.out.println(myAccount.interestRate);
    }
}
