package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

public interface CourseCategoryService {
    /**
     * 查询结点树
     * @param id
     * @return
     */
    public List<CourseCategoryTreeDto> queryTreeNode(String id);
}
