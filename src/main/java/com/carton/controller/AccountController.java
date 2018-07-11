package com.carton.controller;

import com.carton.model.Account;
import com.carton.model.CartonStock;
import com.carton.service.AccountService;
import com.carton.service.CartonCategoryService;
import com.carton.service.CartonStockService;
import com.carton.util.BaseBeanUtil;
import com.carton.vo.AccountVO;
import com.carton.vo.CartonStockVO;
import com.carton.vo.base.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/************************************************************
 * @Description:
 * @Author: zhengrui
 * @Date 2018-06-28 10:35
 ************************************************************/

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/accountList")
    public String getCartonStockList(Model model,
                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "5") Integer pageSize,
                                     @RequestParam(required = false) String nameParam) {
        Map<String, Object> params = new HashMap<>();
        params.put("nameParam", nameParam);

        PageInfo<Account> pageInfo = accountService.getAccountList(pageNum, pageSize, params);
        model.addAttribute("accountList", BaseBeanUtil.convertAccountList2VOs(pageInfo.getList()));
        setPageInfo2Model(model, pageInfo);

        //回显表单自定义搜索项
        model.addAttribute("nameParam", nameParam == null ? "" : nameParam);

        return "account/account_list";
    }

    @RequestMapping(value = "/toAddPage", method = RequestMethod.GET)
    public String toAddPage() {
        return "account/account_add";
    }

    @RequestMapping(value = "/toEditPage", method = RequestMethod.GET)
    public String toEditPage(Model model, @RequestParam("id") Integer id) {
        Account account = accountService.getAccountById(id);
        AccountVO accountVO = BaseBeanUtil.convertAccount2VO(account);
        model.addAttribute("account", accountVO);
        return "account/account_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public Result addAccount(AccountVO accountVO) {
        Account account = BaseBeanUtil.convertAccountVO2Entity(accountVO);
        return accountService.addAccount(account);
    }

    @ResponseBody
    @RequestMapping(value = "/editAccount", method = RequestMethod.POST)
    public Result editAccount(AccountVO accountVO) {
        Account account = BaseBeanUtil.convertAccountVO2Entity(accountVO);
        return accountService.editAccount(account);
    }

}
