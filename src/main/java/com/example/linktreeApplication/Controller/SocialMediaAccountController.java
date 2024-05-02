package com.example.linktreeApplication.Controller;

import com.example.linktreeApplication.Entity.SocialMediaAccount;
import com.example.linktreeApplication.Service.SocialMediaAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SocialMediaAccountController {

    @Autowired
    private SocialMediaAccountService socialMediaAccountService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<SocialMediaAccount> socialMediaAccountList = socialMediaAccountService.findAll();
        model.addAttribute("listAccounts", socialMediaAccountList);
        return "index";
    }

    @GetMapping("/new")
    public String showNewAccountForm(Model model) {
        model.addAttribute("account", new SocialMediaAccount());
        return "new_account";
    }

    @PostMapping("/save")
    public String saveAccount(SocialMediaAccount account) {
        socialMediaAccountService.save(account);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable("id") Long id) {
        socialMediaAccountService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editAccount(@PathVariable("id") Long id, Model model) {
        SocialMediaAccount account = socialMediaAccountService.findById(id);
        model.addAttribute("account", account);
        return "edit_account";
    }

    @PostMapping("update/{id}")
    public String updateAccount(@PathVariable("id") Long id, SocialMediaAccount accountDetails) {
        SocialMediaAccount account = socialMediaAccountService.findById(id);
        if (account != null) {
            account.setName(accountDetails.getName());
            account.setUrl(accountDetails.getUrl());
            socialMediaAccountService.save(account);
        }
        return "redirect:/";
    }
}
