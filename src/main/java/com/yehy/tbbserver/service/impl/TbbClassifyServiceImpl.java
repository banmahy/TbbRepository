package com.yehy.tbbserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TbbClassifyServiceImpl extends ServiceImpl implements TbbClassifyService {


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
        List<TbbClassifyVo> allList = mapper.getAllList();

        List<TbbClassifyVo> parentList = new ArrayList<>();
        List<TbbClassifyVo> childList = new ArrayList<>();

        List<TbbClassifyVo> resultList = new ArrayList<>();
        for (TbbClassifyVo tbbClassifyVo : allList) {
            if ("1".equals(tbbClassifyVo.getParentId())){
                parentList.add(tbbClassifyVo);
            }else {
                childList.add(tbbClassifyVo);
            }
        }
        for (TbbClassifyVo parent : parentList) {
            resultList.add(getChildList(childList, parent));
        }
        return resultList;
    }

    private TbbClassifyVo getChildList(List<TbbClassifyVo> childList, TbbClassifyVo parent){
        List<TbbClassifyVo> childResult = new ArrayList<>();
        for (TbbClassifyVo child : childList) {
            if (child.getParentId().equals(String.valueOf(parent.getId()))){
                childResult.add(getChildList(childList,child));
            }
        }
        parent.setChildren(childResult);
        return parent;
    }

    @Override
    public List<TbbClassifyVo> getParentList(String parentId) {
        return mapper.getParentList(parentId);
    }

    @Override
    public void deleteClassifyByIds(String id) {
        List<String> ids = new ArrayList<>();
        List<TbbClassifyVo> allList = mapper.getAllList();
        ids.add(id);
        List<String> childIdList = getChildIdList(allList, ids, id);
        mapper.deleteClassifyByIds(childIdList);
    }

    private List<String> getChildIdList(List<TbbClassifyVo> childList, List<String> ids, String id){
        for (TbbClassifyVo child : childList) {
            if (child.getParentId().equals(id)){
                ids.add(String.valueOf(child.getId()));
                getChildIdList(childList,ids,String.valueOf(child.getId()));
            }
        }
        return ids;
    }
}
