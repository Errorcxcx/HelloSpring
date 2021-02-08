package com.cx;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","kuangshen");
        String result = jsonObject.toJSONString();
//        System.out.println(result);
        Transaction multi = jedis.multi();
        try {
            multi.set("user1","1");
            multi.set("user2","2");
            multi.get("user2sdsdsd");

            multi.set("user3","sdsd");

            multi.exec();

        }catch (Exception e){
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user3")+"------");
            jedis.close();
        }



    }
}
