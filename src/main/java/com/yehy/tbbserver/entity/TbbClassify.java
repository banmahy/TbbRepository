package com.yehy.tbbserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yehy
 */
@Data
@TableName("tbb_classify")
public class TbbClassify extends BaseEntity {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String parentId;
  private String materialName;
  private BigDecimal price;
  private String materialUnit;
  /**
   * 施工工艺标准
   */
  private String description;
}
