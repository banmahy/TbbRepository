package com.yehy.tbbserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName BaseEntity
 * @Author yehy
 * @Date 2022/5/14 16:26
 **/
@Data
public class BaseEntity {
    private String updUser;

    @TableField(value = "upd_date",fill = FieldFill.INSERT_UPDATE)
    private Date updDate;

    @TableField(value = "delete_flag",fill = FieldFill.INSERT)
    @TableLogic(value = "0",delval = "1")
    private Integer deleteFlag;
}
