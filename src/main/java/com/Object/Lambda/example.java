package com.Object.Lambda;

// 示例:假设有这样的一个需求：设计一个通用方法，能够实现两个数值的加法和减法运算。Java中方法不能
//单独存在，必须定义在类或接口中，考虑是一个通用方法，可以设计一个数值计算接口，其中定义该
//通用方法，代码如下：
public class example {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;

        // 实现加法计算Calculable对象
        Calculable f1 = calculate('+');
        // 实现减法计算Calculable对象
        Calculable f2 = calculate('-');

        // 调用calculateInt方法进行加法计算
        System.out.printf("%d + %d = %d \n", n1, n2,
                f1.calculateInt(n1, n2));

        // 调用calculateInt方法进行减法计算
        System.out.printf("%d - %d = %d \n", n1, n2,
                f2.calculateInt(n1, n2));
    }

    /*
     * 通过操作符，进行计算
     * @param opr 操作符
     * @return 实现Calculable接口对象
     */
    public static Calculable calculate(char opr) {
        Calculable result;
        if (opr == '+') {
            // 匿名内部类实现Calculable接口
            result = new Calculable() {
                // 实现加法运算
                @Override
                public int calculateInt(int a, int b) {
                    return a + b;
                }
            };
        } else {
            // 匿名内部类实现Calculable接口
//            result = new Calculable() {
//                // 实现减法运算
//                @Override
//                public int calculateInt(int a, int b) {
//                    return a - b;
//                }
//            };

            // Lambda表达式实现Calculable接口
            result = (int a, int b) -> {
              return a-b;
            };

            /*
                通过以上示例的演变，可以给Lambda表达式一个定义：
                Lambda表达式是一个匿名函数（方法）代码块，可以作为表达式、方法参数和方法返回值。

                Lambda表达式标准语法形式如下：
                (参数列表) -> {
                    //Lambda表达式体
                }
                其中，Lambda表达式参数列表与接口中方法参数列表形式一样，Lambda表达式体实现接口方法。
            */
        }
        return result;
    }
}