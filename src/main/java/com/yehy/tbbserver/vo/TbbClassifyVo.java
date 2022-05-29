package com.yehy.tbbserver.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName TbbClassifyVo
 * @Author yehy
 * @Date 2022/5/22 10:11
 **/
@Data
public class TbbClassifyVo {
    private Integer id;
    private Integer parentId;
    private String materialName;
    private Double price;
    private String materialUnit;
    private String description;
    private Integer imageId;
    private List<TbbClassifyVo> children;
}
