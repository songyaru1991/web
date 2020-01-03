package com.netmarch.web.system.controller;

import com.github.pagehelper.Page;
import com.netmarch.web.bean.JsonResult;
import com.netmarch.web.bean.Login;
import com.netmarch.web.bean.ResultCodes;
import com.netmarch.web.bean.ZtreeObj;
import com.netmarch.web.common.controller.BaseController;
import com.netmarch.web.common.thymeleaf.AuthElementTagProcessor;
import com.netmarch.web.system.bean.StaticObj;
import com.netmarch.web.system.bean.SysResource;
import com.netmarch.web.system.service.SysResourcesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Login
@Controller
@RequestMapping("resource/*")
@Slf4j
public class SysResourcesController extends BaseController {

    @Autowired
    private SysResourcesService sysResourcesService;


    @RequestMapping("list")
    public String list(SysResource resource, String keyword, Model model){
        try {
            Page<SysResource> resourcesList = sysResourcesService.getResourcesList(keyword, resource);
            model.addAttribute("list", resourcesList);
            model.addAttribute("keyword", keyword);
            model.addAttribute("parentId", resource.getParentId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "resource/list";
    }

    @RequestMapping("/ztree")
    @ResponseBody
    public List<ZtreeObj> getTree(){
        List<ZtreeObj> list = sysResourcesService.getTree();
        return list;
    }



    /**
     * 添加页面
     * @param model
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(Model model, String pId){
        pId = StringUtils.isEmpty(pId) ? "1" : pId;
        String pName = "";
        if(!"1".equals(pId)){
            pName = sysResourcesService.getResourceById(pId).getName();
        }else{
            pName = "根结点";
        }
        model.addAttribute("pName", pName);
        model.addAttribute("pId", pId);
        return "resource/add";
    }

    /**
     * 编辑页面
     * @param model
     * @return
     */
    @GetMapping("toEdit")
    public String toEdit(Model model, String id){
        SysResource resouce = sysResourcesService.getResourceById(id);
        model.addAttribute("bean", resouce);
        return "resource/edit";
    }

    /**
     * 保存
     * @param resource
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonResult save(SysResource resource){
        try {
            int countName = sysResourcesService.checkRepeatByName(resource);
            if(countName > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_NAME);
            }
            int countCode = sysResourcesService.checkRepeatByCode(resource);
            if(countCode > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_CODE);
            }
            int result = sysResourcesService.save(resource);
            if(result < 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCodes.ERROR, StaticObj.UPDATE_MSG_ERROR);
        }
        AuthElementTagProcessor.initAuthMap();
        return new JsonResult(ResultCodes.SUCCESS, StaticObj.UPDATE_MSG_SUCCESS,
                "/resource/list?parentId="+resource.getParentId());
    }

    @RequestMapping("/edit")
    @ResponseBody
    public JsonResult edit(SysResource resource){
        try {
            int countName = sysResourcesService.checkRepeatByName(resource);
            if(countName > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_NAME);
            }
            int countCode = sysResourcesService.checkRepeatByCode(resource);
            if(countCode > 0){
                return new JsonResult(ResultCodes.ERROR, StaticObj.REPEAT_MSG_CODE);
            }
            int result = sysResourcesService.editResource(resource);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
        }
        AuthElementTagProcessor.initAuthMap();
        return new JsonResult(ResultCodes.SUCCESS,StaticObj.UPDATE_MSG_SUCCESS,
                "/resource/list?parentId="+resource.getParentId());
    }

    @RequestMapping("delBatch")
    @ResponseBody
    public JsonResult delBatch(String ids, Integer pId){
        try {
            int result = sysResourcesService.delBatch(ids);
            if(result <= 0){
                return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(ResultCodes.ERROR,StaticObj.UPDATE_MSG_ERROR);
        }
        AuthElementTagProcessor.initAuthMap();
        return new JsonResult(ResultCodes.SUCCESS,StaticObj.UPDATE_MSG_SUCCESS,
                "/resource/list?parentId="+pId);
    }
}
