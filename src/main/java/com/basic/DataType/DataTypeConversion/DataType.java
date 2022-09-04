/*
	数据类型转换
	自动类型（隐式）转换
		规则：数据范围从小到大转换，小-->大：int-->long-->float-->double
	强制类型（显式）转换
		格式：范围小的类型 范围小的变量名 = （范围小的类型）原本范围大的数据;
*/
package com.basic.DataType.DataTypeConversion;

public class DataType {

    public static void main(String[] args) {
        new DataType().auto();
        new DataType().constraint();
    }

    public void auto () {
        int    num1_1 = 1;
        long   num1_2 = 2;	    // int-->long
        float  num1_3 = 3L;	    // long-->float
        double num1_4 = 4.2F;	// float-->double
        System.out.println ( "自动类型转换结果：" );
        System.out.println ( num1_1 );
        System.out.println ( num1_2 );
        System.out.println ( num1_3 );
        System.out.println ( num1_4 );
    }

    public void constraint () {
		/*
			int    num2_1 = 1;
			long   num2_2 = 2L;
			float  num2_3 = 3.3F;
		*/
        double num2_4 = 4.44;

        float num2_3 = (float) num2_4;
        long  num2_2 = (long)  num2_3;
        int   num2_1 = (int)   num2_2;
        System.out.println ( "强制类型转换结果：" );
        System.out.println ( num2_1 );
        System.out.println ( num2_2 );
        System.out.println ( num2_3 );
        System.out.println ( num2_4 );
    }
}