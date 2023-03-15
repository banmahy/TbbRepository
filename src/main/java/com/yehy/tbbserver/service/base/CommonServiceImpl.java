package com.yehy.tbbserver.service.base;

import com.yehy.tbbserver.entity.CodeMaster;
import com.yehy.tbbserver.entity.TbbDocument;
import com.yehy.tbbserver.mapper.CommonMapper;
import com.yehy.tbbserver.service.TbbDocumentService;
import com.yehy.tbbserver.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName CommonServiceImpl
 * @Author yehy
 * @Date 2022/6/12 12:43
 **/
@Service
public class CommonServiceImpl implements CommonService{

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private TbbDocumentService tbbDocumentService;

    @Value("${attachment.path}")
    private String attachmentPath;

    @Override
    public List<CodeMaster> getCodeMst(String typeCd) {
        return commonMapper.getCodeMst(typeCd);
    }

    @Override
    public void attachmentUpload(MultipartFile[] files, Map<String,Object> params) {
        if (files != null) {
            for (MultipartFile file : files) {
                TbbDocument document = new TbbDocument();
                String filename = file.getOriginalFilename();
                File tmpFile = new File(attachmentPath);
                if (!tmpFile.exists()) {
                    tmpFile.mkdirs();
                }
                String replace = UUID.randomUUID().toString().replace("-", "");
                document.setName(filename);
                document.setFileName(replace + "_" + filename);
                document.setPath(attachmentPath);
                document.setFilePath(CommonUtils.convert2Str(params.get("filePath")));
                document.setAttachmentId(CommonUtils.convert2Str(params.get("attachmentId")));
                document.setRecordId(CommonUtils.convert2Str(params.get("recordId")));
                document.setType(CommonUtils.convert2Str(params.get("type")));
                try {
                    file.transferTo(new File(attachmentPath, replace+ "_" + filename ));
                    tbbDocumentService.save(document);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
