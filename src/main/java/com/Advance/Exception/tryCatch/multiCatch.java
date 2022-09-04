package com.Advance.Exception.tryCatch;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 多 catch代码块
public class multiCatch {
    /*
        如果try代码块中有很多语句会发生异常，而且发生的异常种类又很多。那么可以在try后面跟有多个catch代码块
        在多个catch代码情况下，当一个catch代码块捕获到一个异常时，其他的catch代码块就不再进行匹配。

        注意：当捕获的多个异常类之间存在父子关系时，捕获异常顺序与 catch代码块的顺序有关。
            一般先捕获子类，后捕获父类，否则子类捕获不到。
    */

    public static void main(String[] args) {
        Date date = readDate();
        System.out.println("读取的日期 = " + date);
    }
    public static Date readDate() {
        FileInputStream readfile = null;
        InputStreamReader ir = null;
        BufferedReader in = null;
        try {
            // 调用FileInputStream构造方法可以会发生FileNotFoundException异常
            readfile = new FileInputStream("readme.txt");
            ir = new InputStreamReader(readfile);
            in = new BufferedReader(ir);
            // 读取文件中的一行数据
            // 调用BufferedReader输入流的readLine()方法可以会发生IOException异常
            String str = in.readLine();
            if (str == null) {
                return null;
            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(str);
            return date;
        } catch (FileNotFoundException e) {
            // FileNotFoundException异常是IOException异常的子类，应该先 FileNotFoundException捕获，
            System.out.println("处理FileNotFoundException...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        }
        /*
        如果将FileNotFoundException和IOException捕获顺序调换，如下：
        catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("处理FileNotFoundException...");
            e.printStackTrace();
        }
        那么第二个catch代码块永远不会进入，FileNotFoundException异常处理永远不会执行。

        ParseException异常与IOException和FileNotFoundException异常没有父子关系，
        捕获ParseException异常位置可以随意放置。
        */
        catch (ParseException e) {
            System.out.println("处理ParseException...");
            e.printStackTrace();
        }

        /*
            如果多个不同类型发异常，要求捕获后都是调用同一个方法，那么在Java 7之后可以把这些异常一起合并处理
            例如上面的代码可以改为：
            try {
                // 可能会发生异常的语句
            } catch ( IOException | ParseException e ){
                e.printStackTrace();
            }
            ？？？：为什么不写成 FileNotFoundException | IOException | ParseException 呢？
            这是因为由于FileNotFoundException属于IOException异常，IOException异常可以捕获它的所有子类异常了。
        */

        return null;
    }
}
