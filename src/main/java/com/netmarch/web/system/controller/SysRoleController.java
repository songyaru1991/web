package com.netmarch.web.system.controller;

import com.github.pagehelper.Page;
import com.netmarch.web.bean.JsonResult;
import com.netmarch.web.bean.Login;
import com.netmarch.web.bean.ResultCodes;
import com.netmarch.web.common.controller.BaseController;
import com.netmarch.web.common.thymeleaf.AuthElementTagProcessor;
import com.netmarch.web.system.bean.StaticObj;
import com.netmarch.web.system.bean.SysResource;
import com.netmarch.web.system.bean.SysRole;
import com.netmarch.web.system.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Login
@Controller
@RequestMapping("/role/*")
@Slf4j
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("list")
    public String list(SysRole role, String keyword, Model model){
        try {
            Page<SysRole> roles = sysRoleService.getRoleList(role, keyword);
            model.addAttribute("list", roles);
            model.addAttribute("keyword", keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "role/list";
    }

    /**
     * 添加页面
     * @param model
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(Model model){
        return "role/add";
    }

    /**
     * 编辑页面
     * @param model
     * @return
     */
    @GetMapping("toEdit")
    public String toEdit(Model model, Integer id){
        SysRole bean = sysRoleService.getRoleById(id);
        List<SysResource> resources = sysRoleService.getRoleResources(id);
        List<Integer> resids = new ArrayList<>();
        for (SysResource sr : resources) {
            resids.add(sr.getId());
        }
        model.addAttribute("bean",bean);
        model.addAttribute("resids",resids);
        return "role/edit";
    }

    /**
     * 保存
     * @param role
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonResult save(SysRole role){
        try {
            int countName = sysRoleService.checkRepeatName(role);
            if(countName > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_NAME);
            }
            int countCode = sysRoleService.checkRepeatCode(role);
            if(countCode > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_CODE);
            }
            role.setCreateUser(1);
            int result = sysRoleService.addSysRole(role);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCodes.ERROR, StaticObj.UPDATE_MSG_ERROR);
        }
        AuthElementTagProcessor.initAuthMap();
        return new JsonResult(ResultCodes.SUCCESS, StaticObj.UPDATE_MSG_SUCCESS, "/role/list");
    }

    @RequestMapping("/edit")
    @ResponseBody
    public JsonResult edit(SysRole role){
        try {
            int countName = sysRoleService.checkRepeatName(role);
            if(countName > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_NAME);
            }
            int countCode = sysRoleService.checkRepeatCode(role);
            if(countCode > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_CODE);
            }
            role.setUpdateUser(1);
            int result = sysRoleService.editSysRole(role);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
        }
        AuthElementTagProcessor.initAuthMap();
        return new JsonResult(ResultCodes.SUCCESS,StaticObj.UPDATE_MSG_SUCCESS, "/role/list");
    }

    @RequestMapping("delBatch")
    @ResponseBody
    public JsonResult delBatch(String ids){
        try {
            JsonResult result = sysRoleService.delBatch(ids);
            AuthElementTagProcessor.initAuthMap();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
        }
    }
}
