package com.yehy.tbbserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yehy.tbbserver.entity.TbbClassify;
import com.yehy.tbbserver.vo.TbbClassifyVo;

import java.util.List;

/**
 * @ClassName TbbClassifyService
 * @Author yehy
 * @Date 2022/5/21 9:14
 **/
public interface TbbClassifyService extends IService {
    /**
     * 保存&更新
     * @param entity
     */
    void save(TbbClassify entity);

    /**
     * 递归查询Tree结构
     * @return
     */
    List<TbbClassifyVo> getAllList();

    /**
     * 获取父节点
     * @return
     */
    List<TbbClassifyVo> getParentList(String parentId);

    /**
     * 递归删除
     */
    void deleteClassifyByIds(String id);
}
