package com.netmarch.web.system.service;

import com.github.pagehelper.Page;
import com.netmarch.web.system.bean.Dict;

import java.util.List;

public interface DictService {

    Page<Dict> queryByCondition(String keyWord, String parentCode, Integer pageNo);

    int insertDict(Dict dict);

    int updateDict(Dict dict);

    /**
     * 根据类型查询dict
     * @param parentCode
     * @return
     */
    List<Dict> findDictsByParentCode(String parentCode);


    int deleteByIds(Integer[] ids);

    List<Dict> findDictTypeAll();

    Dict queryDictByCode(String code);

    List<Dict> listDictByParentCodeList(List<String> list);

    Dict findDictById(Integer id);
    //查询全部字典数据
    List<Dict> findAll();

}
