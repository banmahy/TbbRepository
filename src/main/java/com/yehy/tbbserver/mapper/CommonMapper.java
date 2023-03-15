package com.yehy.tbbserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yehy.tbbserver.entity.CodeMaster;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonMapper extends BaseMapper {
    List<CodeMaster> getCodeMst(@Param("typeCd") String typeCd);
}
