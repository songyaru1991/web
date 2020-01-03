package com.netmarch.web.system.service.impl;

import com.netmarch.web.common.mybatis.DatabaseContextHolder;
import com.netmarch.web.common.mybatis.DatabaseType;
import com.netmarch.web.system.bean.SysOrganization;
import com.netmarch.web.system.mapper.SysOrganizationMapper;
import com.netmarch.web.system.service.SysOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrganizationServiceImpl implements SysOrganizationService {

    @Autowired
    SysOrganizationMapper sysOrganizationMapper;

    @Override
    public List<SysOrganization> getAllUsedOrg() {
        DatabaseContextHolder.close();
        DatabaseContextHolder.setDatabaseType(DatabaseType.ONEDB);
        return sysOrganizationMapper.getAllUsedOrg();
    }

    @Override
    public SysOrganization getOrganizationById(Integer id) {
        DatabaseContextHolder.close();
        DatabaseContextHolder.setDatabaseType(DatabaseType.ONEDB);
        return sysOrganizationMapper.getOrganizationById(id);
    }

    @Override
    public List<SysOrganization> getOrganizationName() {
        DatabaseContextHolder.close();
        DatabaseContextHolder.setDatabaseType(DatabaseType.ONEDB);
        return sysOrganizationMapper.getOrganizationName();
    }
}
