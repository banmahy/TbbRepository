package com.yehy.tbbserver.controller;

import com.yehy.tbbserver.constants.HttpStatusConstants;
import com.yehy.tbbserver.entity.TbbClassify;
import com.yehy.tbbserver.form.TbbClassifyForm;
import com.yehy.tbbserver.service.TbbClassifyService;
import com.yehy.tbbserver.utils.BeanUtils;
import com.yehy.tbbserver.utils.RespJson;
import com.yehy.tbbserver.vo.TbbClassifyVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName TbbClassifyController
 * @Author yehy
 * @Date 2022/5/16 21:20
 **/
@RestController
@CrossOrigin
@RequestMapping("tbbClassify")
@Slf4j
public class TbbClassifyController {

    @Autowired
    private TbbClassifyService service;

    @RequestMapping(value = "/saveData")
    public RespJson saveData(@RequestBody TbbClassifyForm form){
        try{
            TbbClassify entity = BeanUtils.copy(form, TbbClassify.class);
            service.save(entity);
            return RespJson.newSuccess("保存成功");
        }catch (Exception e){
            log.error("saveData Error :",e);
            return RespJson.newFail(HttpStatusConstants.SERVER_ERROR,"保存失败,请重试");
        }
    }

    @RequestMapping("/getAllList")
    public RespJson<List<TbbClassifyVo>> getAllList(){
        try {
            List<TbbClassifyVo> data = service.getAllList();
            return RespJson.newSuccess("查询成功",data);
        } catch (Exception e) {
            log.error("getAllList Error:",e);
            return RespJson.newFail(HttpStatusConstants.SERVER_ERROR,"查询失败");
        }
    }

    @RequestMapping("/getParentList")
    public RespJson<List<TbbClassifyVo>> getParentList(@RequestParam String parentId){
        try {
            List<TbbClassifyVo> data = service.getParentList(parentId);
            return RespJson.newSuccess("查询成功",data);
        } catch (Exception e) {
            log.error("getParentList Error:",e);
            return RespJson.newFail(HttpStatusConstants.SERVER_ERROR,"获取父节点列表失败");
        }
    }

    @RequestMapping("/deleteClassifyByIds")
    public RespJson deleteClassifyByIds(@RequestParam String id){
        try {
            service.deleteClassifyByIds(id);
            return RespJson.newSuccess("删除成功");
        } catch (Exception e) {
            log.error("deleteClassifyByIds Error:",e);
            return RespJson.newFail(HttpStatusConstants.SERVER_ERROR,"删除失败");
        }
    }
}
