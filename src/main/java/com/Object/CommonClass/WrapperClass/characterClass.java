package com.Object.CommonClass.WrapperClass;

// Character类
public class characterClass {
    /*
            Character类是char类型的包装类。Character类常用方法如下：
                Character(char value)：构造方法，通过char值创建一个新的Character对象。
                char charValue()：返回此Character对象的值。
                int compareTo(Character anotherCharacter)：方法返回值是int，如果返回值是0，则相等；
                    如果返回值小于0，则此对象小于参数对象；如果返回值大于0，则此对象大于参数对象。
        */
    public static void main(String[] args) {
        // 创建数值为'A'的Character对象
        Character objChar1 = new Character('A');
        // 从Character对象返回char值
        char ch = objChar1.charValue();
        System.out.println(ch);
        // 字符比较
        Character objChar2 = new Character('C');
        int result = objChar1.compareTo(objChar2);
        // result = -2，表示objChar1小于objChar2
        if (result < 0) {
            System.out.println("objChar1小于objChar2");
        }
    }
}
