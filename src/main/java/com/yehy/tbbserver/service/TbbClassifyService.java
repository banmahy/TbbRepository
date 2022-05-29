package com.yehy.tbbserver.service;

import com.yehy.tbbserver.entity.TbbClassify;
import com.yehy.tbbserver.vo.TbbClassifyVo;

import java.util.List;

/**
 * @ClassName TbbClassifyService
 * @Author yehy
 * @Date 2022/5/21 9:14
 **/
public interface TbbClassifyService {
    /**
     * 保存&更新
     * @param entity
     */
    void save(TbbClassify entity);

    /**
     * 查询
     * @return
     */
    List<TbbClassifyVo> getAllList();
}
