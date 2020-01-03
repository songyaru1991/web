package com.netmarch.web.system.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;

import com.netmarch.web.bean.JsonResult;
import com.netmarch.web.bean.Login;
import com.netmarch.web.common.controller.BaseController;
import com.netmarch.web.system.bean.Dict;
import com.netmarch.web.system.bean.StaticObj;
import com.netmarch.web.system.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Login
@Controller
@Slf4j
@RequestMapping("dict")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @GetMapping("list")
    public String list(String keyWord,String parentCode,
                       @RequestParam(value = "pageNo",defaultValue = "1",required = false) Integer pageNo,
                        Model model){
        try {
            Page<Dict> dicts = dictService.queryByCondition(keyWord, StringUtils.isEmpty(parentCode) ? "-1":parentCode,pageNo);
            model.addAttribute("list",dicts);
            List<Dict> dictTypes = dictService.findDictTypeAll();
            model.addAttribute("dictTypes", JSONArray.toJSONString(dictTypes));
        } catch (Exception e) {
            log.info(e.toString());
        }

        return "system/dict/list";
    }

    /**
     * 添加页面
     * @param model
     * @return
     */
    @GetMapping("add")
    public String add(Model model){
        List<Dict> dictTypes = dictService.findDictTypeAll();
        model.addAttribute("dictTypes", JSONArray.toJSONString(dictTypes));
        return "system/dict/add";
    }

    @GetMapping("addType")
    public String addType(){
        return "system/dict/addType";
    }

    /**
     * 编辑页面
     * @param model
     * @return
     */
    @GetMapping("edit")
    public String edit(Model model, Integer id){
        Dict dict = dictService.findDictById(id);
        Dict pDict = dictService.queryDictByCode(dict.getParentCode());
        model.addAttribute("bean",dict);
        model.addAttribute("pDict",pDict);
        List<Dict> dictTypes = dictService.findDictTypeAll();
        model.addAttribute("dictTypes", JSONArray.toJSONString(dictTypes));
        return "system/dict/edit";
    }

    @GetMapping("view/{id}")
    public String view(Model model, @PathVariable Integer id){
        Dict dict = dictService.findDictById(id);
        Dict pDict = dictService.queryDictByCode(dict.getParentCode());
        model.addAttribute("bean",dict);
        model.addAttribute("pDict",pDict);
        return "system/dict/view";
    }

    @GetMapping("editType")
    public String editType(Model model, Integer id){
        Dict dict = dictService.findDictById(id);
        model.addAttribute("bean",dict);
        return "system/dict/editType";
    }

    /**
     * 保存字典
     * @param dict
     * @return
     */
    @PostMapping
    @ResponseBody
    public JsonResult save(Dict dict){
        log("字典管理","新增","新增字典");
        try {
            Dict dictExist = dictService.queryDictByCode(dict.getCode());
            if (dictExist != null){
                return errorResult("字典编码已存在");
            }
            dict.setCreateTime(new Date());
            dict.setCreater(1);
            int result = dictService.insertDict(dict);
            if(result <= 0){
                return errorResult(StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            log.info(e.toString());
            return errorResult(StaticObj.UPDATE_MSG_ERROR);
        }
        INIT_DICT();
        return successResult(StaticObj.UPDATE_MSG_SUCCESS,"/dict/list");
    }

    @PutMapping
    @ResponseBody
    public JsonResult update(Dict dict, HttpServletRequest request){
        log("字典管理","更新","更新字典");
        try {
            Dict dictExist = dictService.queryDictByCode(dict.getCode());
            if (dictExist != null && !dictExist.getId().equals(dict.getId())){
                return errorResult("字典编码已存在");
            }
            dict.setUpdateTime(new Date());
            dict.setUpdater(1);
            int result = dictService.updateDict(dict);
            if(result <= 0){
                return errorResult(StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            log.info(e.toString());
            return errorResult(StaticObj.UPDATE_MSG_ERROR);
        }
        INIT_DICT();
        return successResult(StaticObj.UPDATE_MSG_SUCCESS,"/dict/list");
    }

    @DeleteMapping("{ids}")
    @ResponseBody
    public JsonResult delete(@PathVariable("ids") Integer[] ids){
        log("字典管理","删除","删除字典");
        try {
            int result = dictService.deleteByIds(ids);
            if(result <= 0){
                return errorResult(StaticObj.UPDATE_MSG_ERROR);
            }
        } catch (Exception e) {
            log.info(e.toString());
            return errorResult(StaticObj.UPDATE_MSG_ERROR);
        }
        INIT_DICT();
        return successResult(StaticObj.UPDATE_MSG_SUCCESS,"/dict/list");
    }
}
