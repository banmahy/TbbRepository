package com.yehy.tbbserver.service.impl;

import com.yehy.tbbserver.convert.TbbClassifyConvert;
import com.yehy.tbbserver.entity.TbbClassify;
import com.yehy.tbbserver.mapper.TbbClassifyMapper;
import com.yehy.tbbserver.service.TbbClassifyService;
import com.yehy.tbbserver.vo.TbbClassifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TbbClassifyServiceImpl
 * @Author yehy
 * @Date 2022/5/21 9:14
 **/
@Service
public class TbbClassifyServiceImpl implements TbbClassifyService {

    @Autowired
    private TbbClassifyMapper mapper;

    @Override
    public void save(TbbClassify entity) {
        if (entity.getId() != null){
            mapper.updateById(entity);
        }else {
            mapper.insert(entity);
        }
    }

    @Override
    public List<TbbClassifyVo> getAllList() {
        List<TbbClassify> tbbClassifies = mapper.selectList(null);
        return TbbClassifyConvert.tbbClassifyConvertToVo(tbbClassifies);
    }
}
