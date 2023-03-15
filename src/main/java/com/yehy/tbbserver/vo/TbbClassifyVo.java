package com.yehy.tbbserver.vo;

import com.yehy.tbbserver.entity.TbbDocument;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName TbbClassifyVo
 * @Author yehy
 * @Date 2022/5/22 10:11
 **/
@Data
public class TbbClassifyVo {
    private Integer id;
    private String parentId;
    private String materialName;
    private BigDecimal price;
    private String materialUnit;
    private String materialUnitNm;
    private String description;
    private List<TbbClassifyVo> children;
    private List<TbbDocument> imageList;

}
