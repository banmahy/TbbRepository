package com.yehy.tbbserver.form;

import lombok.Data;

/**
 * @ClassName TbbClassifyForm
 * @Author yehy
 * @Date 2022/5/16 21:19
 **/
@Data
public class TbbClassifyForm {
    private Integer id;
    private Integer parentId;
    private String materialName;
    private Double price;
    private String materialUnit;
    private String description;
    private Integer imageId;
}
