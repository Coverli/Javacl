package com.Object.Lambda.simplify;

// 省略参数小括号（一个参数时）
public class simplify2 {
    public static void main(String[] args) {
        int n1 = 10;
        // 实现二次方计算Calculable对象
        Calculable2 f1 = calculate(2);
        // 实现三次方计算Calculable对象
        Calculable2 f2 = calculate(3);
        System.out.printf("%d二次方 = %d \n", n1, f1.calculateInt(n1));
        System.out.printf("%d三次方 = %d \n", n1, f2.calculateInt(n1));
    }
    /**
     * 通过幂计算
     * @param power 幂
     * @return 实现Calculable接口对象
     */
    public static Calculable2 calculate(int power) {
        Calculable2 result;
        if (power == 2) {
            // Lambda表达式实现Calculable接口
            result = (int a) -> { //标准形式
                return a * a;
            };
        } else {
            result = a -> { //省略形式
                return a * a * a;
            };
        }
        return result;
    }
}
