package com.netmarch.web.system.mapper;

import com.github.pagehelper.Page;
import com.netmarch.web.common.mybatis.MyBaseMapper;
import com.netmarch.web.system.bean.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictMapper extends MyBaseMapper<Dict> {

    Page<Dict> queryByCondition(@Param("keyWord") String keyWord, @Param("parentCode") String parentCode);

    List<Dict> findDictsByParentCode(@Param("parentCode") String parentCode);

    Dict queryDictByCode(@Param("code") String code);

    List<Dict> listDictByParentCodeList(List<String> list);

    Dict findDictById(@Param("id") Integer id);

    int deleteByIds(@Param("ids") Integer[] ids);

    List<Dict> findAll();
}
