package com.netmarch.web.system.controller;

import com.github.pagehelper.Page;

import com.netmarch.web.bean.JsonResult;
import com.netmarch.web.bean.Login;
import com.netmarch.web.bean.ResultCodes;
import com.netmarch.web.common.controller.BaseController;
import com.netmarch.web.common.thymeleaf.AuthElementTagProcessor;
import com.netmarch.web.system.bean.LoginUser;
import com.netmarch.web.system.bean.StaticObj;
import com.netmarch.web.system.bean.SysOrganization;
import com.netmarch.web.system.bean.SysRole;
import com.netmarch.web.system.service.LoginUserService;
import com.netmarch.web.system.service.SysOrganizationService;
import com.netmarch.web.system.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Login
@Controller
@RequestMapping("user/*")
@Slf4j
public class LoginUserController extends BaseController {

    @Autowired
    private LoginUserService loginUserService;
    @Autowired
    private SysOrganizationService sysOrganizationService;
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("list")
    public String list(LoginUser user, String keyword, Model model){
        try {
            Page<LoginUser> loginUsers = loginUserService.getUserList(user, keyword);
            model.addAttribute("list", loginUsers);
            model.addAttribute("keyword", keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/list";
    }

    /**
     * 添加页面
     * @param model
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(Model model){
        List<SysOrganization> orgList = sysOrganizationService.getAllUsedOrg();
        List<SysRole> roleList = sysRoleService.getAllUserdRoles();
        model.addAttribute("orgList",orgList);
        model.addAttribute("roleList",roleList);
        return "user/add";
    }

    /**
     * 编辑页面
     * @param model
     * @return
     */
    @GetMapping("toEdit")
    public String toEdit(Model model, Integer id){
        LoginUser user = loginUserService.getUserById(id);
        String roleIds = loginUserService.getUserRoleIdsByUserId(id);
        user.setRoleIds(roleIds);
        List<SysOrganization> orgList = sysOrganizationService.getAllUsedOrg();
        List<SysRole> roleList = sysRoleService.getAllUserdRoles();
        model.addAttribute("bean",user);
        model.addAttribute("orgList",orgList);
        model.addAttribute("roleList",roleList);
        return "user/edit";
    }

    /**
     * 保存用户
     * @param loginUser
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonResult save(LoginUser loginUser){
        try {
            int countName = loginUserService.checkRepeatLoginName(loginUser);
            if(countName > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_NAME);
            }
            int countPoliceNum = loginUserService.checkRepeatPoliceNum(loginUser);
            if(countPoliceNum > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_POLICENUM);
            }
            BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
            loginUser.setPassword(encoder.encode(loginUser.getPassword()));
            loginUser.setCreater(1);
            int result = loginUserService.addLoginUser(loginUser);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.UPDATE_MSG_ERROR);
            }
            result = loginUserService.insertUserRole(loginUser);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCodes.ERROR, StaticObj.UPDATE_MSG_ERROR);
        }
        AuthElementTagProcessor.initAuthMap();
        return new JsonResult(ResultCodes.SUCCESS, StaticObj.UPDATE_MSG_SUCCESS, "/user/list");
    }

    @RequestMapping("/edit")
    @ResponseBody
    public JsonResult edit(LoginUser loginUser){
        try {
            int countName = loginUserService.checkRepeatLoginName(loginUser);
            if(countName > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_NAME);
            }
            int countPoliceNum = loginUserService.checkRepeatPoliceNum(loginUser);
            if(countPoliceNum > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_POLICENUM);
            }
            loginUser.setUpdater(1);
            int result = loginUserService.editLoginUser(loginUser);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
            }
            result = loginUserService.editUserRoleByUser(loginUser);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
        }
        AuthElementTagProcessor.initAuthMap();
        return new JsonResult(ResultCodes.SUCCESS,StaticObj.UPDATE_MSG_SUCCESS, "/user/list");
    }

    @RequestMapping("delBatch")
    @ResponseBody
    public JsonResult delBatch(String ids){
        try {
            int result = loginUserService.delBatch(ids);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
            }
            result = loginUserService.delUserRoles(ids);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
        }
        AuthElementTagProcessor.initAuthMap();
        return new JsonResult(ResultCodes.SUCCESS,StaticObj.UPDATE_MSG_SUCCESS, "/user/list");
    }
}
