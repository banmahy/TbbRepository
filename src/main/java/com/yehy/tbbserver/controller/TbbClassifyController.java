package com.yehy.tbbserver.controller;

import com.yehy.tbbserver.entity.TbbClassify;
import com.yehy.tbbserver.form.TbbClassifyForm;
import com.yehy.tbbserver.service.TbbClassifyService;
import com.yehy.tbbserver.utils.BeanUtils;
import com.yehy.tbbserver.utils.RespJson;
import com.yehy.tbbserver.vo.TbbClassifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TbbClassifyController
 * @Author yehy
 * @Date 2022/5/16 21:20
 **/
@RestController
@CrossOrigin
public class TbbClassifyController {

    @Autowired
    private TbbClassifyService service;

    @RequestMapping(value = "tbbClassify/saveData")
    public RespJson<TbbClassify> saveData(@RequestBody TbbClassifyForm form){
        TbbClassify entity = BeanUtils.copy(form, TbbClassify.class);
        service.save(entity);
        return RespJson.newSuccess("保存成功");
    }

    @RequestMapping("tbbClassify/getAllList")
    public RespJson<List<TbbClassifyVo>> getAllList(){
        List<TbbClassifyVo> data = service.getAllList();
        return RespJson.newSuccess("查询成功",data);
    }
}
