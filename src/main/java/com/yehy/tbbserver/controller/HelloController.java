package com.yehy.tbbserver.controller;

import com.yehy.tbbserver.entity.TbbClassify;
import com.yehy.tbbserver.mapper.TbbClassifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HelloController
 * @Author yehy
 * @Date 2021/7/17 14:17
 **/
@RestController
@CrossOrigin
public class HelloController {

    @Autowired
    private TbbClassifyMapper mapper;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public TbbClassify hello() {
        TbbClassify entity = new TbbClassify();
        entity.setMaterialName("test");
        mapper.insert(entity);
        return entity;
    }

    @RequestMapping("user/login")
    public Map login(String data){
        System.out.println("调用接口成功");
        Map token = new HashMap();
        Map token1 = new HashMap();
        token1.put("token","admin-token");
        token.put("code",200);
        token.put("data",token1);
        return token;
    }

    @RequestMapping("/user/info")
    public Map info(String data){
        System.out.println("调用info接口成功");
        Map token = new HashMap();
        Map token1 = new HashMap();
        token1.put("roles",new ArrayList().add("admin"));
        token1.put("introduction","I am a super administrator");
        token1.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        token1.put("name","Super Admin");
        token.put("code",200);
        token.put("data",token1);
        return token;
    }
    @RequestMapping("/user/logout")
    public Map logout(){
        System.out.println("调用logout接口成功");
        Map token = new HashMap();
        token.put("code",200);
        token.put("data","success");
        return token;
    }
}
