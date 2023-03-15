package com.yehy.tbbserver.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author yehy
 */
@Data
public class TbbDocument {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String path;
  private String filePath;
  private String fileName;
  private String name;
  private String type;
  private String comment;
  private String recordId;
  private String attachmentId;
  private String updUser;
  private Date updDate;
}
