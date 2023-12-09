package com.xuecheng.content.service.impl;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

    /**
     * 查询结点树
     * @param id
     * @return
     */
    @Override
    public List<CourseCategoryTreeDto> queryTreeNode(String id) {
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryMapper.selectTreeNodes(id);
        //转化为map
        Map<String, CourseCategoryTreeDto> mapTemp =
           courseCategoryTreeDtos.stream().filter(item->!id.equals(item.getId())).collect(
                   Collectors.toMap(key -> key.getId(), value -> value,  (key1, key2) -> key2)
           );
        //存放结果
        List<CourseCategoryTreeDto> result = new ArrayList<>();

        //开始遍历
        courseCategoryTreeDtos.stream().filter(item->!id.equals(item.getId())).forEach(item-> {
            if(item.getParentid().equals(id)){
                result.add(item);

            }

            CourseCategoryTreeDto parent = mapTemp.get(item.getParentid());
            if(parent != null) {
                if(parent.getChildrenTreeNodes() == null) {
                    parent.setChildrenTreeNodes(new ArrayList<CourseCategoryTreeDto>());
                }
                parent.getChildrenTreeNodes().add(item);
            }
        });

        return result;
    }

}
