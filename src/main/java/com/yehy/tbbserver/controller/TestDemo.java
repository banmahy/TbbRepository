package com.yehy.tbbserver.controller;

import net.sf.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestDemo
 * @Author yehy
 * @Date 2022/6/9 21:53
 **/
public class TestDemo {

    public static void main(String[] args) {
        try {
            List<String> strings = Files.readAllLines(Paths.get("D:\\桌面\\match_rules.txt"), StandardCharsets.UTF_8);
            String join = String.join("", strings);
            JSONObject jsonObject = JSONObject.fromObject(join);
            Iterator iterator = jsonObject.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry next = (Map.Entry) iterator.next();
                JSONObject object = JSONObject.fromObject(next.getValue());
                System.out.println(object.optString("peItemField"));
                System.out.println(object.optString("columnName"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
