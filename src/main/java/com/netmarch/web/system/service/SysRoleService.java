package com.netmarch.web.system.service;


import com.github.pagehelper.Page;
import com.netmarch.web.bean.JsonResult;
import com.netmarch.web.system.bean.SysResource;
import com.netmarch.web.system.bean.SysRole;

import java.util.List;

public interface SysRoleService {
    List<SysRole> getAllUserdRoles();

    Page<SysRole> getRoleList(SysRole role, String keyword);

    SysRole getRoleById(Integer id);

    List<SysResource> getRoleResources(Integer id);

    int addSysRole(SysRole role);

    int editSysRole(SysRole role);

    JsonResult delBatch(String ids);

    int checkRepeatName(SysRole role);

    int checkRepeatCode(SysRole role);
    List<Integer> getRoleIds(Integer id);

}
