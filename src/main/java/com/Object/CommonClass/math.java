package com.Object.CommonClass;

public class math {
    /*
        Java语言是彻底地面向对象语言，哪怕是进行数学运算也封装到一个类中的，这个类是java.lang.Math，
        Math类是final的不能被继承。Math类中包含用于进行基本数学运算的方法，如指数、对数、平方根和三角函数等。
        这些方法分类如下：
            01. 舍入方法
                static double ceil(double a)：返回大于或等于a最小整数。
                static double floor(double a)：返回小于或等于a最大整数。
                static int round(float a)：四舍五入方法。
            02. 最大值和最小值
                static int min(int a, int b)：取两个int整数中较小的一个整数。
                static int min(long a, long b)：取两个long整数中较小的一个整数。
                static int min(float a, float b)：取两个float浮点数中较小的一个浮点数。
                static int min(double a, double b)：取两个double浮点数中较小的一个浮点数。
                    max方法取两个数中较大的一个数，max方法与min方法参数类似也有4个版本，这里不再赘述。
            03. 绝对值
                static int abs(int a)：取int整数a的绝对值。
                static long abs(long a)：取long整数a的绝对值。
                static float abs(float a)：取float浮点数a的绝对值。
                static double abs(double a)：取double浮点数a的绝对值。
            04. 三角函数：
                static double sin(double a)：返回角的三角正弦。
                static double cos(double a)：返回角的三角余弦。
                static double tan(double a)：返回角的三角正切。
                static double asin(double a)：返回一个值的反正弦。
                static double acos(double a)：返回一个值的反余弦。
                static double atan(double a)：返回一个值的反正切。
                static double toDegrees(double angrad)：将弧度转换为角度。
                static double toRadians(double angdeg)：将角度转换为弧度。
            05. 对数运算：static double log(double a)，返回a的自然对数。
            06. 平方根：static double sqrt(double a)，返回a的正平方根。
            07. 幂运算：static double pow(double a, double b)，返回第一个参数的第二个参数次幂的值。
            08. 计算随机值：static double random()，返回大于等于 0.0 且小于 1.0随机数。
            09. 常量
                圆周率PI
                自然对数的底数E。
    */
    public static void main(String[] args) {
        double[] nums = { 1.4, 1.5, 1.6 };
        // 测试最大值和最小值
        System.out.printf("min(%.1f, %.1f) = %.1f\n", nums[1], nums[2], Math.min(nums[1], nums[2]));
        System.out.printf("max(%.1f, %.1f) = %.1f\n", nums[1], nums[2], Math.max(nums[1], nums[2]));
        System.out.println();

        // 测试三角函数
        // 1π弧度 = 180°
        System.out.printf("toDegrees(0.5π) = %f\n", Math.toDegrees(0.5 * Math.PI));
        System.out.printf("toRadians(180/π) = %f\n", Math.toRadians(180 / Math.PI));
        System.out.println();

        // 测试平方根
        System.out.printf("sqrt(%.1f) = %f\n", nums[2], Math.sqrt(nums[2]));
        System.out.println();

        // 测试幂运算
        System.out.printf("pow(8, 3) = %f\n", Math.pow(8, 3));
        System.out.println();

        // 测试计算随机值
        System.out.printf("0.0~1.0之间的随机数 = %f\n", Math.random());
        System.out.println();

        // 测试舍入
        for (double num : nums) {
            display(num);
        }

        // 自然对数
        System.out.println(Math.E);

        display(3.14);
    }

    // 测试舍入方法
    public static void display(double n) {
        System.out.printf("ceil(%.1f) = %.1f\n", n, Math.ceil(n));
        System.out.printf("floor(%.1f) = %.1f\n", n, Math.floor(n));
        System.out.printf("round(%.1f) = %d\n", n, Math.round(n));
        System.out.println();
    }
}
