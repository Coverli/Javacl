package com.Advance.Network.DataFormatExchange;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * JSON 解码与编码
 * */
public class DecodingEncoding {
    /**
        JSON和XML真正在进行数据交换时候，它们存在的形式就是一个很长的字符串，
        这个字符串在网络中传输或者存储于磁盘等介质中。
        在传输和存储之前需要把JSON对象转换成为字符串才能传输和存储，这个过程称之为“编码”过程。
        接收方需要将接收到的字符串转换成为JSON对象，这个过程称之为“解码”过程。
        编码和解码过程就像发电报时发送方把语言变成能够传输的符号，而接收时要将符号转换成为能够看懂的语言。
     */
    public static void main (String[] args) {
        DecodingEncoding de = new DecodingEncoding();
        de.encoding();
        de.decoding();
    }

    void encoding () {
        // 通过编码获得如下字符串：{"name": "tony", "age": 30, "a": [1, 3]}

        try {
            // 创建JSONObject（JSON对象）
            JSONObject jsonObject = new JSONObject();
            // 通过put()方法把JSON数据项添加到JSON对象jsonObject
            jsonObject.put("name", "tony");
            jsonObject.put("age", 30);
            // 创建JSONArray（JSON数组）
            JSONArray jsonArray = new JSONArray();
            // 是向JSON数组中添加1和3两个元素
            jsonArray.put(1).put(3);
            // 将JSON数组jsonArray作为JSON对象jsonObject的数据项添加到JSON对象
            jsonObject.put("a", jsonArray);
            // 编码完成，jsonObject.toString()是将JSON对象转换为字符串，真正完成了JSON编码过程
            System.out.println(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void decoding () {
        // 将{"name":"tony", "age":30, "a":[1, 3]}解码成JSON对象或数组

        String jsonString = "{\"name\":\"tony\", \"age\":30, \"a\":[1, 3]}";
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            // 通过getString()方法从JSON对象中按照名称取出JSON中对应的数据
            String name = jsonObject.getString("name");
            System.out.println("name : " + name);
            int age = jsonObject.getInt("age");
            System.out.println("age : " + age);
            // 通过getJSONArray()方法取出一个JSON数组对象
            JSONArray jsonArray = jsonObject.getJSONArray("a");
            // 通过getInt()方法取出JSON数组元素
            int n1 = jsonArray.getInt(0);
            System.out.println("数组a第一个元素 : " + n1);
            int n2 = jsonArray.getInt(1);
            System.out.println("数组a第二个元素 : " + n2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
        注意：如果按照规范的JSON文档要求，每个JSON数据项目的“名称”必须使用双引号括起来，
            不能使用单引号或没有引号。在下面的代码文档中，“名称”省略了双引号，
            该文档在其他平台解析时会出现异常，而在Java平台则可以通过，这得益于Java解析类库的强大，
            但这并不是规范的做法。如果与其他平台进行数据交换时，
            采用这种不规范的JSON文档进行数据交换，那么很有可能会导致严重的问题发生。
        不规范写法：
        {ResultCode:0,Record:[
        {ID:'1',CDate:'2012-12-23',Content:'发布iOSBook0',UserID:'tony'},
        {ID:'2',CDate:'2012-12-24',Content:'发布iOSBook1',UserID:'tony'}]}
     */
}
