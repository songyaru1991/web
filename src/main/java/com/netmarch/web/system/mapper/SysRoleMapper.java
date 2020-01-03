package com.netmarch.web.system.mapper;

import com.github.pagehelper.Page;
import com.netmarch.web.system.bean.SysResource;
import com.netmarch.web.system.bean.SysResourceRole;
import com.netmarch.web.system.bean.SysRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
@org.apache.ibatis.annotations.Mapper
public interface SysRoleMapper extends Mapper<SysRole> {
    List<SysRole> getAllUserdRoles();

    Page<SysRole> getRoleList(Map<String, Object> map);

    SysRole getRoleById(Integer id);

    List<SysResource> getRoleResources(Integer id);

    int addSysRole(SysRole role);

    void clearByRoleId(Integer id);

    int changechangeRoleResources(List<SysResourceRole> list);

    int editSysRole(SysRole role);

    int getUsedRoleCount(List<Integer> list);

    int delBatch(List<Integer> list);

    int checkRepeatName(SysRole role);

    int checkRepeatCode(SysRole role);

    List<Integer> getRoleIds(Integer id);
}
