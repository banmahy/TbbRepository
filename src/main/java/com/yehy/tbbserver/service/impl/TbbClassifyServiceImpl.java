package com.yehy.tbbserver.service.impl;

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
        List<TbbClassifyVo> parentList = mapper.getAllList(1);
        List<TbbClassifyVo> tempList = new ArrayList<>();
        for (TbbClassifyVo parent:parentList){
            TbbClassifyVo entity = getChildList(parentList, parent);
            tempList.add(entity);
        }
        return tempList;
    }

    private TbbClassifyVo getChildList(List<TbbClassifyVo> parentList, TbbClassifyVo parentEntity){
        for (TbbClassifyVo parent : parentList) {
            List<TbbClassifyVo> childList = mapper.getAllList(parent.getId());
            if (childList.size() > 0){
                parent.setChildren(childList);
                getChildList(childList,parentEntity);
            }
        }
        return parentEntity;
    }


}
