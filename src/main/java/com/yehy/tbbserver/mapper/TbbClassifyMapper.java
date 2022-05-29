package com.yehy.tbbserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yehy.tbbserver.entity.TbbClassify;
import com.yehy.tbbserver.vo.TbbClassifyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbbClassifyMapper extends BaseMapper<TbbClassify> {

}
