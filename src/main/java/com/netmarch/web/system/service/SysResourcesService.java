package com.netmarch.web.system.service;


import com.github.pagehelper.Page;
import com.netmarch.web.bean.ZtreeObj;
import com.netmarch.web.system.bean.SysResource;

import java.util.List;

public interface SysResourcesService {
    Page<SysResource> getResourcesList(String keyword, SysResource resource);

    List<ZtreeObj> getTree();

    SysResource getResourceById(String pId);

    int save(SysResource resource);

    int editResource(SysResource resource);

    int delBatch(String ids);

    /**
     * 根据roleIds获取资源codes，去重
     * @param roleIds
     * @return
     */
    List<String> getResourceCodesByIds(List<Integer> roleIds);

    List<SysResource> getResourcesListByRoleIds(List<Integer> roleIds);

    int checkRepeatByName(SysResource resource);

    int checkRepeatByCode(SysResource resource);
}
