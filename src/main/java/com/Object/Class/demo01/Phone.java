package com.Object.Class.demo01;

/*
定义一个类，用来模拟“手机”事物。
属性：品牌、价格、颜色
行为：打电话、发短信

对应到类当中：
成员变量（属性）：
    String brand; // 品牌
    double price; // 价格
    String color; // 颜色
成员方法（行为）：
    public void call(String who) {} // 打电话
    public void sendMessage() {} // 群发短信
 */
public class Phone {

    // 成员变量
    String brand; // 品牌
    double price; // 价格
    String color; // 颜色

    // 成员方法
    public void call(String who) {
        System.out.println("给" + who + "打电话");
    }

    public void sendMessage() {
        System.out.println("群发短信");
    }
}

class PhoneOne {
    public static void main(String[] args) {
        // 根据Phone类，创建一个名为one的对象
        // 格式：类名称 对象名 = new 类名称();
        Phone one = new Phone();
        System.out.println(one.brand); // null
        System.out.println(one.price); // 0.0
        System.out.println(one.color); // null
        System.out.println("=========");

        one.brand = "苹果";
        one.price = 8388.0;
        one.color = "黑色";
        System.out.println(one.brand); // 苹果
        System.out.println(one.price); // 8388.0
        System.out.println(one.color); // 黑色
        System.out.println("=========");

        one.call("乔布斯"); // 给乔布斯打电话
        one.sendMessage(); // 群发短信
    }
}

class PhoneTwo {
    public static void main(String[] args) {
        Phone one = new Phone();
        System.out.println(one.brand); // null
        System.out.println(one.price); // 0.0
        System.out.println(one.color); // null
        System.out.println("=========");

        one.brand = "苹果";
        one.price = 8388.0;
        one.color = "黑色";
        System.out.println(one.brand); // 苹果
        System.out.println(one.price); // 8388.0
        System.out.println(one.color); // 黑色
        System.out.println("=========");

        one.call("乔布斯"); // 给乔布斯打电话
        one.sendMessage(); // 群发短信
        System.out.println("=========");

        Phone two = new Phone();
        System.out.println(two.brand); // null
        System.out.println(two.price); // 0.0
        System.out.println(two.color); // null
        System.out.println("=========");

        two.brand = "三星";
        two.price = 5999.0;
        two.color = "蓝色";
        System.out.println(two.brand); // 三星
        System.out.println(two.price); // 5999.0
        System.out.println(two.color); // 蓝色
        System.out.println("=========");

        two.call("欧巴"); // 给欧巴打电话
        two.sendMessage(); // 群发短信
    }
}

class PhoneSame {
    public static void main(String[] args) {
        Phone one = new Phone();
        System.out.println(one.brand); // null
        System.out.println(one.price); // 0.0
        System.out.println(one.color); // null
        System.out.println("=========");

        one.brand = "苹果";
        one.price = 8388.0;
        one.color = "黑色";
        System.out.println(one.brand); // 苹果
        System.out.println(one.price); // 8388.0
        System.out.println(one.color); // 黑色
        System.out.println("=========");

        one.call("乔布斯"); // 给乔布斯打电话
        one.sendMessage(); // 群发短信
        System.out.println("=========");

        // 将one当中保存的对象地址值赋值给two
        Phone two = one;
        System.out.println(two.brand); // 苹果
        System.out.println(two.price); // 8388.0
        System.out.println(two.color); // 黑色
        System.out.println("=========");

        two.brand = "三星";
        two.price = 5999.0;
        two.color = "蓝色";
        System.out.println(two.brand); // 三星
        System.out.println(two.price); // 5999.0
        System.out.println(two.color); // 蓝色
        System.out.println("=========");

        two.call("欧巴"); // 给欧巴打电话
        two.sendMessage(); // 群发短信
    }
}

class PhoneParam {
    public static void main(String[] args) {
        Phone one = new Phone();
        one.brand = "苹果";
        one.price = 8388.0;
        one.color = "土豪金";

        method(one); // 传递进去的参数其实就是地址值
    }
    public static void method(Phone param) {
        System.out.println(param.brand); // 苹果
        System.out.println(param.price); // 8388.0
        System.out.println(param.color); // 土豪金
    }
}

class PhoneReturn {
    public static void main(String[] args) {
        Phone two = getPhone();
        System.out.println(two.brand); // 苹果
        System.out.println(two.price); // 8388.0
        System.out.println(two.color); // 玫瑰金
    }
    public static Phone getPhone() {
        Phone one = new Phone();
        one.brand = "苹果";
        one.price = 8388.0;
        one.color = "玫瑰金";
        return one;
    }
}