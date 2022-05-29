package com.yehy.tbbserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author yehy
 */
@Data
public class TbbQuotation extends BaseEntity{

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String projectName;
  private String projectHeader;
  private String projectOwner;
  private String address;
  private String startTime;
  private String endTime;
  private String contractUrl;
  private Double totalPrice;
  private Double projectDiscount;
  private String projectRemark;
}
