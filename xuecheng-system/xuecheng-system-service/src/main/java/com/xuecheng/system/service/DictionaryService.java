package com.xuecheng.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.system.model.po.Dictionary;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author itcast
 * @since 2023-12-09
 */
public interface DictionaryService extends IService<Dictionary> {

    /**
     * 获取所有的code字典
     * @return
     */
    List<Dictionary> queryAll();

    /**
     * 根据code值获取对应的字典
     * @param code
     * @return
     */
    Dictionary getByCode(String code);
}
