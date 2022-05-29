package com.yehy.tbbserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 * @author yehy
 */
@Data
public class TbbClassifyProperty extends BaseEntity{

  @TableId(type = IdType.AUTO)
  private Integer id;
  private Integer classifyId;
  private String propertyNameCd;
  private String propertyValueCd;
  private String propertyName;
}
