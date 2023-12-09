package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Api(value = "课程类型控制器", tags = "课程类型控制器")
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;
    /**
     * 请求全部课程类型树
     * @return
     */
    @GetMapping("/course-category/tree-nodes")
    @ApiOperation("请求全部课程类型")
    public List<CourseCategoryTreeDto> queryTreeNodes() {
        return courseCategoryService.queryTreeNode("1");
    }


}
