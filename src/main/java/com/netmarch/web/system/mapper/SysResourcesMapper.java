package com.netmarch.web.system.mapper;

import com.github.pagehelper.Page;
import com.netmarch.web.bean.ZtreeObj;
import com.netmarch.web.common.mybatis.MyBaseMapper;
import com.netmarch.web.system.bean.SysResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface SysResourcesMapper extends MyBaseMapper<SysResource> {
    Page<SysResource> getResourcesList(Map<String, Object> keyword);

    List<ZtreeObj> getTree();

    SysResource getResourceById(int i);

    int save(SysResource resource);

    int editResource(SysResource resource);

    int deleteResourceRole(List<Integer> list);

    int delBath(List<Integer> list);

    List<String> getResourceCodesByIds(List<Integer> roleIds);

    List<SysResource> getResourcesListByRoleIds(List<Integer> roleIds);

    int checkRepeatByName(SysResource resource);

    int checkRepeatByCode(SysResource resource);
}
