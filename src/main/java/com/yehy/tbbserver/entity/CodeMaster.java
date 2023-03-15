package com.yehy.tbbserver.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 * @author yehy
 */

@Data
public class CodeMaster extends BaseEntity {

  @TableId(type=IdType.AUTO)
  private Integer id;
  private String typeNm;
  private String typeCd;
  private String codeKey1;
  private String codeName1;
  private Integer cdIndex;

}
