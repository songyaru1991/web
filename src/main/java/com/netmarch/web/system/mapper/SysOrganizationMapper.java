package com.netmarch.web.system.mapper;

import com.netmarch.web.common.mybatis.MyBaseMapper;
import com.netmarch.web.system.bean.SysOrganization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysOrganizationMapper extends MyBaseMapper<SysOrganization> {

    List<SysOrganization> getAllUsedOrg();

    SysOrganization getOrganizationById(@Param("id") Integer id);

    List<SysOrganization> getOrganizationName();

}
