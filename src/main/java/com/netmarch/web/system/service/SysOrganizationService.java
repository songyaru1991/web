package com.netmarch.web.system.service;


import com.netmarch.web.system.bean.SysOrganization;

import java.util.List;

public interface SysOrganizationService {
    List<SysOrganization> getAllUsedOrg();

    SysOrganization getOrganizationById(Integer id);

    List<SysOrganization> getOrganizationName();

}
