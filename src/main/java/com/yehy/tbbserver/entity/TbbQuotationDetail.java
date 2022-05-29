package com.yehy.tbbserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author yehy
 */
@Data
public class TbbQuotationDetail extends BaseEntity{

  @TableId(type = IdType.AUTO)
  private Integer id;
  private Integer quotationId;
  private Integer classifyId;
  private String materialPlace;
  private Double materialAmount;
  private Double materialDiscount;
  private Double totalPrice;
  private String materialRemark;
}
