package com.netmarch.web.system.service;

import com.github.pagehelper.Page;
import com.netmarch.web.system.bean.LoginUser;

import java.util.List;

public interface LoginUserService {

    Page<LoginUser> getUserList(LoginUser user, String keyword);

    LoginUser getUserById(Integer id);

    int editLoginUser(LoginUser loginUser);

    int editUserRoleByUser(LoginUser loginUser);

    int insertUserRole(LoginUser loginUser);

    int addLoginUser(LoginUser loginUser);

    int delBatch(String ids);

    int delUserRoles(String ids);

    int checkRepeatLoginName(LoginUser loginUser);

    int checkRepeatPoliceNum(LoginUser loginUser);

    String getUserRoleIdsByUserId(Integer id);

    LoginUser getLoginUserByLogin(LoginUser loginUser);

    List<LoginUser> getAll();
}
