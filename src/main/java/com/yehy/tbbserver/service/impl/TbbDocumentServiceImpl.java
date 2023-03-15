package com.yehy.tbbserver.service.impl;

import com.yehy.tbbserver.entity.TbbDocument;
import com.yehy.tbbserver.mapper.TbbDocumentMapper;
import com.yehy.tbbserver.service.TbbDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName TbbDocumentServiceImpl
 * @Author yehy
 * @Date 2022/7/4 21:39
 **/
@Service
public class TbbDocumentServiceImpl implements TbbDocumentService {

    @Autowired
    private TbbDocumentMapper mapper;

    @Override
    public void save(TbbDocument entity) {
        if (entity.getId() != null){
            mapper.updateById(entity);
        }else {
            mapper.insert(entity);
        }
    }
}
