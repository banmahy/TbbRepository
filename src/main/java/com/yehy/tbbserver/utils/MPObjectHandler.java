package com.yehy.tbbserver.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName MPObjectHandler
 * @Author yehy
 * @Date 2022/5/21 10:46
 **/
@Component
public class MPObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("updDate", new Date(),metaObject);
        setFieldValByName("deleteFlag", 0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updDate", new Date(),metaObject);

    }
}
