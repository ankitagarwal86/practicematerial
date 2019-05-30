package com.learn.selfstudy.web;

import com.learn.selfstudy.domain.Product;
import com.learn.selfstudy.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAdmin(Model model) {
        List<Product> products = adminService.getProducts();
        model.addAttribute("products", products);
        return "admin";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addProduct")
    public String addProduct() {
        return "redirect:/admin";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteProduct")
    public String deleteProduct() {
        return "redirect:/admin";
    }

}