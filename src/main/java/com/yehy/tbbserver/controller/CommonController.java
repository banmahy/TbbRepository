package com.yehy.tbbserver.controller;

import com.yehy.tbbserver.constants.HttpStatusConstants;
import com.yehy.tbbserver.entity.CodeMaster;
import com.yehy.tbbserver.service.base.CommonService;
import com.yehy.tbbserver.utils.RespJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CommonController
 * @Author yehy
 * @Date 2022/6/12 12:52
 **/
@RestController
@CrossOrigin
@RequestMapping("tbbCommon")
@Slf4j
public class CommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping("/getCodeMst")
    private RespJson<List<CodeMaster>> getCodeMst(@RequestParam String typeCd){
        try {
            List<CodeMaster> codeMstList = commonService.getCodeMst(typeCd);
            return RespJson.newSuccess("查询成功",codeMstList);
        } catch (Exception e) {
            log.error("getCodeMst Error:",e);
            return RespJson.newFail(HttpStatusConstants.SERVER_ERROR,"查询失败");
        }
    }

    @RequestMapping("/attachmentUpload")
    private RespJson attachmentUpload(@RequestParam("files") MultipartFile [] files,HttpServletRequest request){
        HashMap<String, Object> params = new HashMap<>();
        try {
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/images/";
            params.put("filePath",filePath);
            params.put("attachmentId",request.getParameter("attachmentId"));
            params.put("recordId",request.getParameter("recordId"));
            params.put("type",request.getParameter("type"));
            params.put("comment",request.getParameter("comment"));

            commonService.attachmentUpload(files,params);
            return RespJson.newSuccess("上传成功");
        } catch (Exception e) {
            log.error("attachmentUpload Error:",e);
            return RespJson.newFail(HttpStatusConstants.SERVER_ERROR,"附件上传失败");
        }
    }

}
