package com.netmarch.web.system.mapper;

import com.github.pagehelper.Page;
import com.netmarch.web.common.mybatis.MyBaseMapper;
import com.netmarch.web.system.bean.LoginUser;
import com.netmarch.web.system.bean.LoginUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LoginUserMapper extends MyBaseMapper<LoginUser> {

    Page<LoginUser> queryByCondition(LoginUser loginUser);

    Page<LoginUser> getUserList(String keyword);

    LoginUser getUserById(Integer id);

    int editLoginUser(LoginUser loginUser);

    int editUserRoleByUser(LoginUser loginUser);

    int insertUserRole(List<LoginUserRole> list);

    int addLoginUser(LoginUser loginUser);

    int delBatch(List<Integer> list);

    int delUserRoles(List<Integer> list);

    int checkRepeatLoginName(LoginUser loginUser);

    int checkRepeatPoliceNum(LoginUser loginUser);

    List<Integer> getUserRoleIdsByUserId(Integer id);
    LoginUser getLoginUserByLogin(LoginUser loginUser);

    List<LoginUser> getAll();
}
