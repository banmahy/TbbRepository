package com.yehy.tbbserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yehy.tbbserver.convert.TbbClassifyConvert;
import com.yehy.tbbserver.entity.TbbClassify;
import com.yehy.tbbserver.mapper.TbbClassifyMapper;
import com.yehy.tbbserver.service.TbbClassifyService;
import com.yehy.tbbserver.vo.TbbClassifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TbbClassifyServiceImpl
 * @Author yehy
 * @Date 2022/5/21 9:14
 **/
@Service
public class TbbClassifyServiceImpl implements TbbClassifyService {

    public static class TbbClassifyField {
        static final String LEVEL = "level";
    }

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
        QueryWrapper<TbbClassify> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc(TbbClassifyField.LEVEL);
        List<TbbClassify> tbbClassifies = mapper.selectList(wrapper);
        return TbbClassifyConvert.tbbClassifyConvertToVo(tbbClassifies);
    }
}
