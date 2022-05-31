package com.yehy.tbbserver.convert;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yehy.tbbserver.entity.TbbClassify;
import com.yehy.tbbserver.vo.TbbClassifyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TbbClassifyConvert {

    public static List<TbbClassifyVo> tbbClassifyConvertToVo(List<TbbClassify> tbbClassifies) {
        List<TbbClassifyVo> tbbClassifyVos = new ArrayList<>();
        for (TbbClassify tbbClassify : tbbClassifies) {
            TbbClassifyVo tbbClassifyVo = new TbbClassifyVo();
            BeanUtils.copyProperties(tbbClassify,tbbClassifyVo);
            tbbClassifyVos.add(tbbClassifyVo);
        }

        Map<String, List<TbbClassifyVo>> collect = new HashMap<>();
        for (TbbClassifyVo tbbClassifyVo : tbbClassifyVos) {
            if (StringUtils.isEmpty(tbbClassifyVo.getParentId())){
                continue;
            }
            List<TbbClassifyVo> classifyList = collect.getOrDefault(tbbClassifyVo.getParentId(), new ArrayList<>());
            classifyList.add(tbbClassifyVo);
            collect.put(tbbClassifyVo.getParentId(), classifyList);
        }
        return tbbClassifyVos.stream()
                .peek(x -> x.setChildren(collect.get(x.getClassifyId())))
                .collect(Collectors.toList());
    }
}
