package com.yehy.tbbserver.service.base;

import com.yehy.tbbserver.entity.CodeMaster;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CommonService {
    List<CodeMaster> getCodeMst(String typeCd);
    void attachmentUpload(MultipartFile[] files, Map<String,Object> params);
}
