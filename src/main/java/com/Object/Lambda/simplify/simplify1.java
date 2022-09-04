package com.Object.Lambda.simplify;

// 省略参数类型
// 省略return和大括号
public class simplify1 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;

        // 实现加法计算Calculable对象
        Calculable1 f1 = calculate('+');
        // 实现减法计算Calculable对象
        Calculable1 f2 = calculate('-');

        System.out.printf("%d + %d = %d \n", n1, n2, f1.calculateInt(n1, n2));
        System.out.printf("%d - %d = %d \n", n1, n2, f2.calculateInt(n1, n2));
    }

    /**
     * 通过操作符，进行计算
     * @param opr 操作符
     * @return 实现Calculable接口对象
     */
    public static Calculable1 calculate(char opr) {
        Calculable1 result;
        if (opr == '+') {
//            标准样式
//            result = (int a, int b) -> {
//                return a-b;
//            };
            // 省略参数类型
            result = (a, b) -> {
                return a+b;
            };
        } else {
            result = (a, b) -> {
                return a-b;
            };
            // 省略return和大括号
            result = (a, b) -> a-b;
        }
        return result;
    }
}
